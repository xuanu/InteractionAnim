package utils.zeffect.cn.animlibrary;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/08/22
 *      desc    ：
 *      version:：1.0
 * </pre>
 *
 * @author zzx
 * @see #jitter1(View) 抖动动画 ,这个抖动效果要好一点
 * @see #jitter2(View) 抖动动画
 */

public class AnimBuilder {

    /***
     * 抖动
     * @param pView 控件
     *              默认左右抖动
     *              参考[android中的animation动画左右摇摆晃动](http://blog.csdn.net/howlaa/article/details/43152309);
     */
    public void jitter1(View pView) {
        if (pView == null) return;
        if (duration < 1) duration = 300;
        if (repeatcount < 1) repeatcount = 3;
        if (toX == 0 && toY == 0 && fromX == 0 && fromY == 0) toX = 5;
        TranslateAnimation tempAnimation = new TranslateAnimation(fromX, toX, fromY, toY);
        tempAnimation.setDuration(duration);
        tempAnimation.setInterpolator(new CycleInterpolator(repeatcount));
        pView.startAnimation(tempAnimation);
    }

    /***
     * 抖动
     * @param pView 控件
     *       默认左右抖动
     *              参考[Android动画循环弹动cycleInterpolator](http://blog.csdn.net/zhangphil/article/details/49449935);
     */
    public void jitter2(View pView) {
        if (pView == null) return;
        if (duration < 1) duration = 100;
        if (repeatcount < 1) repeatcount = 3;
        if (toX == 0 && toY == 0 && fromX == 0 && fromY == 0) toX = 5;
        TranslateAnimation animation = new TranslateAnimation(fromX, toX, fromY, toY);
        animation.setInterpolator(new OvershootInterpolator());
        animation.setDuration(duration);
        animation.setRepeatCount(repeatcount);
        animation.setRepeatMode(Animation.REVERSE);
        if (mListener != null)
            animation.setAnimationListener(mListener);
        pView.startAnimation(animation);
    }


    /***
     * 模拟按下放大的效果
     * @param pView
     */
    public void scale(View pView) {
        if (pView == null) return;
        ScaleAnimation tempAnimation = new ScaleAnimation(0, 5, 0, 5);
        tempAnimation.setDuration(300);
        tempAnimation.setInterpolator(new LinearInterpolator());
        tempAnimation.start();
        pView.startAnimation(tempAnimation);
    }


    private float fromX, toX, fromY, toY;
    private Animation.AnimationListener mListener;
    private int duration;
    private int repeatcount;
    private boolean fillAfter;
    private boolean fillBefore;
    private int repeateMode;
    private int startOffset;
    private int zAdjustment;

    public boolean isFillAfter() {
        return fillAfter;
    }

    public AnimBuilder setFillAfter(boolean pFillAfter) {
        fillAfter = pFillAfter;
        return this;
    }

    public boolean isFillBefore() {
        return fillBefore;
    }

    public AnimBuilder setFillBefore(boolean pFillBefore) {
        fillBefore = pFillBefore;
        return this;
    }

    public int getRepeateMode() {
        return repeateMode;
    }

    public AnimBuilder setRepeateMode(int pRepeateMode) {
        repeateMode = pRepeateMode;
        return this;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public AnimBuilder setStartOffset(int pStartOffset) {
        startOffset = pStartOffset;
        return this;
    }

    public int getzAdjustment() {
        return zAdjustment;
    }

    public AnimBuilder setzAdjustment(int pZAdjustment) {
        zAdjustment = pZAdjustment;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public AnimBuilder setDuration(int pDuration) {
        duration = pDuration;
        return this;
    }

    public int getRepeatcount() {
        return repeatcount;
    }

    public AnimBuilder setRepeatcount(int pRepeatcount) {
        repeatcount = pRepeatcount;
        return this;
    }

    public Animation.AnimationListener getListener() {
        return mListener;
    }

    public AnimBuilder setListener(Animation.AnimationListener pListener) {
        mListener = pListener;
        return this;
    }

    public float getFromX() {
        return fromX;
    }

    public AnimBuilder setFromX(float pFromX) {
        fromX = pFromX;
        return this;
    }

    public float getToX() {
        return toX;
    }

    public AnimBuilder setToX(float pToX) {
        toX = pToX;
        return this;
    }

    public float getFromY() {
        return fromY;
    }

    public AnimBuilder setFromY(float pFromY) {
        fromY = pFromY;
        return this;
    }

    public float getToY() {
        return toY;
    }

    public AnimBuilder setToY(float pToY) {
        toY = pToY;
        return this;
    }

    /**
     * android:detachWallpaper setDetachWallpaper(boolean) 是否在壁纸上运行
     android:duration setDuration(long) 动画持续时间，毫秒为单位
     android:fillAfter setFillAfter(boolean) 控件动画结束时是否保持动画最后的状态
     android:fillBefore setFillBefore(boolean) 控件动画结束时是否还原到开始动画前的状态
     android:fillEnabled setFillEnabled(boolean) 与android:fillBefore效果相同
     android:interpolator setInterpolator(Interpolator) 设定插值器（指定的动画效果，譬如回弹等）
     android:repeatCount setRepeatCount(int) 重复次数
     android:repeatMode setRepeatMode(int) 重复类型有两个值，reverse表示倒序回放，restart表示从头播放
     android:startOffset setStartOffset(long) 调用start函数之后等待开始运行的时间，单位为毫秒
     android:zAdjustment setZAdjustment(int) 表示被设置动画的内容运行时在Z轴上的位置（top/bottom/normal），默认为normal

     * **/
}
