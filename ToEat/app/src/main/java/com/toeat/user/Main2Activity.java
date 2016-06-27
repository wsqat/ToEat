package com.toeat.user;

/*
 * 展示所有的用户
 */
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.toeat.common.CommThread;
import com.toeat.util.Var;
import com.toeat.R;

public class Main2Activity extends ListActivity{
    static list_clas_adaptor myAdaptor;
    static Context mCtx;
    static ProgressDialog progressDialog;
    static Toast toast;
    CommThread myThread;
    static int numGet = 0;
    ListView lv;
    int id;
    item_clas it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);
        mCtx = getApplicationContext();
        getScreen();
        myAdaptor = new list_clas_adaptor(this);
        progressDialog = ProgressDialog.show(Main2Activity.this,
                "连接", "正在连接服务器:" + Var.strURL, true, false);
        setListAdapter(myAdaptor);

        myThread = new CommThread();
        myThread.start();
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        id = Integer.parseInt((String) myAdaptor.list_data.get(position).txtNum.getText());
        it = (item_clas) myAdaptor.getItem((int)id);
        super.onListItemClick(l, v, position, id);
    }

    // 获得课程列表
    public static void getData(){
        myAdaptor.list_data.clear();
        if (Var.lstId.size()>0){
            for (int i=0; i<Var.lstId.size(); i++){
                myAdaptor.addItem(Var.lstId.get(i).toString(),
                        Var.lstName.get(i).toString(), Var.lstComm.get(i).toString(), 1);

            }
        }
        numGet++;
    }

    // 消息处理Handler
    public static Handler mainHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what)
            {

                // 出错
                case  Var.msg_error:
                    toast = Toast.makeText(mCtx,
                            "错误:" + msg.getData().getString("1"), Toast.LENGTH_LONG);
                    toast.show();
                    break;
                // 已连接成功
                case Var.msg_connect:
                    progressDialog.dismiss();
                    getData();
                    myAdaptor.notifyDataSetChanged();
                    toast = Toast.makeText(mCtx,
                            "连接服务器并返回数据成功!", Toast.LENGTH_LONG);
                    toast.show();
                    break;

            }
            super.handleMessage(msg);
        }
    };


    // 获得屏幕尺寸
    public void getScreen(){
        DisplayMetrics dm =getResources().getDisplayMetrics();
        Var.wid_scr  = dm.widthPixels;
        Var.hei_scr = dm.heightPixels;
//        Var.wid_scr = getWindowManager().getDefaultDisplay().getWidth();
//        Var.hei_scr = getWindowManager().getDefaultDisplay().getHeight();
    }

}

//课程列表
class list_clas_adaptor extends BaseAdapter implements OnClickListener{

    public Context ctx;
    public List<item_clas> list_data;
    public String s1, s2;

    public list_clas_adaptor(Context context){
        ctx =context;
        list_data = new ArrayList<item_clas>();
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list_data.size();
    }

    @Override
    public Object getItem(int id) {
        // TODO Auto-generated method stub
        s2 = String.valueOf(id);
        for (int i=0; i<list_data.size(); i++){
            s1 = (String) list_data.get(i).txtNum.getText();
            if (s1.equals(s2))
                return list_data.get(i);
        }

        return null;

    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return list_data.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        item_clas my_item;
        if (convertView == null)
        {
            my_item = new item_clas(ctx,
                    (String)list_data.get(position).txtNum.getText(),
                    (String)list_data.get(position).txtName.getText(),
                    (String)list_data.get(position).txtComm.getText()
                    ,1);
        }
        else
        {
            my_item = (item_clas)convertView;
            my_item.txtNum.setText(list_data.get(position).txtNum.getText());
            my_item.txtName.setText(list_data.get(position).txtName.getText());
            my_item.txtComm.setText(list_data.get(position).txtComm.getText());
        }

        // 点击删除按钮
        my_item.btnDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


            }        });

        // 点击修改按钮
        my_item.btnMdf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return my_item;
    }

    public void addItem(String num, String name, String comm, int x)
    {
        list_data.add(new item_clas(ctx, num, name, comm, x));
    }


    @Override
    public void onClick(View v) {


    }

}

// clas列表的一行
class item_clas extends LinearLayout{

    public TextView txtNum;
    public TextView txtName;
    public TextView txtComm;
    public TextView txtMdf;
    public TextView txtDel;
    public Button btnMdf;
    public Button btnDel;


    public item_clas(Context ctx, String num, String name, String comm, int x)
    {
        super(ctx);
        this.setOrientation(HORIZONTAL);
        int hei = 100;

        txtNum = new TextView(ctx);
        txtNum.setText(num);
        txtNum.setGravity(Gravity.CENTER);
        txtNum.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
        addView(txtNum, new LinearLayout.LayoutParams((int)(Var.wid_scr*0.1),hei));

        txtName = new TextView(ctx);
        txtName.setText(name);
        txtName.setGravity(Gravity.CENTER);
        txtName.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
        addView(txtName, new LinearLayout.LayoutParams((int)(Var.wid_scr*0.2),hei));

        txtComm = new TextView(ctx);
        txtComm.setText(comm);
        Gravity g = new Gravity();
        txtComm.setGravity(Gravity.LEFT);
        addView(txtComm, new LinearLayout.LayoutParams((int)(Var.wid_scr*0.4),hei));

        if (x==0){
            txtDel = new TextView(ctx);
            txtDel.setText("删除");
            txtDel.setGravity(Gravity.CENTER);
            addView(txtDel, new LinearLayout.LayoutParams((int)(Var.wid_scr*0.15),hei));
            Log.i("addView", txtDel.getText().toString());

            txtMdf = new TextView(ctx);
            txtMdf.setText("更新 ");
            txtMdf.setGravity(Gravity.CENTER);
            addView(txtMdf, new LinearLayout.LayoutParams((int)(Var.wid_scr*0.15),hei));
            Log.i("comm=", comm);
            Log.i("addView", txtMdf.getText().toString());
        }

        else{
            btnDel = new Button(ctx);
            btnDel.setText("删除");
            btnDel.setGravity(Gravity.CENTER);
            btnDel.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
            btnDel.setFocusable(false);
            addView(btnDel, new LinearLayout.LayoutParams((int)(Var.wid_scr*0.15),hei));

            btnMdf = new Button(ctx);
            btnMdf.setText("更新");
            btnMdf.setGravity(Gravity.CENTER);
            btnMdf.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
            btnMdf.setFocusable(false);
            addView(btnMdf, new LinearLayout.LayoutParams((int)(Var.wid_scr*0.15),hei));
        }
    }


}
