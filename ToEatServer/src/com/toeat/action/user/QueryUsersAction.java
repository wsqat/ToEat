/**
 * author : sagewang
 * date : 下午4:42:48
 */
package com.toeat.action.user;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：QueryUsersAction   
 * 类描述：   
 * 创建人：wsqali   
 * 创建时间：2016年5月12日 下午4:42:48   
 * 修改人：wsqali   
 * 修改时间：2016年5月12日 下午4:42:48   
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
import com.toeat.bean.User;
import com.toeat.service.BaseService;
import com.toeat.util.ResUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QueryUsersAction {
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	private User user;
    // 封装并返回所有用户信息
    public String execute(){
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> userlist = baseService.ReadAll("User");
        try{        
            map.put("Users", userlist);
            ResUtil.toJson(ServletActionContext.getResponse(), map);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
