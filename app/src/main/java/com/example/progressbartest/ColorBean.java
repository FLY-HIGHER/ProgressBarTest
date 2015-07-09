package com.example.progressbartest;

/**
 * Created by Ô¶·É on 2015/7/3.
 */
public class ColorBean {
    private int mColor;
    private long mValue;
    private int mRound = 2;

    public ColorBean(int color, long value, int round) {
        this(color, value);
        mRound = round;
    }

    public ColorBean(int color, long value) {
        mColor = color;
        mValue = value;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int mColor) {
        this.mColor = mColor;
    }

    public long getValue() {
        return mValue;
    }

    public void setValue(int mValue) {
        this.mValue = mValue;
    }

    public int getRound() {
        return mRound;
    }

    public void setRound(int round) {
        this.mRound = round;
    }
}
