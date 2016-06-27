package com.toeat.util;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/5/12.
 * Var存放变量
 */
import java.util.ArrayList;
import java.util.List;

public class Var {

    // 访问的URL
    public static String strHost = new String("http://10.0.2.2:8080/ToEatServer/");
    public static String strAct = new String("QueryUsers.action");
    public static String strURL = strHost + strAct;

    // 列表
    public static List lstId = new ArrayList();
    public static List lstName = new ArrayList();
    public static List lstComm = new ArrayList();

    // 屏幕的尺寸
    public static int wid_scr;
    public static int hei_scr;

    // 消息类型
    public static final int msg_connect = 1;
    public static final int msg_error = 2;
    public static final int msg_con_start = 3;
    public static final int msg_con_stop = 4;

}