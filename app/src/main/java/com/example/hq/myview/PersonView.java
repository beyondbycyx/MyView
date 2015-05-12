package com.example.hq.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hq on 2015/5/12.
 */
public class PersonView extends TextView {

    public PersonView(Context context)
    {
        super(context);

    }
    public PersonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取布局文件中，personattr里的配置信息
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.PersonAttr);
        //获取personattr里设置的值
        String  name=typedArray.getString(R.styleable.PersonAttr_name);
        int weight=typedArray.getInt(R.styleable.PersonAttr_weight, 1);//"1"为返回默认值
        boolean adult=typedArray.getBoolean(R.styleable.PersonAttr_adult, false);//默认false
        int age=typedArray.getInt(R.styleable.PersonAttr_age,20);
        String sex=typedArray.getString(R.styleable.PersonAttr_sex);
        float textSize=typedArray.getDimension(R.styleable.PersonAttr_textSize,20);

        //最后回收typedArray
        typedArray.recycle();

        String personText="姓名："+name+"\n"+"性别："+sex+"\n"+"年龄："+age+"\n"+
                   "是否成年："+getAdult(adult)+"\n"+"体重："+getWeight(weight);
        setText(personText);
        setTextSize(textSize);
    }
    public String getAdult(boolean b)
    {
        if(b)
            return "成年";
        return  "未成年";
    }

    public String getWeight(int value)
    {
        String s="";
        switch(value)
        {
            case 0:
                s="瘦弱";
                break;
            case 1:
                s="中等";
                break;
            case 2:
                s="肥胖";
                break;
            default:
                break;
        }

        return s;
    }
}








