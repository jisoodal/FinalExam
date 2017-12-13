package kr.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.review.domain.ReviewVo;
import kr.util.StringUtil;

public class ReviewDao {
	//�̱��� ����
	private static ReviewDao instance = new ReviewDao();
	
	public static ReviewDao getInstance(){
		return instance;
	}
	private ReviewDao(){}
	
		//context.xm1���� ���������� �;�鿩 Ŀ�ؼ�Ǯ�κ��� �ɳؼ��� �Ҵ����
		//Connection �޼ҵ带 ���� jsp���� JDBC���� 1,2�ܰ谡 ����Ǵ°Ͱ� ����
		private Connection getConnection()throws Exception{
			Context initCtx = new InitialContext();
			          
			//�ʼ�
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
			return ds.getConnection();
		}
		
		//�ڿ�����
		private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn){
			if(rs!=null)try{rs.close();}catch(SQLException e){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
			if(conn!=null)try{conn.close();}catch(SQLException e){}
		}
		
		//�۵��
		public void insertBoard(ReviewVo reviewVo)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			int cnt = 0;
			try{
				conn = getConnection();
				sql ="insert into s_reviewboard(nb_num, nb_subject, nb_content, mem_id, nb_hit, nb_register,nb_filename) "
						+ " values((select NVL(MAX(nb_num)+1, 1) FROM s_reviewboard),?,?,?,?,sysdate,?)";
				
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt, reviewVo.getNb_subject());
				pstmt.setString(++cnt, reviewVo.getNb_content());
				pstmt.setString(++cnt, reviewVo.getMem_id());
				pstmt.setInt(++cnt, reviewVo.getNb_hit());
				pstmt.setString(++cnt, reviewVo.getNb_filename());
				
				pstmt.executeUpdate();
				
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
			}				
			
		}
		//��ü �� ���� , �˻��� ����
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
				
				if(keyword == null || "".equals(keyword)){
					//��ü�� ����
					sql = "select count(*) from s_reviewboard ";
					pstmt = conn.prepareStatement(sql);
				}else{
					sql = "select count(*) from s_reviewboard where " + keyfield + " like ?";
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
		public List<ReviewVo> getListBoard(int start, int end, String keyfield, String keyword)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			List<ReviewVo> list = null;
			String sql = "";
			int cnt = 0;
			try{
				conn = getConnection();
				if(keyword == null || "".equals(keyword)){
				sql = "select * from (select a.*, rownum rnum "
						+ "from(select * from s_reviewboard order by nb_num"
						+ " desc)a) where rnum >=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(++cnt, start);
				pstmt.setInt(++cnt, end);
				}else{
					//�˻��� ����
					sql = "select * from (select a.*, rownum rnum "
							+ "from(select * from s_reviewboard where "
							+ keyfield+ " like ? order by nb_num"
							+ " desc)a) where rnum >=? and rnum<=?";	
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(++cnt, "%"+keyword+"%");
					pstmt.setInt(++cnt, start);
					pstmt.setInt(++cnt, end);
				}
				rs = pstmt.executeQuery();
				list = new ArrayList<ReviewVo>();
				while(rs.next()){
					ReviewVo reviewVo = new ReviewVo();
					reviewVo.setNb_num(rs.getInt("nb_num"));
					reviewVo.setNb_subject(StringUtil.useNoHtml(rs.getString("nb_subject")));
					reviewVo.setMem_id(rs.getString("mem_id"));
					reviewVo.setNb_hit(rs.getInt("nb_hit"));
					reviewVo.setNb_register(rs.getDate("nb_register"));
			
					//board.setReply_cnt(rs.getInt("re_cnt"));
					
					list.add(reviewVo);
				}
						
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(rs, pstmt, conn);
			}
			
			return list;
		}
		//�ۻ�
		public ReviewVo getBoard(int nb_num)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ReviewVo reviewVo =null;
			String sql ="";
			
			try{
				conn = getConnection();
				sql="select * from s_reviewboard where nb_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nb_num);
				rs = pstmt.executeQuery();
				if(rs.next()){
					reviewVo = new ReviewVo();
					reviewVo.setNb_num(rs.getInt("nb_num"));
					reviewVo.setNb_subject(rs.getString("nb_subject"));
					reviewVo.setNb_content(rs.getString("nb_content"));
					reviewVo.setMem_id(rs.getString("mem_id"));
					reviewVo.setNb_hit(rs.getInt("nb_hit"));
					reviewVo.setNb_register(rs.getDate("nb_register"));
					reviewVo.setNb_filename(rs.getString("nb_filename"));	
				}
				
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(rs, pstmt, conn);
			}			
			return reviewVo;
		}
		//�� ��ȸ�� ����
		public void updateReadcount(int nb_num)throws Exception{
			Connection conn = null;	
			PreparedStatement pstmt = null;
			String sql="";
			
			try{
				conn =getConnection();
				sql="update s_reviewboard set nb_hit = nb_hit+1 where nb_num =?";
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
		public void updateBoard(ReviewVo reviewVo)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			int cnt =0;
			try{
				conn = getConnection();
				sql ="update s_reviewboard set nb_subject=?,nb_content=?,nb_filename=? where nb_num=?";				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt, reviewVo.getNb_subject());
				pstmt.setString(++cnt, reviewVo.getNb_content());
				pstmt.setString(++cnt, reviewVo.getNb_filename());
				pstmt.setInt(++cnt, reviewVo.getNb_num());
				
				pstmt.executeUpdate();
			
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
				
			}
		}
		//�ۻ���
		public void deleteBoard(int nb_num)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			String sql = "";
			try{
				conn = getConnection();
				sql = "delete from s_reviewboard where nb_num=?";
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
	}
