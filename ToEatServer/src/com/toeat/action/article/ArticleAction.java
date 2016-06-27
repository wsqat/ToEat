/**
 * author : sagewang
 * date : 2016 下午1:45:47
 */
package com.toeat.action.article;

import java.sql.Timestamp;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Article;
import com.toeat.bean.Articlecategory;
import com.toeat.bean.User;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：ArticleAction   
 * 类描述：   CURD
 * 创建人：wsqali   
 * 创建时间：2016年5月27日 下午1:45:47   
 * 修改人：wsqali   
 * 修改时间：2016年5月27日 下午1:45:47   
 * 修改备注：   
 * @version    
 *    
 */
@SuppressWarnings("serial")
public class ArticleAction extends ActionSupport{
	private String title;
	private String content;
	private BaseService baseService;
	private int ArticleCategoryId;
	private int articleId;
	private Article currentArticle;
	
    public int getArticleCategoryId() {
		return ArticleCategoryId;
	}

	public void setArticleCategoryId(int articleCategoryId) {
		ArticleCategoryId = articleCategoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	//Add article
	public String Add(){
		try{			
			//创建新的文章
			Article article= new Article();
			article.setTitle(title);
			article.setContent(content);
			article.setEditTime(new Timestamp(new Date().getTime()));
			//System.out.println("ArticleCategoryId..."+ArticleCategoryId);
			User user = (User) baseService.ReadSingle("User", "id", 1);
			article.setUser(user);
			Articlecategory category= (Articlecategory) baseService.ReadSingle("Articlecategory", "id", ArticleCategoryId);
			//System.out.println("category..."+category.getId());
			article.setArticlecategory(category);
			baseService.save(article);
			return "success";
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "error";
		}
	}
	
	
	// Read
	public String Read(){
		try{
			currentArticle=(Article) baseService.ReadByID("Article", articleId);
			System.out.println("Read().currentArticle.articleId……"+articleId);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	//delete article
	public String Delete(){
		try{
			Article article=(Article) baseService.ReadByID("Article", articleId);
			//最后才删除该记录
			baseService.delete(article);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
}
