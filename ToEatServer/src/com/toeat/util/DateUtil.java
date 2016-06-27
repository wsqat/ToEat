package com.toeat.util;

import java.util.Calendar;
import java.net.*;

public class DateUtil {
  public static String getDate(){
    Calendar calendar=Calendar.getInstance();
    int y=calendar.get(Calendar.YEAR);
    int m=calendar.get(Calendar.MONTH);
    int d=calendar.get(Calendar.DATE);
    int h=calendar.get(Calendar.HOUR);
    int mi=calendar.get(Calendar.MINUTE);
    int s=calendar.get(Calendar.SECOND);
    StringBuffer sb=new StringBuffer("");
    sb.append(y);
    sb.append(m+1);
    sb.append(d);
    sb.append(h);
    sb.append(mi);
    sb.append(s);
    String date=sb.toString();
    return date;
  }
  
  public static String getDirDate(){
    Calendar calendar=Calendar.getInstance();
    int y=calendar.get(Calendar.YEAR);
    int m=calendar.get(Calendar.MONTH);
    int d=calendar.get(Calendar.DATE);
    StringBuffer sb=new StringBuffer("");
    sb.append(y);
    sb.append(m+1);
    sb.append(d);
    String date=sb.toString();
    return date;
  }
  
  public static String getExtendName(String filename){
	  return filename.substring(filename.lastIndexOf(".")+1, filename.length());
  }
  
  public static String getIP() {
		// TODO Auto-generated method stub
		InetAddress ia=null;
		try {
			ia=ia.getLocalHost();			
//			String localname=ia.getHostName();
			String localIP=ia.getHostAddress();
//			System.out.println("本机名称是："+ localname);
			System.out.println("本机的ip是 ："+localIP);
			return localIP;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
  }

}
