package kr.board.domain;

import java.util.List;

//JSON���ڿ��� ��� ����� ǥ���ϴ� ������ �ڹٺ�
public class BoardReplyAjax {
	private int count;
	private int rowCount;
	private String result;//��������
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
