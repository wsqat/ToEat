/**
 * author : sagewang
 * date : 2016 下午1:58:57
 */
package com.toeat.action.video;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：VideoAddAction   
 * 类描述： 添加视频的Action
 * 创建人：wsqali   
 * 创建时间：2016年5月15日 下午1:58:57   
 * 修改人：wsqali   
 * 修改时间：2016年5月15日 下午1:58:57   
 * 修改备注：   
 * @version    
 *    
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.toeat.service.BaseService;
import com.toeat.bean.User;
import com.toeat.bean.Video;
import com.toeat.bean.Videocategory;
import com.toeat.bean.Videostate;
import com.toeat.bean.Configure;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class VideoAddAction extends ActionSupport {
	private static final int FILE_SIZE=16*1024;
	private String name;
	private String intro;
	private File videofile;
	private String videofileFileName;
	private String videofileContentType;
	private BaseService baseService;
	private int islive;
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	public File getVideofile() {
		return videofile;
	}
	public void setVideofile(File videofile) {
		this.videofile = videofile;
	}
	public String getVideofileFileName() {
		return videofileFileName;
	}
	public void setVideofileFileName(String videofileFileName) {
		this.videofileFileName = videofileFileName;
	}
	public String getVideofileContentType() {
		return videofileContentType;
	}
	public void setVideofileContentType(String videofileContentType) {
		this.videofileContentType = videofileContentType;
	}
	public int getIslive() {
		return islive;
	}
	public void setIslive(int islive) {
		this.islive = islive;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 写入文件时候用到的函数
	 * @param source 源文件
	 * @param target 目标文件
	 */
	 public void upLoadFile(File source,File target){
		  InputStream in=null;
		  OutputStream out=null;
			try{
			in=new BufferedInputStream(new FileInputStream(source),FILE_SIZE);
			out=new BufferedOutputStream(new FileOutputStream(target),FILE_SIZE);
			//in-->image-->out
			byte[] buffer=new byte[FILE_SIZE];
			while(in.read(buffer)>0){
				out.write(buffer);
			}
		  }catch(IOException ex){
			  ex.printStackTrace();
		  }finally{
		   try{
			    in.close();
			    out.close();
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}
	 
    //@Override
	public String execute(){
		try{
			int order=1;
			Video video=new Video();
			video.setName(name);
			video.setIntro(intro);
			video.setEditTime(new Timestamp(new Date().getTime()));
			//免费观看
			video.setPonits(null);
			User user = (User)baseService.ReadByID("User", 1);
			video.setUser(user);
			Configure folder_videoori_cfg=(Configure) baseService.ReadSingle("Configure", "name", "folder_videoori");
			Configure folder_thumbnail_cfg=(Configure) baseService.ReadSingle("Configure", "name", "folder_thumbnail");
			if(islive==0){
				//点播
				String oriurl=folder_videoori_cfg.getVal()+"/"+videofileFileName;
				video.setOriurl(oriurl);
				Videocategory category=(Videocategory) baseService.ReadSingle("Videocategory", "id", 1);
				video.setVideocategory(category);
				//状态设置：等待上传
				Videostate videostate=(Videostate) baseService.ReadSingle("Videostate", "order", order);
				video.setVideostate(videostate);
				video.setIslive(0);
				//Default Thumbnail
				String defaultthumbnail=folder_thumbnail_cfg.getVal()+"/default.jpg";
				video.setThumbnailurl(defaultthumbnail);
				baseService.save(video);
				
				//上传视频文件
				String realfileoriDir=ServletActionContext.getServletContext().getRealPath(folder_videoori_cfg.getVal()).replace('\\', '/');
				//Check
				File realfileoriDirFile =new File(realfileoriDir);
				if(!realfileoriDirFile.exists()  && !realfileoriDirFile.isDirectory()){
					System.out.println("Directory not exist. Create it.");  
					System.out.println(realfileoriDirFile);  
					realfileoriDirFile.mkdir();
				}
				String realfileoriPath=realfileoriDir+"/"+videofileFileName;
				File targetFile=new File(realfileoriPath);
				upLoadFile(videofile,targetFile);
				System.out.println("videofile..."+videofile);
				System.out.println("targetFile..."+targetFile);
				//等待截图
				videostate=(Videostate) baseService.ReadSingle("Videostate", "order", order+1);
				video.setVideostate(videostate);
				baseService.update(video);
			}else{
				//直播
				Videocategory category=(Videocategory) baseService.ReadSingle("Videocategory", "id", 2);
				video.setVideocategory(category);
				video.setUrl(url);
				video.setIslive(1);
				//等待截图
				Videostate videostate=(Videostate) baseService.ReadSingle("Videostate", "order", order+1);
				video.setVideostate(videostate);
				//Default Thumbnail
				String defaultthumbnail=folder_thumbnail_cfg.getVal()+"/default.jpg";
				video.setThumbnailurl(defaultthumbnail);
				
				baseService.save(video);
			}
			
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
