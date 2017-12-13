package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardReply;
import kr.board.domain.BoardVo;
import kr.util.StringUtil;

public class BoardDao {

	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance(){
		return instance;
	}
	private BoardDao(){}
	
		private Connection getConnection()throws Exception{
			Context initCtx = new InitialContext();
			          
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
			return ds.getConnection();
		}
		
		private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn){
			if(rs!=null)try{rs.close();}catch(SQLException e){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
			if(conn!=null)try{conn.close();}catch(SQLException e){}
		}
		
		public void insertBoard(BoardVo boardVo)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			int cnt = 0;
			try{
				conn = getConnection();
				sql ="insert into s_board(nb_num, nb_subject, nb_content, mem_id, nb_hit, nb_register,nb_filename) "
						+ " values((select NVL(MAX(nb_num)+1, 1) FROM s_board),?,?,?,?,sysdate,?)";
				
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt, boardVo.getNb_subject());
				pstmt.setString(++cnt, boardVo.getNb_content());
				pstmt.setString(++cnt, boardVo.getMem_id());
				pstmt.setInt(++cnt, boardVo.getNb_hit());
				pstmt.setString(++cnt, boardVo.getNb_filename());
				
				System.out.println(">>>>>>>>>>>>>>>"+boardVo.getNb_subject());
				System.out.println(">>>>>>>>>>>>>>>"+boardVo.getNb_content());
				
				pstmt.executeUpdate();
				
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
			}				
			
		}

		public int getBoardCount(String keyfield, 
								 String keyword)
							     throws Exception{
			Connection conn = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			int count = 0;
			
			try{
				conn = getConnection();
				
				if(keyword == null || "".equals(keyword)){ //�˻�� ������

					sql = "select count(*) from s_board ";
					pstmt = conn.prepareStatement(sql);
				}else{ //�˻�� ������
					sql = "select count(*) from s_board where " + keyfield + " like ?"; //�˻�� ������
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
				}
				rs=pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(rs, pstmt, conn);
			}
					
			
			return count;			
		}
		//���, �˻��� ���
		public List<BoardVo> getListBoard(int start, int end, String keyfield, String keyword)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			List<BoardVo> list = null;
			String sql = "";
			int cnt = 0;
			try{
				conn = getConnection();
				if(keyword == null || "".equals(keyword)){ //�˻�� ������
				sql = "select * from (select a.*, rownum rnum "
						+ "from(select * from s_board order by nb_num"
						+ " desc)a) where rnum >=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(++cnt, start);
				pstmt.setInt(++cnt, end);
				}else{
					//�˻��� ����
					sql = "select * from (select a.*, rownum rnum "
							+ "from(select * from s_board where "
							+ keyfield+ " like ? order by nb_num"
							+ " desc)a) where rnum >=? and rnum<=?";	
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(++cnt, "%"+keyword+"%");
					pstmt.setInt(++cnt, start);
					pstmt.setInt(++cnt, end);
				}
				rs = pstmt.executeQuery();
				list = new ArrayList<BoardVo>();
				while(rs.next()){
					BoardVo boardVo = new BoardVo();
					boardVo.setNb_num(rs.getInt("nb_num"));
					boardVo.setNb_subject(StringUtil.useNoHtml(rs.getString("nb_subject")));
					boardVo.setMem_id(rs.getString("mem_id"));
					boardVo.setNb_hit(rs.getInt("nb_hit"));
					boardVo.setNb_register(rs.getDate("nb_register"));
			
					//board.setReply_cnt(rs.getInt("re_cnt"));
					
					list.add(boardVo);
				}
						
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(rs, pstmt, conn);
			}
			
			return list;
		}
		//�ۻ�
		public BoardVo getBoard(int nb_num)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BoardVo boardVo =null;
			String sql ="";
			
			try{
				conn = getConnection();
				sql="select * from s_board where nb_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nb_num);
				rs = pstmt.executeQuery();
				if(rs.next()){
					boardVo = new BoardVo();
					boardVo.setNb_num(rs.getInt("nb_num"));
					boardVo.setNb_subject(rs.getString("nb_subject"));
					boardVo.setNb_content(rs.getString("nb_content"));
					boardVo.setMem_id(rs.getString("mem_id"));
					boardVo.setNb_hit(rs.getInt("nb_hit"));
					boardVo.setNb_register(rs.getDate("nb_register"));
					boardVo.setNb_filename(rs.getString("nb_filename"));	
				}
				
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(rs, pstmt, conn);
			}			
			return boardVo;
		}
		//�� ��ȸ�� ����
		public void updateReadcount(int nb_num)throws Exception{
			Connection conn = null;	
			PreparedStatement pstmt = null;
			String sql="";
			
			try{
				conn =getConnection();
				sql="update s_board set nb_hit = nb_hit+1 where nb_num =?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nb_num);
				pstmt.executeUpdate();
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
			}
		}
		//�ۼ���
		public void updateBoard(BoardVo boardVo)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			int cnt =0;
			try{
				conn = getConnection();
				sql ="update s_board set nb_subject=?,nb_content=?,nb_filename=? where nb_num=?";				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt, boardVo.getNb_subject());
				pstmt.setString(++cnt, boardVo.getNb_content());
				pstmt.setString(++cnt, boardVo.getNb_filename());
				pstmt.setInt(++cnt, boardVo.getNb_num());
				
				pstmt.executeUpdate();
			
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
				
			}
		}
		//�� ����
		public void deleteBoard(int nb_num)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			String sql = "";
			try{
				conn = getConnection();
				sql = "delete from s_board where nb_num=?";
				pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, nb_num);
				pstmt2.executeUpdate();
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt2, conn);
				executeClose(null, pstmt, conn);
			}
		}
		
		public void replyInsertBoard(BoardReply boardReply)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql ="";
			int cnt =0;
			try{
				conn = getConnection();
				sql="insert into iboard_reply (re_num,re_content,re_date,re_ip,num,id)"
						+ "values(reply_seq.nextval,?,sysdate,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt, boardReply.getRe_content());
				pstmt.setString(++cnt, boardReply.getRe_ip());
				pstmt.setInt(++cnt, boardReply.getNum());
				pstmt.setString(++cnt, boardReply.getId());
				
				pstmt.executeUpdate();
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
			}
		}
	}
