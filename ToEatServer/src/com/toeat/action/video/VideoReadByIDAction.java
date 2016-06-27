/**
 * author : sagewang
 * date : 2016 下午6:40:13
 */
package com.toeat.action.video;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Video;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：VideoReadByIDAction   
 * 类描述：根据ID读取视频信息的Action   
 * 创建人：wsqali   
 * 创建时间：2016年5月16日 下午6:40:13   
 * 修改人：wsqali   
 * 修改时间：2016年5月16日 下午6:40:13   
 * 修改备注：   
 * @version    
 *    
 */
public class VideoReadByIDAction extends ActionSupport {
	private int videoid;
	private BaseService baseService;
	private String original_videoinfo;
	private String convert_videoinfo;
	private Video video;
	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}

	public String getOriginal_videoinfo() {
		return original_videoinfo;
	}
	public void setOriginal_videoinfo(String original_videoinfo) {
		this.original_videoinfo = original_videoinfo;
	}
	public String getConvert_videoinfo() {
		return convert_videoinfo;
	}
	public void setConvert_videoinfo(String convert_videoinfo) {
		this.convert_videoinfo = convert_videoinfo;
	}
	public String execute(){
		try{
			video=(Video) baseService.ReadByID("Video", videoid);
			
			//MediaInfo-------------------
			/*
			ServletContext servletContext = ServletActionContext.getServletContext();
			String realfilePath=servletContext.getRealPath("/").replace('\\', '/')+video.getUrl();
			String realfileoriginalPath=servletContext.getRealPath("/").replace('\\', '/')+video.getOriurl();

			MediaInfo MI = new MediaInfo();
			MI.Option("Output", "HTML");
			original_videoinfo = "";
		    if (MI.Open(realfileoriginalPath)>0){
		    	MI.Option("Complete", "");
				original_videoinfo+= MI.Inform();
	    	}else{
	    	original_videoinfo+="Unable to detect media info\r\n";
	    	}
			convert_videoinfo= "";
			if (MI.Open(realfilePath)>0){
				MI.Option("Complete", "");
				convert_videoinfo+= MI.Inform();
			}else{
		    	convert_videoinfo+="Unable to detect media info\r\n";
		    }
			*/
			//System.out.println(original_videoinfo);
			//System.out.println(convert_videoinfo);
			
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}