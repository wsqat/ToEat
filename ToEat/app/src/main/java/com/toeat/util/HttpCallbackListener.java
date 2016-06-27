package com.toeat.util;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/5/9.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
