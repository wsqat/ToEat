/**
 * author : sagewang
 * date : 2016 下午2:12:09
 */
package com.toeat.action.shop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.toeat.bean.Good;
import com.toeat.bean.Goodcategory;
import com.toeat.service.BaseService;
import com.toeat.util.ResUtil;


/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：QueryInfoAction   
 * 类描述：   
 * 创建人：wsqali   
 * 创建时间：2016年6月4日 下午2:12:09   
 * 修改人：wsqali   
 * 修改时间：2016年6月4日 下午2:12:09   
 * 修改备注：   
 * @version    
 *    
 */
public class QueryInfoAction {
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	private Good good;
	private Goodcategory goodcategory;
	// 封装并返回所有文章信息
    public String execute(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goodcategory> articleList = baseService.ReadAll("Goodcategory");        
        try{        
            map.put("Goodcategory", articleList);
            ResUtil.toJson(ServletActionContext.getResponse(), map);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
