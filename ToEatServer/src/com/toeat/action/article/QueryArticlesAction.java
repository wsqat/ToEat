/**
 * author : sagewang
 * date : 2016 下午11:53:39
 */
package com.toeat.action.article;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：QueryArticlesAction   
 * 类描述： 查询文章信息
 * 创建人：wsqali
 * 创建时间：2016年5月25日 下午11:53:39   
 * 修改人：wsqali   
 * 修改时间：2016年5月25日 下午11:53:39   
 * 修改备注：   
 * @version    
 *    
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.toeat.bean.Article;
import com.toeat.bean.User;
import com.toeat.bean.Comment;
import com.toeat.service.BaseService;
import com.toeat.util.ResUtil;

@SuppressWarnings("serial")
public class QueryArticlesAction {
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	private Article article;
	private Comment comment;
    // 封装并返回所有文章信息
    public String execute(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Article> articleList = baseService.ReadAll("Article");        
        try{        
            map.put("Articles", articleList);
            ResUtil.toJson(ServletActionContext.getResponse(), map);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

