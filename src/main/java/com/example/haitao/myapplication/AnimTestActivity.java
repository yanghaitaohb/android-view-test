package com.example.haitao.myapplication;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by haitao on 2018/10/3.
 */

public class AnimTestActivity extends Activity {
    View view;
    AnimatorSet set;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_test);
        view = findViewById(R.id.view);

        ValueAnimator valueAnimator = ObjectAnimator.ofInt(view, "backgroundColor", 0xff0000ff, 0xffffffff);
        valueAnimator.setDuration(3000);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        valueAnimator.start();

        set = new AnimatorSet();

        //X轴旋转
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view,"rotationX", 0, 360);
        anim1.setRepeatCount(ObjectAnimator.INFINITE); //顺序播放时无法播放下一项
        anim1.setRepeatMode(ObjectAnimator.REVERSE);
        //Y轴旋转
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "rotationY", 0, 360);
        anim2.setRepeatCount(ObjectAnimator.INFINITE);
        anim2.setRepeatMode(ObjectAnimator.REVERSE);
        //旋转
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(view, "rotation", 0, -90);
        anim3.setRepeatCount(ObjectAnimator.INFINITE);
        anim3.setRepeatMode(ObjectAnimator.REVERSE);
        //平移
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(view, "translationX", 0, 90);
        ObjectAnimator anim5 = ObjectAnimator.ofFloat(view, "translationY", 0, 90);
        anim4.setRepeatCount(ObjectAnimator.INFINITE);
        anim4.setRepeatMode(ObjectAnimator.REVERSE);
        anim5.setRepeatCount(ObjectAnimator.INFINITE);
        anim5.setRepeatMode(ObjectAnimator.REVERSE);
        //缩放
        ObjectAnimator anim6 = ObjectAnimator.ofFloat(view, "scaleX", 1, 1.5f);
        ObjectAnimator anim7 = ObjectAnimator.ofFloat(view, "scaleY", 1, 2.5f);
        anim6.setRepeatCount(ObjectAnimator.INFINITE);
        anim6.setRepeatMode(ObjectAnimator.REVERSE);
        anim7.setRepeatCount(ObjectAnimator.INFINITE);
        anim7.setRepeatMode(ObjectAnimator.REVERSE);
        //透明渐变
        ObjectAnimator anim8 = ObjectAnimator.ofFloat(view, "alpha", 1, 0.25f, 1, 0.5f);
        anim8.setRepeatCount(ObjectAnimator.INFINITE);
        anim8.setRepeatMode(ObjectAnimator.REVERSE);

        set.playTogether(anim1,anim2,anim3,anim4,anim5,anim7,anim8,valueAnimator
        );
        set.setDuration(5000).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        set.cancel();
    }
}
