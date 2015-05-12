# MyView
1.attrs.xml
  <declare-styleable name="PersonAttr">
      <attr name="name" format="string|reference"/>
        <attr name="sex" format="string"/>
        <attr name="age" format="integer"/>
        <attr name="weight">
            <flag name="fat" value="2"/>
            <flag name="mid" value="1"/>
            <flag name="thin" value="0"/>
        </attr>
        <attr name="adult" format="boolean"/>
        <attr name="textSize" format="dimension"/>
    </declare-styleable>
2.activity_main.xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:personattr="http://schemas.android.com/apk/com.example.hq.myview"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.example.hq.myview.PersonView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        personattr:name="hq"
        personattr:sex="man"
        personattr:weight="fat"
        personattr:adult="true"
        personattr:age="10"
        personattr:textSize="@dimen/person_textsize"
        />
</RelativeLayout>
3.PersonText (extends TextView)
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
