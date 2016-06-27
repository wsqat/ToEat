/**
 * author : sagewang
 * date : 2016 下午7:34:07
 */
package com.toeat.action.article;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：CkeditorUploadAction   
 * 类描述：   处理图片上传的Action
 * 创建人：wsqali   
 * 创建时间：2016年5月26日 下午7:34:07   
 * 修改人：wsqali   
 * 修改时间：2016年5月26日 下午7:34:07   
 * 修改备注：   
 * @version    
 *    
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.util.DateUtil;

public class CkeditorUploadAction  extends ActionSupport{
	private File upload; 
    private String uploadContentType; 
    private String uploadFileName; 

    public File getUpload() { 
      return upload; 
    } 

    public void setUpload(File upload) { 

      this.upload = upload; 
    } 

    public String getUploadContentType() { 
      return uploadContentType; 
    } 

    public void setUploadContentType(String uploadContentType) { 
      this.uploadContentType = uploadContentType; 
    } 

    public String getUploadFileName() { 
      return uploadFileName; 
    } 

    public void setUploadFileName(String uploadFileName) { 
      this.uploadFileName = uploadFileName; 
    } 

    
    public String execute() throws Exception {
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8"); 
      PrintWriter out = response.getWriter(); 

      // CKEditor提交的很重要的一个参数 
      String callback = ServletActionContext.getRequest().getParameter("CKEditorFuncNum");    
      InputStream is = new FileInputStream(upload); 
      //String uploadPath = ServletActionContext.getServletContext().getRealPath("uploads/"+DateUtil.getDirDate());//这个目录是在你的项目下
      //修改上传路径（物理路径），到Apache tomcat下面的webapps文件中的一个目录（便于给URL），这样重新部署时之前上传的文件就不会被删除
      //String uploadPath =  "C:\\apache-tomcat-8.0.28-windows-x64\\webapps\\uploads\\"+getUserInfo().getUsername()+"\\"+DateUtil.getDirDate()+"\\";
      String uploadPath =  "E:\\MyEclipse\\apache-tomcat-7.0.52\\webapps\\uploads\\"+DateUtil.getDirDate()+"\\";
      System.out.println("uploadpath:"+uploadPath);
      File dirfile=new File(uploadPath);
      if(!dirfile.exists()){
           dirfile.mkdirs();
      }
      Long uploadFileNameTime = new Date().getTime();
//      System.out.println("filename:"+uploadFileName);//直接使用上传文件的名字，没有重新命名了= =偷懒，但也有好处
//      File toFile = new File(uploadPath, uploadFileName);
      System.out.println("filename:"+uploadFileNameTime);//直接使用上传文件的名字，没有重新命名了= =偷懒，但也有好处
      String trueName= uploadFileNameTime.toString()+uploadFileName.substring(uploadFileName.length()-4,uploadFileName.length());
      System.out.println("trueName:"+trueName);
      
      
      //写入本地
      File toFile = new File(uploadPath, trueName);
      OutputStream os = new FileOutputStream(toFile);    
      byte[] buffer = new byte[1024];    
      int length = 0; 
      while ((length = is.read(buffer)) > 0) {    
        os.write(buffer, 0, length);    
      }    
      is.close(); 
      os.close(); 
      
      // 返回“图像”选项卡并显示图片 
      out.println("<script type=\"text/javascript\">");   
      out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + "http://localhost:8080/uploads/"+ DateUtil.getDirDate() +"/"+ trueName + "','')");
      out.println("</script>");
      
      return null; 
    }    
    
    public static boolean deletefile(String delpath)throws FileNotFoundException, IOException {
        try {
    
            File file = new File(delpath);
            if (!file.isDirectory()) {
                System.out.println("1");
                file.delete();
            } else if (file.isDirectory()) {
                System.out.println("2");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + "\\" + filelist[i]);
                    if (!delfile.isDirectory()) {
                        System.out.println("path=" + delfile.getPath());
                        System.out.println("absolutepath="
                                + delfile.getAbsolutePath());
                        System.out.println("name=" + delfile.getName());
                        delfile.delete();
                        System.out.println("删除文件成功");
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + "\\" + filelist[i]);
                    }
                }
                file.delete();
    
            }
    
        } catch (FileNotFoundException e) {
            System.out.println("deletefile()  Exception:" + e.getMessage());
        }
        return true;
    }
    
}
