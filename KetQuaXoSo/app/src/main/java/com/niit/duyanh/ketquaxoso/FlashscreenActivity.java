package com.niit.duyanh.ketquaxoso;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by DuyAnh on 11/07/2016.
 */
public class FlashscreenActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_flashscreen);

        View decor = getWindow().getDecorView();

        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Thread delays = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception e) {

                } finally {
                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it);
                }
            }
        };

        delays.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
