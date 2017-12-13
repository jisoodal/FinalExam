package kr.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.blog.domain.BlogVo;
import kr.board.domain.BoardVo;
import kr.util.StringUtil;

public class BlogDao {

	private static BlogDao instance = new BlogDao();
	
	public static BlogDao getInstance(){
		return instance;
	}
	private BlogDao(){}

		private Connection getConnection()throws Exception{
			Context initCtx = new InitialContext();
			          
			//�ʼ�
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
			return ds.getConnection();
		}
		

		private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn){
			if(rs!=null)try{rs.close();}catch(SQLException e){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
			if(conn!=null)try{conn.close();}catch(SQLException e){}
		}
		

		public void insertBoard(BlogVo blogVo)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			int cnt = 0;
			try{
				conn = getConnection();
				sql ="insert into s_blogboard(nb_num, nb_subject, nb_content, mem_id, nb_hit, nb_register,nb_filename) "
						+ " values((select NVL(MAX(nb_num)+1, 1) FROM s_blogboard),?,?,?,?,sysdate,?)";
				
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt, blogVo.getNb_subject());
				pstmt.setString(++cnt, blogVo.getNb_content());
				pstmt.setString(++cnt, blogVo.getMem_id());
				pstmt.setInt(++cnt, blogVo.getNb_hit());
				pstmt.setString(++cnt, blogVo.getNb_filename());
				
				
				System.out.println(">>>>>>>>>>>>>>>"+blogVo.getNb_subject());
				System.out.println(">>>>>>>>>>>>>>>"+blogVo.getNb_content());
				
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
				
				if(keyword == null || "".equals(keyword)){
					//��ü�� ����
					sql = "select count(*) from s_blogboard ";
					pstmt = conn.prepareStatement(sql);
				}else{
					sql = "select count(*) from s_blogboard where " + keyfield + " like ?";
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

		public List<BlogVo> getListBoard(int start, int end, String keyfield, String keyword)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			List<BlogVo> list = null;
			String sql = "";
			int cnt = 0;
			try{
				conn = getConnection();
				if(keyword == null || "".equals(keyword)){
				sql = "select * from (select a.*, rownum rnum "
						+ "from(select * from s_blogboard order by nb_num"
						+ " desc)a) where rnum >=? and rnum<=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(++cnt, start);
				pstmt.setInt(++cnt, end);
				}else{
					//�˻��� ����
					sql = "select * from (select a.*, rownum rnum "
							+ "from(select * from s_blogboard where "
							+ keyfield+ " like ? order by nb_num"
							+ " desc)a) where rnum >=? and rnum<=?";	
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(++cnt, "%"+keyword+"%");
					pstmt.setInt(++cnt, start);
					pstmt.setInt(++cnt, end);
				}
				rs = pstmt.executeQuery();
				list = new ArrayList<BlogVo>();
				while(rs.next()){
					BlogVo blogVo = new BlogVo();
					blogVo.setNb_num(rs.getInt("nb_num"));
					blogVo.setNb_subject(StringUtil.useNoHtml(rs.getString("nb_subject")));
					blogVo.setMem_id(rs.getString("mem_id"));
					blogVo.setNb_hit(rs.getInt("nb_hit"));
					blogVo.setNb_register(rs.getDate("nb_register"));
			
					//board.setReply_cnt(rs.getInt("re_cnt"));
					
					list.add(blogVo);
				}
						
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(rs, pstmt, conn);
			}
			
			return list;
		}

		public BlogVo getBoard(int nb_num)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BlogVo blogVo =null;
			String sql ="";
			
			try{
				conn = getConnection();
				sql="select * from s_blogboard where nb_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nb_num);
				rs = pstmt.executeQuery();
				if(rs.next()){
					blogVo = new BlogVo();
					blogVo.setNb_num(rs.getInt("nb_num"));
					blogVo.setNb_subject(rs.getString("nb_subject"));
					blogVo.setNb_content(rs.getString("nb_content"));
					blogVo.setMem_id(rs.getString("mem_id"));
					blogVo.setNb_hit(rs.getInt("nb_hit"));
					blogVo.setNb_register(rs.getDate("nb_register"));
					blogVo.setNb_filename(rs.getString("nb_filename"));	
				}
				
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(rs, pstmt, conn);
			}			
			return blogVo;
		}

		public void updateReadcount(int nb_num)throws Exception{
			Connection conn = null;	
			PreparedStatement pstmt = null;
			String sql="";
			
			try{
				conn =getConnection();
				sql="update s_blogboard set nb_hit = nb_hit+1 where nb_num =?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, nb_num);
				pstmt.executeUpdate();
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
			}
		}

		public void updateBoard(BlogVo blogVo)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "";
			int cnt =0;
			try{
				conn = getConnection();
				sql ="update s_blogboard set nb_subject=?,nb_content=?,nb_filename=? where nb_num=?";				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt, blogVo.getNb_subject());
				pstmt.setString(++cnt, blogVo.getNb_content());
				pstmt.setString(++cnt, blogVo.getNb_filename());
				pstmt.setInt(++cnt, blogVo.getNb_num());
				
				pstmt.executeUpdate();
			
			}catch(Exception e){
				throw new Exception(e);
			}finally{
				executeClose(null, pstmt, conn);
				
			}
		}

		public void deleteBoard(int nb_num)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			String sql = "";
			try{
				conn = getConnection();
				sql = "delete from s_blogboard where nb_num=?";
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
