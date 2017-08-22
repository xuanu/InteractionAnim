package utils.zeffect.cn.interactionanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;

import utils.zeffect.cn.animlibrary.AnimBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.anim_1).setOnClickListener(this);
        findViewById(R.id.anim_2).setOnClickListener(this);
        findViewById(R.id.anim_3).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.anim_1:
                new AnimBuilder().setToY(5).jitter1(v);
                break;
            case R.id.anim_2:
                new AnimBuilder().setToY(5).setDuration(300).jitter2(v);
                break;
            case R.id.anim_3:
                new AnimBuilder().scale(v);
                break;
        }
    }
}
