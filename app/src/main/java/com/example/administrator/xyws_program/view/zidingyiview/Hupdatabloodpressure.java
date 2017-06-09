package com.example.administrator.xyws_program.view.zidingyiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.xyws_program.R;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:上传血压数据数据自定义View
 * 创建人: 黑明阳
 * 创建时间: 2017/6/9 8:03
 * 修改人:
 * 修改内容:
 * 修改时间:
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */


public class Hupdatabloodpressure extends View {

    private Paint paint;
    private Canvas canvas1;
    private Paint painttext;


    //重写三个构造方法
    public Hupdatabloodpressure(Context context) {
        super(context);
    }

    public Hupdatabloodpressure(Context context, AttributeSet attrs) {
        super(context, attrs);

        //创建一个画笔（用于圆环的绘画）
        paint = new Paint();
        //设置画笔颜色
        paint.setColor(ContextCompat.getColor(context, R.color.colorRed));
        //绘制空心圆或 空心矩形
        paint.setStyle(Paint.Style.STROKE);
        //设置空心圆或 空心矩形宽度
        paint.setStrokeWidth(8);

        //创建一个画笔（用于文字的绘画）
        painttext = new Paint();
        //设置文字大小
        painttext.setTextSize(60);
        //设置画笔颜色
        painttext.setColor(ContextCompat.getColor(context,R.color.colorGreen));
        //设置字体是否加宽
        painttext.setFakeBoldText(true);

    }

    public Hupdatabloodpressure(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private float x=160;
    private float y=160;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建一个画布
        canvas1 =canvas;
        //画圆环
        canvas1.drawCircle(x,y,160,paint);

        //绘制文字
        canvas1.drawText("上传",x-70,y-20,painttext);
        canvas1.drawText("血压数据",x-120,y+40,painttext);

    }


    //触摸事件的监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                //得到焦点的XY
                x=event.getX();
                y=event.getY();

                //刷新
                invalidate();

                break;

            case MotionEvent.ACTION_DOWN:
                break;



        }
        return true;
    }
}
