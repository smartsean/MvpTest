package cn.smartsean.mvptest.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import cn.smartsean.lib.utils.Logger;
import cn.smartsean.mvptest.MainActivity;
import cn.smartsean.mvptest.R;
import cn.smartsean.mvptest.bean.UserInfoModel;
import cn.smartsean.mvptest.login.di.DaggerLoginActivityComponent;
import cn.smartsean.mvptest.login.di.LoginModule;

/**
 * Created by smartsean on 2018/1/10.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.ILoginView {


    private EditText usernameEt, passwordEt;
    private Button loginBtn, clearBtn;
    private ProgressDialog progressDialog;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        DaggerLoginActivityComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    private void initView() {
        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);
        clearBtn = findViewById(R.id.clear_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.clear();
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("加载中");
    }

    @Override
    public String getUserName() {
        return usernameEt.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return passwordEt.getText().toString().trim();
    }

    @Override
    public void clearUserName() {
        usernameEt.setText("");
    }

    @Override
    public void clearPassword() {
        passwordEt.setText("");
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void toMainActivity(UserInfoModel userInfoModel) {
        MainActivity.startAction(this, userInfoModel.getUsername());
    }

    @Override
    public void showFailedError() {
        Logger.d("登陆失败");
        Toast.makeText(LoginActivity.this, "登陆失败，请重新尝试", Toast.LENGTH_SHORT).show();
    }
}
