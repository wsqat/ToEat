/**
 * author : sagewang
 * date : 2016 下午6:39:45
 */
package com.toeat.action.video;

import org.apache.struts2.ServletActionContext;
import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Video;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：VideoDeleteAction   
 * 类描述：删除视频的Action   
 * 创建人：wsqali   
 * 创建时间：2016年5月16日 下午6:39:45   
 * 修改人：wsqali   
 * 修改时间：2016年5月16日 下午6:39:45   
 * 修改备注：   
 * @version    
 *    
 */
public class VideoDeleteAction extends ActionSupport {
	private int videoid;
	private BaseService baseService;
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

	public String execute(){
		try{
			Video video=(Video) baseService.ReadByID("Video", videoid);
			//相对路径
			String thumbnailPath=video.getThumbnailurl();
			String path=video.getUrl();
			String oripath=video.getOriurl();
			//获取根路径（绝对路径）
			String thumbnailrealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+thumbnailPath;
			String realpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+path;
			String orirealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+oripath;
			File thumbnailfile=new File(thumbnailrealpath);
			File videofile=new File(realpath);
			File orivideofile=new File(orirealpath);
			//删除与之相关的截图文件和视频文件
			if(thumbnailfile!=null){
				thumbnailfile.delete();
			}
			if(videofile!=null){
				videofile.delete();
			}
			if(orivideofile!=null){
				orivideofile.delete();
			}
			//最后才删除该记录
			baseService.delete(video);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
