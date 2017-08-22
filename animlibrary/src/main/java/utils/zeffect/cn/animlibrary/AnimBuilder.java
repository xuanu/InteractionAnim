package utils.zeffect.cn.animlibrary;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
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
        if (toX == 0) toX = 5;
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
        if (toX == 0) toX = 5;
        TranslateAnimation animation = new TranslateAnimation(fromX, toX, fromY, toY);
        animation.setInterpolator(new OvershootInterpolator());
        animation.setDuration(duration);
        animation.setRepeatCount(repeatcount);
        animation.setRepeatMode(Animation.REVERSE);
        if (mListener != null)
            animation.setAnimationListener(mListener);
        pView.startAnimation(animation);
    }


    private float fromX, toX, fromY, toY;
    private Animation.AnimationListener mListener;
    private int duration;
    private int repeatcount;

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
}
