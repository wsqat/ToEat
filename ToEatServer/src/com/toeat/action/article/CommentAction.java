/**
 * author : sagewang
 * date : 2016 下午5:26:42
 */
package com.toeat.action.article;

import java.sql.Timestamp;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.toeat.bean.Article;
import com.toeat.bean.Articlecategory;
import com.toeat.bean.Comment;
import com.toeat.bean.User;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：CommentAction   
 * 类描述：   增加评论
 * 创建人：wsqali   
 * 创建时间：2016年5月27日 下午5:26:42   
 * 修改人：wsqali   
 * 修改时间：2016年5月27日 下午5:26:42   
 * 修改备注：   
 * @version    
 *    
 */

public class CommentAction extends ActionSupport{
	private int commentId;
	private String content;
	private BaseService baseService;
	private int articleId;
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
	
	//Add Comment
	public String Add(){
		try{			
			//Add Comment
			Comment comment= new Comment();
			comment.setContent(content);
			comment.setEditTime(new Timestamp(new Date().getTime()));
			//System.out.println("ArticleCategoryId..."+ArticleCategoryId);
			User user = (User) baseService.ReadSingle("User", "id", 1);
			comment.setUser(user);
			Article article = (Article)baseService.ReadByID("Article", articleId);
			//System.out.println("category..."+category.getId());
			comment.setArticle(article);
			baseService.save(comment);
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
			Comment comment=(Comment) baseService.ReadByID("Comment", commentId);
			//最后才删除该记录
			baseService.delete(comment);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
}

