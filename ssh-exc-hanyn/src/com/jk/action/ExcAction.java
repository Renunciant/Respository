/** 
 * <pre>项目名称:ssh-exc-hanyn 
 * 文件名称:ExcAction.java 
 * 包名:com.jk.action 
 * 创建日期:2017-10-13上午8:53:38 
 * Copyright (c) 2017, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.jk.model.Exceptions;
import com.jk.model.PageFlag;
import com.jk.service.ExcService;

/** 
 * <pre>项目名称：ssh-exc-hanyn    
 * 类名称：ExcAction    
 * 类描述：    
 * 创建人：韩雅宁 cht_java@126.com    
 * 创建时间：2017-10-13 上午8:53:38    
 * 修改人：韩雅宁 cht_java@126.com  
 * 修改时间：2017-10-13 上午8:53:38    
 * 修改备注：       
 * @version </pre>    
 */
public class ExcAction {
  private Exceptions exceptions; 
  private List<Exceptions> list;
  private PageFlag pageFlag;
  private ExcService excService;

//图片上传
  private File headImg;
  private String headImgFileName;
  private FileInputStream fileInputStrem;
  
  private String ids;
  
  public String insertExc(){

      //上传图片
 	   
	      //构建输入流
		     BufferedInputStream bis = null;
		
		     //构建输出流
		      BufferedOutputStream bos = null;

			//构建文件输入流读取文件
			try {
				bis = new BufferedInputStream(new FileInputStream(headImg));
				
				//获取保存文件的路径   sh-user-register/imgUrl
				String savePath = ServletActionContext.getServletContext().getRealPath("/imgUrl");
				
				//生成新的文件名称
				int lastIndexOf = headImgFileName.lastIndexOf(".");
				// .png  .jpg
				String suffix = headImgFileName.substring(lastIndexOf);
				
				//1123-asd-2345sdf-sdf.png   
				String newFileNamre = UUID.randomUUID() + suffix;
				
				//将新的文件名已经保存的路径 添加到数据中
				
				File file = new File(savePath);
				if (!file.exists()) {
					file.mkdir();
				}
				exceptions.setImgUrl("imgUrl/"+newFileNamre);
				
				//构建输出流 sh-user-register/upload/1123-asd-2345sdf-sdf.png
				bos = new BufferedOutputStream(new FileOutputStream(savePath + "/" + newFileNamre));
				
				//读取文件
				byte [] bytes = new byte[1024];
				
				//读取文件长度
				int length = bis.read(bytes);
				
				//按读取的文件长度 写入到输出流
				while(length > 0) {
					//读到字节数 写入到输出流里面
					bos.write(bytes, 0, length);
					//接着读取文件  重新赋值 length 直到读取结束
					length = bis.read(bytes);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					//关闭输入流
					bis.close();
					//清空输出流
					bos.flush();
					//关闭输出流
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	   
	   
	  excService.insertExc(exceptions);
	return "insertExcSuccess";
  }
//文件下载      
  
  public String downloadHeadPhotoAction(){
		
 	   try {
			//获取文件绝对路径
			String downloadUrl = ServletActionContext.getServletContext().getRealPath("imgUrl/"+headImgFileName);
		
			//根据路径下载文件
			setFileInputStrem(new FileInputStream(downloadUrl));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	   return "photoPhoto"; 
    }
 
  public String queryExc(){
	   	if(pageFlag == null){
    		  
    		  pageFlag = new PageFlag();
    	    }
      	pageFlag = excService.queryUserCount(pageFlag, exceptions); 
	  list = excService.queryExc(exceptions,pageFlag);
	return "queryExcSuccess";
  }

  
  public String deleteAllExc(){
	  excService.deleteAllExc(ids);
	return "deleteAllSuccess";  
  }
		  
public Exceptions getExceptions() {
	return exceptions;
}

public void setExceptions(Exceptions exceptions) {
	this.exceptions = exceptions;
}



public List<Exceptions> getList() {
	return list;
}

public void setList(List<Exceptions> list) {
	this.list = list;
}

public PageFlag getPageFlag() {
	return pageFlag;
}

public void setPageFlag(PageFlag pageFlag) {
	this.pageFlag = pageFlag;
}

public ExcService getExcService() {
	return excService;
}

public void setExcService(ExcService excService) {
	this.excService = excService;
}

public File getHeadImg() {
	return headImg;
}

public void setHeadImg(File headImg) {
	this.headImg = headImg;
}

public String getHeadImgFileName() {
	return headImgFileName;
}

public void setHeadImgFileName(String headImgFileName) {
	this.headImgFileName = headImgFileName;
}

public FileInputStream getFileInputStrem() {
	return fileInputStrem;
}

public void setFileInputStrem(FileInputStream fileInputStrem) {
	this.fileInputStrem = fileInputStrem;
}

public String getIds() {
	return ids;
}

public void setIds(String ids) {
	this.ids = ids;
}

}
