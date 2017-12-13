package kr.board.domain;

import java.util.List;

//JSON문자열에 담길 내용들 표시하는 일종의 자바빈
public class BoardReplyAjax {
	private int count;
	private int rowCount;
	private String result;//성공여부
	private List<BoardReply> list;
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<BoardReply> getList() {
		return list;
	}
	public void setList(List<BoardReply> list) {
		this.list = list;
	}
	
}
