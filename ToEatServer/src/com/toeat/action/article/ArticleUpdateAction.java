/**
 * author : sagewang
 * date : 2016 下午2:22:41
 */
package com.toeat.action.article;

import java.sql.Timestamp;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Article;
import com.toeat.bean.Articlecategory;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：ArticleUpdateAction   
 * 类描述：   
 * 创建人：wsqali   
 * 创建时间：2016年5月27日 下午2:22:41   
 * 修改人：wsqali   
 * 修改时间：2016年5月27日 下午2:22:41   
 * 修改备注：   
 * @version    
 *    
 */
public class ArticleUpdateAction extends ActionSupport{
	private String title;
	private String content;
	private BaseService baseService;
	private int ArticleCategoryId;
	private int articleId;
	private Article article;
	
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

	public int getArticleCategoryId() {
		return ArticleCategoryId;
	}

	public void setArticleCategoryId(int articleCategoryId) {
		ArticleCategoryId = articleCategoryId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	//Update
	public String Update(){
		try{
			article.setTitle(title);
			article.setContent(content);
			article.setEditTime(new Timestamp(new Date().getTime()));
			Articlecategory category= (Articlecategory) baseService.ReadSingle("Articlecategory", "id", ArticleCategoryId);
			article.setArticlecategory(category);
			baseService.update(article);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	// Read
	public String Read(){
		try{
			article=(Article) baseService.ReadByID("Article", articleId);
			System.out.println("Read().articleId……"+articleId);
			System.out.println("article.getArticlecategory().getId()……"+article.getArticlecategory().getId());
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
