package com.xiao.leisurehaven.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.xiao.leisurehaven.Activity.HomeActivity;
import com.xiao.leisurehaven.R;
import com.xiao.leisurehaven.Utils.ConstentValue;
import com.xiao.leisurehaven.Utils.SpUtil;

/**
 * Created by hasee on 2016/4/28.
 */
public class LoginActivity extends Activity {

    private EditText et_login_name;
    private EditText et_login_password;
    private CheckBox cb_rem;
    private CheckBox cb_login_auto;
    private Button bt_login;
    private Button bt_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        initUI();

        //5.点击登录，5.1保存用户名密码 5.2跳转到下一页
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断是否首次登陆
                String psd = SpUtil.getString(getApplicationContext(), ConstentValue.PASSWORD, "");
                if (TextUtils.isEmpty(psd)) {
                    setFirstlogin();
                } else {
                    setlogin();
                }
            }
        });
    }
    private void initUI() {
        et_login_name = (EditText) findViewById(R.id.et_login_name);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        cb_rem = (CheckBox) findViewById(R.id.cb_rem);
        cb_login_auto = (CheckBox) findViewById(R.id.cb_login_auto);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_exit = (Button) findViewById(R.id.bt_exit);
    }

    private void setlogin() {
    }

    private void setFirstlogin() {
        //首次登陆
        String password = et_login_password.getText().toString();
        //5.1判断是否为空
        if (password != null) {
            //5.2判断并记录是否记住密码
            boolean isCheck = cb_rem.isChecked();
            SpUtil.putBoolean(getApplicationContext(), ConstentValue.REM_PASSWORD, isCheck);
            //5.3保存密码
            SpUtil.putString(getApplicationContext(), ConstentValue.PASSWORD, password);
            // 5.4跳转到下一页
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        } else {
            Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }





}