/**
 * author : sagewang
 * date : 2016 下午6:40:32
 */
package com.toeat.action.video;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Video;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：VideoReadLimitedByOrderAction   
 * 类描述： 根据指定顺序读取视频信息Action  
 * 创建人：wsqali   
 * 创建时间：2016年5月16日 下午6:40:32   
 * 修改人：wsqali   
 * 修改时间：2016年5月16日 下午6:40:32   
 * 修改备注：   
 * @version    
 *    
 */
public class VideoReadLimitedByOrderAction extends ActionSupport {
	private int num;
	private BaseService baseService;
	private List<Video> resultvideo;

	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<Video> getResultvideo() {
		return resultvideo;
	}
	public void setResultvideo(List<Video> resultvideo) {
		this.resultvideo = resultvideo;
	}
	public String execute(){
		try{
			resultvideo= baseService.ReadLimitedByOrder("Video", "editTime", num, "asc");
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
