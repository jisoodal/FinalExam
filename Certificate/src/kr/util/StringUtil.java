package kr.util;

public class StringUtil {
	/*
	 * HTML ����ϸ鼭 �� �ٲ�
	 */
	public static String useBrHtml(String str){
		if(str==null) return null;
		
		return str.replaceAll("\r\n", "<br>")
				  .replaceAll("\n", "<br>")
				  .replaceAll("\r", "<br>");
	}
	/*
	 * HTML ������� �����鼭 �ٹٲ�
	 */
	public static String useBrNoHtml(String str){
		if(str==null) return null;
		
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;")
				  .replaceAll("\r\n", "<br>")
				  .replaceAll("\n", "<br>")
				  .replaceAll("\r", "<br>");
	}
	/*
	 * HTML ������� �ʰ� �� �ٲ� ó�� ����
	 */
	public static String useNoHtml(String str){
		if(str==null) return null;
		
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
}
