package com.shalan.mohamed.mobilenumberverification;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.shalan.mohamed.verificationview.BlocksValuesListener;
import com.shalan.mohamed.verificationview.VerifyView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BlocksValuesListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private VerifyView verifyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyView = findViewById(R.id.verifyView);
        verifyView.setBlockValueListener(this);
    }

    @Override
    public void onValueChange(String value, String tag) {
        Log.i(TAG, "onValueChange: " + value + "\n" + tag);
    }

}
