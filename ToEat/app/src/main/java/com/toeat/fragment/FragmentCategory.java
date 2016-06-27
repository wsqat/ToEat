package com.toeat.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.toeat.R;
import com.toeat.entities.*;

import java.util.ArrayList;
import java.util.List;
import com.toeat.views.MyLinearLayout;
import com.toeat.views.MyTextView;
import com.toeat.shop.ProductListActivity;
import com.toeat.shop.SearchActivity;


public class FragmentCategory extends Fragment implements View.OnClickListener {
    ScrollView scrollViewLeft;
    ScrollView scrollViewRight;
    LinearLayout topCategoryLayout;
    GridLayout subCategoryLayout;

    private EditText editText_fragment_categray;
    private Button searchButton_fragment_categray;

    List<SubCategory> subCategories;
    List<TopCategory> topCategories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment_category, container, false);
        initLeft(rootView, inflater);
        return rootView;
    }

    public void initLeft(View rootView, LayoutInflater inflater) {
        scrollViewLeft = (ScrollView) rootView.findViewById(R.id.scrollview_top_category);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        topCategoryLayout = new LinearLayout(getContext());
        topCategoryLayout.setOrientation(LinearLayout.VERTICAL);
        topCategoryLayout.setLayoutParams(layoutParams);
        List<View> viewList = new ArrayList<View>();
        ViewGroup.LayoutParams viewGroupLP = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                180);
        MyTextView textView;
        topCategories = getTopCategories();

        for (int i = 0; i < topCategories.size(); i ++) {
            textView = (MyTextView) inflater.inflate(R.layout.top_category_textview, null);
            textView.setLayoutParams(viewGroupLP);
            textView.setText(topCategories.get(i).getProduct_category_name());
            textView.setNumber(topCategories.get(i).getProduct_category_no());
            viewList.add(textView);
            textView.setOnClickListener(this);
            topCategoryLayout.addView(viewList.get(i));
        }
        scrollViewLeft.addView(topCategoryLayout);

        editText_fragment_categray = (EditText) rootView.findViewById(R.id.editText_fragment_categray);
        searchButton_fragment_categray = (Button) rootView.findViewById(R.id.searchButton_fragment_categray);
        searchButton_fragment_categray.setOnClickListener(this);
    }

    private void initRight(View rootView, LayoutInflater inflater, View v) {
        scrollViewRight = (ScrollView) rootView.findViewById(R.id.scrollview_sub_category);
        subCategoryLayout = new GridLayout(getContext());
        subCategoryLayout.setColumnCount(3);
//        subCategoryLayout.setRowCount(3);

        List<View> viewList = new ArrayList<View>();
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(300, 300);
        MyLinearLayout myLinearLayout;
        subCategories = getSubCategories(    topCategories.get( (   (MyTextView)v).getNumber()  )      );

        scrollViewRight.removeAllViewsInLayout();
        for (int i = 0; i < subCategories.size(); i ++) {
            myLinearLayout = (MyLinearLayout) inflater.inflate(R.layout.sub_category_linear_layout, null);
            myLinearLayout.setLayoutParams(linearLayoutParams);
            myLinearLayout.setProduct_subcategory_no(subCategories.get(i).getProduct_subcategory_no());
            myLinearLayout.setProduct_subcategory_name(subCategories.get(i).getProduct_subcategory_name());
            myLinearLayout.setProduct_subcategory_img_url(subCategories.get(i).getImage());
            myLinearLayout.setOnClickListener(this);
            viewList.add(myLinearLayout);
            subCategoryLayout.addView(myLinearLayout);
        }
        scrollViewRight.addView(subCategoryLayout);
    }
    List<TopCategory> getTopCategories() {
        List<TopCategory> topCategories = new ArrayList<TopCategory>();
        TopCategory topCategory;
        //获得一级种类的Json数据
        //将Json数据转换为ArrayList<TopCategory>
        /*for(int i = 0; i < 5; i ++) {
            topCategory = new TopCategory(i,"水果蔬菜");
            topCategories.add(topCategory);
        }*/

        topCategories.add(new TopCategory(0,"解表药"));
        topCategories.add(new TopCategory(1,"清热药"));
        topCategories.add(new TopCategory(2,"消食药"));
        topCategories.add(new TopCategory(3,"安神药"));
        topCategories.add(new TopCategory(4,"补虚药"));

        return topCategories;
    }

    List<SubCategory> getSubCategories(TopCategory topCategory) {
        List<SubCategory> subCategories = new ArrayList<SubCategory>();
        SubCategory subCategory;
        //获取二级种类的Json数据
        //将Json数据转换为ArrayList<SunCategory>
        /*for(int i = 0; i < 9; i ++) {
            subCategory = new SubCategory(i, "苹果", topCategory, "/image");
            subCategories.add(subCategory);
        }*/
        //人参、何首乌、冬虫草、当归、乌药、枸杞子
        subCategory = new SubCategory(0, "人参", topCategory,"ic_good_1");
        subCategories.add(subCategory);
        subCategory = new SubCategory(1, "何首乌", topCategory,"ic_good_2");
        subCategories.add(subCategory);
        subCategory = new SubCategory(2, "冬虫草", topCategory,"ic_good_3");
        subCategories.add(subCategory);
        subCategory = new SubCategory(3, "当归", topCategory,"ic_good_4");
        subCategories.add(subCategory);
        subCategory = new SubCategory(4, "乌药", topCategory,"ic_good_5");
        subCategories.add(subCategory);
        subCategory = new SubCategory(5, "枸杞子", topCategory,"ic_good_6");
        subCategories.add(subCategory);

        return subCategories;
    }

    @Override
    public void onClick(View v) {
        //响应顶级分类的点击事件
        if (v.getClass().equals(MyTextView.class)) {
            Toast.makeText(getContext(),
                    "自定义的TextView被点击了！top_category_no = " + ((MyTextView)v).getNumber(),
                    Toast.LENGTH_SHORT).show();
            initRight(getView(), getLayoutInflater(null), v);
        }
        if(v.getClass().equals(MyLinearLayout.class)) {
            int product_subcategory_no = ((MyLinearLayout)v).getProduct_subcategory_no();
            Toast.makeText(getContext(),
                    "自定义的LinearLayout被点击了！sub_category_no = " + product_subcategory_no,
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(getContext(), ProductListActivity.class);
            intent.putExtra("product_subcategory_no", product_subcategory_no);
            startActivity(intent);
        }
        int id = v.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.searchButton_fragment_categray:
                intent.putExtra("keywords", editText_fragment_categray.getText().toString());
                intent.setClass(getContext(), SearchActivity.class);
                startActivity(intent);
                break;
        }
    }


}

