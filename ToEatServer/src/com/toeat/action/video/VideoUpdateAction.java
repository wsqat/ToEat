/**
 * author : sagewang
 * date : 2016 下午6:39:26
 */
package com.toeat.action.video;

import java.sql.Timestamp;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Video;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：VideoUpdateAction   
 * 类描述： 更新视频信息的Action  
 * 创建人：wsqali   
 * 创建时间：2016年5月16日 下午6:39:26   
 * 修改人：wsqali   
 * 修改时间：2016年5月16日 下午6:39:26   
 * 修改备注：   
 * @version    
 *    
 */
public class VideoUpdateAction extends ActionSupport {
	private int videoid;
	private String name;
	private String intro;
	private BaseService baseService;
	private Video video;
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
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public String Read(){
		try{
			video=(Video) baseService.ReadByID("Video", videoid);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	public String Update(){
		try{
			video.setName(name);
			video.setIntro(intro);
			video.setEditTime(new Timestamp(new Date().getTime()));
			baseService.update(video);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}

