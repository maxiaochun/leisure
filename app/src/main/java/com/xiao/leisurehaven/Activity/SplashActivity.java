package com.xiao.leisurehaven.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiao.leisurehaven.Activity.LoginActivity;
import com.xiao.leisurehaven.R;

public class SplashActivity extends AppCompatActivity {

    private Button bt_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bt_load = (Button) findViewById(R.id.bt_load);
        bt_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }


}
