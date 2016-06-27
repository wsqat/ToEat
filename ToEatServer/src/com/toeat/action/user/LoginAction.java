package com.toeat.action.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.providers.XmlHelper;
import com.toeat.bean.User;
import com.toeat.service.BaseService;

/**   
 *    
 * 项目名称：ToEatServer   
 * 类名称：LoginAction   
 * 类描述：   用户注册、登录页面
 * 创建人：wsqali   
 * 创建时间：2016年5月14日 下午4:29:43   
 * 修改人：wsqali   
 * 修改时间：2016年5月14日 下午4:29:43   
 * 修改备注：   
 * @version    
 *    
 */
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private static final Log logger = LogFactory.getLog(XmlHelper.class);
	private User user;
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	//android 注册用户
	public void register(){
		//找出 response，request 对象  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setContentType("text/html");
		User newUser = new User();
		//获取名为attrName的request属性的值
		String name = request.getParameter(newUser.USERNAME);
		String phone = request.getParameter(newUser.PHONE);
		String password = request.getParameter(newUser.PASSWORD);
		newUser.setName(name);
		newUser.setPhone(phone);
		newUser.setPassword(password);
		System.out.println("name..."+name);
		System.out.println("phone..."+phone);
		System.out.println("password..."+password);
		//当前时间戳
		//Date date = new Date();       
		//Timestamp regTime = new Timestamp(date.getTime());
		newUser.setRegTime(new Timestamp(new Date().getTime()));
//		int id = baseService.ReadCount("User")+1;
//		newUser.setId(id);
//		System.out.println("id..."+id);
		PrintWriter out=null;
		try {
			baseService.save(newUser);
			out = response.getWriter();
			System.out.println("OK...");
			out.println("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wrong...");
			out.println("Wrong");
		}
		out.flush();
		out.close();
	}
	

	//android 登录验证
	public void checkLogin(){
		//找出 response，request 对象  
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setContentType("text/html");
		//获取名为attrName的request属性的值
		String phone = request.getParameter(user.PHONE);
		String password = request.getParameter(user.PASSWORD);
		System.out.println("phone..."+phone);
		System.out.println("password..."+password);
		//设置名为attrName2的request属性,其值为attrName2Value
		//request.put("attrName2","attrName2Value");    
		//上面一行代码等效于 request.setAttribute("attrName2","attrName2Value");
		User currentUser = (User)baseService.ReadByDouble("User", "phone", phone, "password", password);
		PrintWriter out=null;
		try {
			out = response.getWriter();
			if(!currentUser.equals(null)){
				logger.info("currentUser.getName()..."+currentUser.getName());
				System.out.println("OK...");
				out.println("OK");
			}else{
				System.out.println("Wrong...");
				out.println("Wrong");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Wrong...");
			out.println("Wrong");
		}
		
		out.flush();
		out.close();
	}
	
	
	@Override
	public String execute(){
		//加载.properties文件
		PropertyConfigurator.configure("E:/MYWorkspacess/ToEatServer/src/log4j.properties");
		try{
			System.out.println("user.getPhone()..."+user.getPhone());
			System.out.println("user.getPassword()..."+user.getPassword());
//			video=(Video) baseService.ReadByID("Video", videoid);
//			User currentUser = (User)baseService.ReadByID("User", 1);
			User currentUser = (User)baseService.ReadByDouble("User", "phone", user.getPhone(), "password", user.getPassword());
			logger.info("user.getPhone()..."+user.getPhone());
			if(!currentUser.equals(null)){
				logger.info("currentUser.getName()..."+currentUser.getName());
				//存入session
				ActionContext actionContext = ActionContext.getContext();
				Map session = actionContext.getSession();
			    session.put("isLogin", "true");
			    System.out.println("execute...session.get(isLogin)……"+session.get("isLogin"));
				return "success";
			}
			return "error";
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "error";
		}
	}
	
	// 注销session的方法：
	public String logout(){
	  try{
		  //删除session
		  ActionContext actionContext = ActionContext.getContext();
		  Map session = actionContext.getSession();
		  System.out.println("logout...session.get(isLogin)……"+session.get("isLogin"));
	      session.remove("isLogin");
		  return "success";
	  }catch(Exception ex){
		  ex.printStackTrace();
		  return "error";
	  }
	  
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
