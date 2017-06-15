package com.example.administrator.xyws_program.view.zidingyiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.xyws_program.R;
import com.example.administrator.xyws_program.util.DateTimeUils;

/**
 * /**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 黑明阳
 * 创建时间: 2017/6/9 11:46
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


public class Hmonth extends View {




    //-------------View相关-------------


    //View自身的宽和高
    private int mHeight;
    private int mWidth;

    //-------------统计图相关-------------
    //x轴的条目
    private int xNum = 4;
    //y轴的条目
    private int yNum = 3;
    //y轴条目之间的距离
    private int ySize = 250;
    //x轴条目之间的距离
    private int xSize = 220;
    //x y轴的长度,11个条目只有10段距离
    private int yLastSize = (yNum - 1) * ySize;
    private int xLastSize = xNum  * xSize;
    //-------------必须给的资源相关-------------
    private String[] xStr = new String[]{ "26", "31", "5", "10","15","20"};
    private String[] yStr = new String[]{ "零点","100","120"};
    private String str = "血压值（mmHg）";
    //折线表示的最大值,取yStr的最大值
    private int yMaxValue = Integer.parseInt(yStr[yStr.length - 1]);
    private int xMaxValue = Integer.parseInt(xStr[xStr.length - 1]);
    //折线真实值
    private int[] yValue = new int[]{100,150};
    private long s =DateTimeUils.gethaomiaoDate("12:00");
    private long[] xValue = new long[]{s};


    private int my=(120-100)*ySize;
    //-------------画笔相关-------------
    //边框的画笔
    private Paint borderPaint;
    //文字的画笔
    private Paint textPaint;
    //折线的画笔
    private Paint linePaint;
    //折线点画笔
    private Paint dianPaint;
    //黑点的画笔
    private Paint pointPaint;

    //-------------颜色相关-------------
    //边框颜色
    private int mColor = 0xFF888888;
    //文字颜色
    private int textColor = 0xFF888888;
    //折线颜色
    private int lineColor = 0xFF000000;
    //黑点颜色
    private int pointColor = 0xFF000000;


    public Hmonth(Context context, String[] yStr) {
        super(context);
        this.yStr=yStr;
    }

    public Hmonth(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Hmonth(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //初始化画笔
        initPaint();
        //画布移到左下角，留出100的空间给予文字填充
        canvas.translate(100, mHeight - 100);
        //画边框
        drawBorder(canvas);
        //画黑点
        drawPoint(canvas);
        //画文字
        drawText(canvas);
        //画折线
        drawLine(canvas);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        //边框画笔
        borderPaint = new Paint();
        borderPaint.setAntiAlias(true);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(mColor);
        borderPaint.setStrokeWidth(1);
        //文字画笔
        textPaint = new Paint();
        textPaint.setTextSize(30);
        textPaint.setColor(textColor);
        textPaint.setAntiAlias(true);
        //折线点画笔
        linePaint = new Paint();
        linePaint.setColor(ContextCompat.getColor(getContext(), R.color.colorRed));
        linePaint.setAntiAlias(true);

        //折线画笔
        dianPaint = new Paint();
        dianPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorRed));
        dianPaint.setAntiAlias(true);
        dianPaint.setStyle(Paint.Style.STROKE);
        dianPaint.setStrokeWidth(2);

        //黑点画笔
        pointPaint = new Paint();
        pointPaint.setAntiAlias(true);
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setColor(pointColor);
    }

    /**
     * 画边框
     *
     * @param canvas
     */
    private void drawBorder(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < yNum; i++) {
            //一条竖直的线
            if (i == 0) {
                //path.moveTo(0, -i * ySize);
                //path.lineTo(0, -(yNum - 1) * ySize);
            }
            //循环水平的线
            path.moveTo(0, -i * ySize);
            path.lineTo(xNum * xSize, -i * ySize);
            canvas.drawPath(path, borderPaint);
        }
    }

    /**
     * 画黑点
     *
     * @param canvas
     */
    private void drawPoint(Canvas canvas) {
        for (int i = 0; i <= xNum; i++) {
            canvas.drawCircle(i * xSize, 0, 5, pointPaint);
        }
    }

    /**
     * 画文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        //事先说明：文字排版为了好看，这里的20，都为20px的边距
        //x轴的文字
        for (int i = 0; i < xStr.length; i++) {
            //测量文字的宽高
            Rect rect = new Rect();
            textPaint.getTextBounds(xStr[i], 0, xStr[i].length(), rect);
            float textWidth = rect.width();
            float textHeight = rect.height();
            canvas.drawText(xStr[i], i * xSize - textWidth / 2, textHeight + 20, textPaint);
        }
        //y轴的文字
        for (int i = 0; i < yStr.length; i++) {
            //测量文字的宽高
            Rect rect = new Rect();
            textPaint.getTextBounds(yStr[i], 0, yStr[i].length(), rect);
            float textWidth = rect.width();
            float textHeight = rect.height();
            canvas.drawText(yStr[i], -textWidth - 20, i * (-ySize) + (textHeight / 2), textPaint);
        }
        //顶部文字
       canvas.drawText(str, 0, (-ySize) * (yStr.length - 1) - 20, textPaint);
    }

    /**
     * 画折线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        Path path = new Path();

        //画折线点
        canvas.drawCircle(880,-250, 9, linePaint);
        //画折线点
        canvas.drawCircle(880,-500, 9, linePaint);
    /*    for (int i = 0; i < yValue.length; i++) {
            //计算折线的位置：（当前点的值/最大值）拿到百分比percent
            //用百分比percent乘与y轴总长，就获得了折线的位置
            //这里拿到的百分比一直为0，所以换一种方法，先乘与总长再除与最大值，而且记得加上负号
            float position = -(yValue[i] * my / yMaxValue);
            float position1 = (DateTimeUils.gethaomiaoDate("12:00") * xLastSize / 1000*60*60*24);

            canvas.drawCircle(position1,-250, 9, linePaint);
            if (i == 0) {
                //第一个点需要移动
                path.moveTo(i  * xSize, position);

            } else {
                //其余的点直接画线
                path.lineTo(i * xSize, position);

                canvas.drawPath(path, dianPaint);
            }

        }*/
    }
}
