package cn.smartsean.mvptest.login1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.smartsean.base.BaseMvpActivity;
import cn.smartsean.mvptest.MainActivity;
import cn.smartsean.mvptest.R;
import cn.smartsean.mvptest.bean.UserInfoModel;
import cn.smartsean.mvptest.login1.di.DaggerLogin1Component;
import cn.smartsean.mvptest.login1.di.Login1Module;

public class Login1Activity extends BaseMvpActivity<Login1Presenter> implements Login1Contract.ILoginView {

    private EditText usernameEt, passwordEt;
    private Button loginBtn, clearBtn;
    private ProgressDialog progressDialog;

    private Context mContext;

    private static final String TAG = "Login1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        initView();
        mContext = this;
        DaggerLogin1Component.builder().login1Module(new Login1Module(this)).build().inject(this);
    }

    private void initView() {
        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);
        clearBtn = findViewById(R.id.clear_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.clear();
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
        finish();
    }

    @Override
    public void showFailedError() {
        Log.d(TAG, "showFailedError: 登陆失败");
        Toast.makeText(mContext, "登陆失败，请重新尝试", Toast.LENGTH_SHORT).show();
    }
}
