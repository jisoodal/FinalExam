package kr.board.domain;

import java.sql.Date;

public class BoardVo {

	private int nb_num;
	private String nb_subject;
	private String nb_content;
	private String mem_id;
	private Date nb_register;
	private int nb_hit;
	private String nb_filename;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getNb_num() {
		return nb_num;
	}
	public void setNb_num(int nb_num) {
		this.nb_num = nb_num;
	}
	public String getNb_subject() {
		return nb_subject;
	}
	public void setNb_subject(String nb_subject) {
		this.nb_subject = nb_subject;
	}
	public String getNb_content() {
		return nb_content;
	}
	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}
	
	public Date getNb_register() {
		return nb_register;
	}
	public void setNb_register(Date nb_register) {
		this.nb_register = nb_register;
	}
	public int getNb_hit() {
		return nb_hit;
	}
	public void setNb_hit(int nb_hit) {
		this.nb_hit = nb_hit;
	}
	public String getNb_filename() {
		return nb_filename;
	}
	public void setNb_filename(String nb_filename) {
		this.nb_filename = nb_filename;
	}
	
}
