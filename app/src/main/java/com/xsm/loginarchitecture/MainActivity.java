package com.xsm.loginarchitecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xsm.loginarchitecture.lib_login.annotation.LoginFilter;
import com.xsm.loginarchitecture.util.SharePreferenceUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.skip).setOnClickListener(this);
    }

    @LoginFilter()
    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void skipNoLogin(View view) {
        startActivity(new Intent(this, ThridActivity.class));
    }


    public void skipLoginFilter(View view) {
        startActivity(new Intent(this, ExtendsLoginFilterActivity.class));
    }

    public void clearLoginInfo(View view) {
        SharePreferenceUtil.clearSharePref(SharePreferenceUtil.IS_LOGIN, this);
        Toast.makeText(this, "清除登录信息成功！", Toast.LENGTH_SHORT).show();
    }


}
