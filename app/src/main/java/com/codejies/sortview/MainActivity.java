package com.codejies.sortview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import widget.SortView;

public class MainActivity extends AppCompatActivity implements SortView.notifyOutsideListener{
    SortView sortView;

    Drawable[] sortDrawable;
    List<String> sortType= Arrays.asList("默认","价格","销量","距离","好评","优惠");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sortView= findViewById(R.id.sortView);
        initView();
    }

    private void initView(){
        sortDrawable=new Drawable[]{ContextCompat.getDrawable(this,R.mipmap.icon_sort_defalut),ContextCompat.getDrawable(this,R.mipmap.icon_sort_true),ContextCompat.getDrawable(this,R.mipmap.icon_sort_false)};
        sortView.setType(sortType,sortDrawable);
        sortView.setNotifyOutsideListener(this);
    }

    @Override
    public void notifySort(String tag, int desOrasc) {
        String text;
        if(desOrasc==0){
            text="选择的是"+tag+"标签的正序";
        }else{
            text="选择的是"+tag+"标签的倒序";
        }

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
