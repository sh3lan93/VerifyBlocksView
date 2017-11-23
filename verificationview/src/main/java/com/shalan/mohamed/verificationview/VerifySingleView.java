package com.shalan.mohamed.verificationview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by mohamed on 11/22/17.
 */

class VerifySingleView extends RelativeLayout {

    public VerifySingleView(Context context) {
        super(context);
        init(context);
    }

    public VerifySingleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VerifySingleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public VerifySingleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){
        inflate(context, R.layout.verify_single_view, this);
    }
}
