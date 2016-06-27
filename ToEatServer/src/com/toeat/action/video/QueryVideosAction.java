/**
 * author : sagewang
 * date : 2016 下午8:45:52
 */
package com.toeat.action.video;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：QueryVideosAction   
 * 类描述：查询数据库里的视频数据   
 * 创建人：wsqali   
 * 创建时间：2016年5月20日 下午8:45:52   
 * 修改人：wsqali   
 * 修改时间：2016年5月20日 下午8:45:52   
 * 修改备注：   
 * @version    
 *    
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.toeat.bean.Video;
import com.toeat.service.BaseService;
import com.toeat.util.ResUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QueryVideosAction {
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	private Video video;
    // 封装并返回所有视频信息
    public String execute(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Video> videolist = baseService.ReadAll("Video");
        try{        
            map.put("Video", videolist);
            ResUtil.toJson(ServletActionContext.getResponse(), map);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
