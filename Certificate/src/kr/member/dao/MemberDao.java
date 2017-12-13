
package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.member.domain.Member;

public class MemberDao {

	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance(){
		return instance;
	}
	
	private MemberDao(){}

	private Connection getConnection()throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = 
				(DataSource)initCtx.lookup(
						"java:comp/env/jdbc/xe");
		return ds.getConnection();
	}
	
	private void executeClose(ResultSet rs, 
			PreparedStatement pstmt, Connection conn){
		if(rs!=null)try{rs.close();}catch(SQLException e){}
		if(pstmt!=null)try{pstmt.close();}catch(SQLException e){}
		if(conn!=null)try{conn.close();}catch(SQLException e){}
	}
	public void insertMember(Member member)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int cnt = 0;
		
		try{
			conn = getConnection();
			//SQL : id,name,passwd,phone,email,zipcode,
			//        address1,address2,reg_date
			sql = "insert into s_member (mem_id,mem_name,mem_pw,"
				+ "mem_cell,mem_email,mem_addr, mem_level, "
				+ "mem_register) values (?,?,?,?,?,?,1,"
				+ "sysdate)";
			//PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			//SQL
			pstmt.setString(++cnt, member.getMem_id());
			pstmt.setString(++cnt, member.getMem_name());
			pstmt.setString(++cnt, member.getMem_pw());
			pstmt.setString(++cnt, member.getMem_cell());
			pstmt.setString(++cnt, member.getMem_email());
			pstmt.setString(++cnt, member.getMem_addr());
		
			
			//SQL
			pstmt.executeUpdate();
			
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			executeClose(null, pstmt, conn);
		}
	}
	
	//ȸ
	public Member getMember(String id)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "";
		
		try{
			conn = getConnection();
			//SQL�� 
			sql = "select * from s_member where mem_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				member = new Member();
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_pw(rs.getString("mem_pw"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_cell(rs.getString("mem_cell"));
				member.setMem_email(rs.getString("mem_email"));
				member.setMem_addr(rs.getString("mem_addr"));				
				member.setMem_register(rs.getDate("mem_register"));
				member.setMem_level(rs.getString("mem_level"));
			}
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			executeClose(rs, pstmt, conn);
		}
		return member;
	}
	
	//ȸ
	public void updateMember(Member member)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int cnt = 0;
		
		try{
			conn = getConnection();
			sql = "update s_member set mem_name=?,mem_pw=?,"
				+ "mem_cell=?,mem_email=?,mem_addr=? where mem_id=?";
				
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getMem_name());
			pstmt.setString(++cnt, member.getMem_pw());
			pstmt.setString(++cnt, member.getMem_cell());
			pstmt.setString(++cnt, member.getMem_email());
			pstmt.setString(++cnt, member.getMem_addr());			
			pstmt.setString(++cnt, member.getMem_id());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			throw new Exception(e);
		}finally{
			executeClose(null, pstmt, conn);
		}
	}
	
	   public void deleteMember(String id)throws Exception{
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      String sql = "";
	      
	      try{
	         conn = getConnection();
	         sql = "delete from s_member where mem_id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         
	         pstmt.executeUpdate();
	      }catch(Exception e){
	         throw new Exception(e);
	      }finally{
	         executeClose(null, pstmt, conn);
	      }
	   }
	   public String findId(String mem_cell){
		   Connection conn =null;
		   PreparedStatement pstmt = null;
		   String sql="";
		   String id="";
		   ResultSet rs=null;
		   try {
			   // 1, 2
			   conn = getConnection();
			   // 3 sql
			   sql="select mem_id from s_member where mem_cell=?";
			   pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, mem_cell);
			   rs=pstmt.executeQuery();
			   
			   if(rs.next()){
				   id=rs.getString(1);
			   }
				 

		   } catch (Exception e) {
			   e.printStackTrace();
		   }finally{
			   executeClose(rs, pstmt, conn);
		   }
		   return id;
	   }
	   public String findPW(String mem_cell){
		   Connection conn =null;
		   PreparedStatement pstmt = null;
		   String sql="";
		   String pw="";
		   ResultSet rs=null;
		   try {
			   // 1, 2
			   conn = getConnection();
			   // 3 sql
			   sql="select mem_pw from s_member where mem_cell=?";
			   pstmt=conn.prepareStatement(sql);
			   pstmt.setString(1, mem_cell);
			   rs=pstmt.executeQuery();
			   
			   if(rs.next()){
				   pw=rs.getString(1);
			   }
				 

		   } catch (Exception e) {
			   e.printStackTrace();
		   }finally{
			   executeClose(rs, pstmt, conn);
		   }
		   return pw;
	   }
}
















