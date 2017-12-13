package kr.member.domain;

import java.sql.Date;

public class Member {
	private String mem_id;
	private String mem_name;
	private String mem_pw;
	private String mem_cell;
	private String mem_email;
	private String mem_addr;	
	private Date mem_register;
	private String mem_level;
	
	//비밀번호 일치 여부 체크
	public boolean isCheckedPasswd(String userPasswd){
		if(mem_pw.equals(userPasswd)){
			return true;
		}
		return false;
	}
	public boolean isCheckedId(String userId){
		if(mem_id.equals(userId)){
			return true;
		}
		return false;
	}
	//레벨링 일치 여부 체크
	
	public String getMem_level() {
		return mem_level;
	}
	public void setMem_level(String mem_level) {
		this.mem_level = mem_level;
	}
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_cell() {
		return mem_cell;
	}

	public void setMem_cell(String mem_cell) {
		this.mem_cell = mem_cell;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public Date getMem_register() {
		return mem_register;
	}

	public void setMem_register(Date mem_register) {
		this.mem_register = mem_register;
	}
	
	
	
}
