/**
 * author : sagewang
 * date : 2016 下午4:17:40
 */
package com.toeat.action.article;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Article;
import com.toeat.bean.Comment;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：ArticleReadByIdAction   
 * 类描述：   
 * 创建人：wsqali   
 * 创建时间：2016年5月27日 下午4:17:40   
 * 修改人：wsqali   
 * 修改时间：2016年5月27日 下午4:17:40   
 * 修改备注：   
 * @version    
 *    
 */
public class ArticleReadByIdAction extends ActionSupport {
	private Article article;
	private BaseService baseService;
	private int articleId;
	private List<Comment> relatedComments;

	public List<Comment> getRelatedComments() {
		return relatedComments;
	}


	public void setRelatedComments(List<Comment> relatedComments) {
		this.relatedComments = relatedComments;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public BaseService getBaseService() {
		return baseService;
	}


	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}


	public int getArticleId() {
		return articleId;
	}


	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}


	public String execute(){
		try{
			article=(Article) baseService.ReadByID("Article", articleId);
			relatedComments = (List<Comment>)baseService.ReadByProperty("Comment", "article.id", articleId);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
