/**
 * author : sagewang
 * date : 2016 下午10:42:07
 */
package com.toeat.action.article;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Article;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：ArticleReadAllAction   
 * 类描述：读取所有文章信息的Action
 * 创建人：wsqali   
 * 创建时间：2016年5月26日 下午10:42:07   
 * 修改人：wsqali   
 * 修改时间：2016年5月26日 下午10:42:07   
 * 修改备注：   
 * @version    
 *    
 */
public class ArticleReadAllAction extends ActionSupport{
	private List<Article> resultarticle;
	private BaseService baseService;
	public List<Article> getResultarticle() {
		return resultarticle;
	}
	public void setResultarticle(List<Article> resultarticle) {
		this.resultarticle = resultarticle;
	}
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	@SuppressWarnings("unchecked")
	public String execute(){
		try{
			resultarticle = baseService.ReadAll("Article");
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	
	
	
	
}
