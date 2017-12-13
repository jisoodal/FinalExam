package kr.util;

public class StringUtil {
	/*
	 * HTML 허용하면서 줄 바꿈
	 */
	public static String useBrHtml(String str){
		if(str==null) return null;
		
		return str.replaceAll("\r\n", "<br>")
				  .replaceAll("\n", "<br>")
				  .replaceAll("\r", "<br>");
	}
	/*
	 * HTML 허용하지 않으면서 줄바꿈
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
	 * HTML 허용하지 않고 줄 바꿈 처리 없음
	 */
	public static String useNoHtml(String str){
		if(str==null) return null;
		
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
}
