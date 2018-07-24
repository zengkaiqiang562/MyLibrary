package com.zengk.library.resources;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.zengk.mylibrary.R;

/**
 * Created by Administrator on 2018\7\24 0024.
 */

public class AnimationDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setBackgroundResource(R.drawable.animation);
        AnimationDrawable anim = (AnimationDrawable) iv.getBackground();
        anim.start();
//        anim.stop(); to stop animation
    }

}
