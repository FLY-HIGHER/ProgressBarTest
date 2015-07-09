package com.example.progressbartest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ColorsBar extends View {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private List<ColorBean> mColorBeans = new ArrayList<>();
    private ColorBean mBgColorBean;

    public ColorsBar(Context context, AttributeSet attrs,
                     int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public ColorsBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ColorsBar(Context context) {
        super(context);
        initView(context);
    }

    public List<ColorBean> getColorBeans() {
        return mColorBeans;
    }

    public void setColorBeans(List<ColorBean> colorBeans) {
        this.mColorBeans =colorBeans;
    }

    public ColorBean getBgColorBean() {
        return mBgColorBean;
    }

    public void setBgColorBean(ColorBean bgColorBean) {
        this.mBgColorBean = bgColorBean;
    }

    private void initView(Context context) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setColor(mBgColorBean.getColor());
        RectF rectBg = new RectF(0, 0, mWidth, mHeight);
        int bgRound = dipToPx(mBgColorBean.getRound() + 1);
        canvas.drawRoundRect(rectBg, bgRound, bgRound, mPaint);

        long total = mBgColorBean.getValue();
        if (total <= 0) {
            return;
        }

        RectF rect;
        for (int i = mColorBeans.size() - 1; i >= 0; i--) {
            ColorBean colorBean = mColorBeans.get(i);
            long value = colorBean.getValue();
            if (value <= 0){
                continue;
            }

            for (int j = i-1; j >= 0; j--){
                value += mColorBeans.get(j).getValue();
            }

            int xEnd = (int) ((value * 1.0 / total) * mWidth);
            int round = dipToPx(colorBean.getRound());
            mPaint.setColor(colorBean.getColor());
            rect = new RectF(0, 0, xEnd, mHeight);
            canvas.drawRoundRect(rect, round, round, mPaint);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.EXACTLY || widthSpecMode == MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize;
        } else {
            mWidth = 0;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            mHeight = dipToPx(15);
        } else {
            mHeight = heightSpecSize;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }
}
