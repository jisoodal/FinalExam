package kr.util;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

public class FileUtil {

	public static String UPLOAD_PATH="/upload";
	public static final String ENCODING_TYPE="utf-8";
	public static final int MAX_SIZE=10*1024*1024;

	public static MultipartRequest createFile(HttpServletRequest request)throws IOException{
		return new MultipartRequest(request,request.getServletContext().getRealPath(UPLOAD_PATH),MAX_SIZE,ENCODING_TYPE,
				new DefaultFileRenamePolicy());
	}
	public static String rename(HttpServletRequest request, String fileName)throws Exception{

		if(fileName==null) return null;

		String newName = Long.toString(System.currentTimeMillis())+(int)(Math.random()*50);

		return rename(request,fileName,newName);
	}
	public static String rename(HttpServletRequest request, String fileName,String newName)
			throws Exception{
		if(fileName == null) return null;

		File file = new File(request.getServletContext().getRealPath(UPLOAD_PATH),fileName);

		//���ϸ��� ���ϴ� �������� �����ϱ�
		int idx = fileName.lastIndexOf(".");

		String extention = "";
		String newFileName = "";

		if(idx !=-1){
			extention = fileName.substring(idx);
		}
		//newName ���޽� Ȯ���ڸ� �����ؾ� ������ Ȯ���ڸ� ������ ���� ������
		int newIdx = newName.lastIndexOf(".");
		if(newIdx !=-1){
			newName = newName.substring(0,newIdx);
		}
		//Ȯ���� ���� ���ο� ���ϸ�
		newFileName = newName + extention.toLowerCase();

		File fs = new File(request.getServletContext().getRealPath(UPLOAD_PATH),newFileName);
		file.renameTo(fs); //���ϸ��� ����

		return newFileName;
	}
	public static void removeFile(HttpServletRequest request, String fileName){
		if(fileName != null){
			File file = new File(request.getServletContext().getRealPath(UPLOAD_PATH),fileName);
			if(file.exists()) file.delete();
		}
	}
}
