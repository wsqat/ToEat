/**
 * author : sagewang
 * date : 2016 下午5:05:32
 */
package com.toeat.action.video;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：VideoReadAllAction   
 * 类描述：   
 * 创建人：wsqali   
 * 创建时间：2016年5月16日 下午5:05:32   
 * 修改人：wsqali   
 * 修改时间：2016年5月16日 下午5:05:32   
 * 修改备注：   
 * @version    
 *    
 */
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import com.toeat.service.BaseService;

import com.toeat.bean.Video;
/**
 * @author sage_wang
 * 读取所有视频信息的Action
 */
public class VideoReadAllAction extends ActionSupport{
	private List<Video> resultvideo;
	private BaseService baseService;
	private int islive;
	
	public List<Video> getResultvideo() {
		return resultvideo;
	}

	public void setResultvideo(List<Video> resultvideo) {
		this.resultvideo = resultvideo;
	}
	
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}


	public int getIslive() {
		return islive;
	}

	public void setIslive(int islive) {
		this.islive = islive;
	}

	@SuppressWarnings("unchecked")
	public String execute(){
		try{
			if(islive==0){
				resultvideo=baseService.ReadByProperty("Video","islive",0);
			}else{
				resultvideo=baseService.ReadByProperty("Video","islive",1);
			}
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}

