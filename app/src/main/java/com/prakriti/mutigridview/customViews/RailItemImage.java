package com.prakriti.mutigridview.customViews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.prakriti.mutigridview.R;

public class RailItemImage extends ImageView implements View.OnFocusChangeListener {

    private static final String TAG = "RailItemImage";
    private Drawable poster_bg;

    public RailItemImage(Context context) {
        super(context);
        initLayout();
    }

    public RailItemImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    public RailItemImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    public RailItemImage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout();
    }

    private void initLayout() {
        poster_bg = getResources().getDrawable(R.drawable.poster_bg, null);
        setOnFocusChangeListener(this);
        setFocusable(true);
        setBackground(null);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v instanceof RailItemImage && v.hasFocus()) {
            Log.d(TAG, "onFocusChange: Rails linear layout");
            v.setForeground(poster_bg);
            v.animate().scaleX(1.1f).scaleY(1.1f).start();
        }
        else {
            v.animate().scaleX(1.0f).scaleY(1.0f).start();
            v.setForeground(null);
        }
    }
}