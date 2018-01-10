package cn.smartsean.mvptest.login;

import android.os.Handler;

import javax.inject.Inject;

import cn.smartsean.mvptest.bean.UserInfoModel;

/**
 * Created by smartsean on 2018/1/10.
 */
public class LoginPresenter {

    private LoginContract.ILoginView loginView;

    private LoginContract.ILoginModel loginModel;

    @Inject
    public LoginPresenter(LoginContract.ILoginView loginView, LoginContract.ILoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    private Handler mHandler = new Handler();

    /**
     * 模拟登陆
     */
    public void login() {
        loginView.showLoading();
        loginModel.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final UserInfoModel userInfoModel) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(userInfoModel);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                loginView.showFailedError();
                loginView.hideLoading();
            }
        });
    }


    /**
     * 清除账户名和密码
     */
    public void clear() {
        loginView.clearUserName();
        loginView.clearPassword();
    }

}
