package kr.or.kosta.leaf.product_image.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {

	public static String uploadFile(HttpServletRequest request) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);  //multipart로 전송되었는가 체크
		String fileName = "";
		if (isMultipart) {
			// 설정단계
	 		File temporaryDir = new File("c:\\tmp\\");  //업로드된 파일의 임시 저장 폴더
//	 		String realDir = "C:\\Users\\CafeAlle\\Documents\\Persmetic\\WebContent\\uploadphoto";
	 		String realDir = request.getSession().getServletContext().getRealPath("/") + "uploadphoto";  //실제 저장될 파일경로
	 		String sFunc = request.getParameter("CKEditorFuncNum");
	 		String realUrl = request.getParameter("realUrl");
	 		
	 		
	 		
	 		// 디스크 기반의 파일 아이템 팩토리 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1 * 1024 * 1024);  //최대 메모리 크기
			factory.setRepository(temporaryDir);  // 임시저장폴더 연결

			// 구현단계
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(10 * 1024 * 1024);  //최대 업로드 크기
			List<FileItem> items = null;
			Iterator iter = null;
			try {
				items = upload.parseRequest(request);
				iter = items.iterator();
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //이 부분에서 파일이 생성
		
			while (iter.hasNext()) {
				FileItem fileItem = (FileItem) iter.next();
				if (fileItem.isFormField()) {  // File 컴포넌트가 아닌 일반 컴포넌트일 경우
					return null;	// 파일 업로드 중 오류 발생
				}else{
					if (fileItem.getSize() > 0) {  //파일이 업로드 되었나 안되었나 체크
						String fieldName = fileItem.getFieldName();
						fileName = fileItem.getName();
						request.setAttribute("fileName", fileName);
						String contentType = fileItem.getContentType();
						boolean isInMemory = fileItem.isInMemory();
						long sizeInBytes = fileItem.getSize();
					
						System.out.println("fieldName : " + fieldName);
						System.out.println("fileName : "  + fileName);
						System.out.println(sizeInBytes);
						System.out.println("realDir : " + realDir);
						System.out.println("realUrl : " + realUrl);
						
				 		try {
				 			File uploadedFile = new File(realDir, fileName);
				 			fileItem.write(uploadedFile);  //실제 디렉토리에 카피
				 			fileItem.delete();   //temp폴더의 파일 제거
				 			
				 			return "<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(" + sFunc + ",'http://localhost/uploadphoto/" + fileName + "', 'Complete!');</script>";
				 		} catch(Exception ex) {
				 			ex.printStackTrace();
				 			return null;
				 		}
					}
				}
			}
		} else {
//	 		out.println("인코딩 타입이 multipart/form-data 가 아님.");
		}
		return null;
	}
	
	public static void main(String args[]) {
		
	}
}
