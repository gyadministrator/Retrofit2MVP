package com.gy.android.retrofit2mvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import presenter.LoginPresenter;
import view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText user;
    private EditText password;
    private Button login;

    private LoginPresenter loginPresenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loginPresenter = new LoginPresenter(this, this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(user.getText().toString(), password.getText().toString());
            }
        });
    }

    private void initView() {
        user = findViewById(R.id.user);
        password = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
    }

    @Override
    public void showDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在登录中...");
        progressDialog.show();
    }

    @Override
    public void dismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void error(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
