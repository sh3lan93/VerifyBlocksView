package com.shalan.mohamed.verificationview;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by mohamed on 11/22/17.
 */

public class VerifyView extends LinearLayout implements TextWatcher {
    public static final String TAG = VerifyView.class.getSimpleName();
    private TypedArray customizationArray;
    private int numOfBlocks = 0;
    private int borderColor;
    private VerifySingleView verifySingleView;
    private LinearLayout rootView;
    private EditText editText;
    private String deviceLang;
    private BlocksValuesListener blockValueListener;
    private int blocksTextColor;

    public VerifyView(Context context) {
        super(context);
        init(context, null);
    }

    public VerifyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public VerifyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public VerifyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void init(Context context, AttributeSet attrs){
        inflate(context, R.layout.verify_view, this);
        this.rootView = findViewById(R.id.root_view);
        customizationArray = context.obtainStyledAttributes(attrs, R.styleable.VerifyView);
        try {
            numOfBlocks = customizationArray.getInteger(R.styleable.VerifyView_num_of_blocks, 0);
            blocksTextColor = customizationArray.getColor(R.styleable.VerifyView_blocks_text_color, Color.BLACK);
        }catch (Exception e){
            Log.i(TAG, "init: " + e.getLocalizedMessage());
        }
        this.deviceLang = LocalizationUtils.getDeviceLanguage();
        if (numOfBlocks <= 10){
            for (int i = 0; i < numOfBlocks; i++){
                verifySingleView = new VerifySingleView(context);
                editText = verifySingleView.findViewById(R.id.valueEditText);
                editText.setTag(i);
                editText.addTextChangedListener(this);
                editText.setTextLocale(LocalizationUtils.getDefLocal());
                editText.setTextColor(blocksTextColor);
                LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
                verifySingleView.setLayoutParams(params);
                this.rootView.addView(verifySingleView, i);
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        int lastEditIndex = 0;
        for (int k = 0; k < this.rootView.getChildCount(); k++){
            int nextFocusTag = k;
            EditText editText = this.rootView.getChildAt(k).findViewWithTag(k);
           if (editText.getText().length() == 0){
               this.rootView.getChildAt(k).findViewWithTag(k).requestFocus();
               lastEditIndex = k - 1;
               break;
           }
        }
        if (this.blockValueListener != null){
            if (lastEditIndex >= 0){
                EditText editText = this.rootView.getChildAt(lastEditIndex).findViewWithTag(lastEditIndex);
                blockValueListener.onValueChange(editText.getText().toString(), editText.getTag().toString());
            }
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public VerifyView setViewTextTypeFace(AssetManager manager, String path){
        Typeface typeface = Typeface.createFromAsset(manager, path);
        for (int i = 0; i < this.rootView.getChildCount(); i++){
            EditText editText = this.rootView.getChildAt(i).findViewWithTag(i);
            editText.setTypeface(typeface);
        }
        return this;
    }

    public ArrayList<String> getValues(){
        ArrayList<String> values = new ArrayList<>();
        for (int i = 0; i < this.rootView.getChildCount(); i++){
            EditText editText = this.rootView.getChildAt(i).findViewWithTag(i);
            values.add(editText.getText().toString());
        }
        return values;
    }

    public String getBlockValue(String tag){
        String value = "";
        EditText editText = this.rootView.getChildAt(Integer.parseInt(tag)).findViewWithTag(Integer.parseInt(tag));
        value = editText.getText().toString();
        return value;
    }

    public VerifyView setBlockValueListener(BlocksValuesListener blockValueListener){
        this.blockValueListener = blockValueListener;
        return this;
    }

    public VerifyView setBlockHint(String hint){
        for (int i = 0; i < this.rootView.getChildCount(); i++){
            EditText editText = this.rootView.getChildAt(i).findViewWithTag(i);
            editText.setHint(hint);
        }
        return this;
    }

    public VerifyView setBlockHint(@StringRes int hint){
        for (int i = 0; i < this.rootView.getChildCount(); i++){
            EditText editText = this.rootView.getChildAt(i).findViewWithTag(i);
            editText.setHint(hint);
        }
        return this;
    }

}
