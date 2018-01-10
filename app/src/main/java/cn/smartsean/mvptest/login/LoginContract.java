package cn.smartsean.mvptest.login;

import cn.smartsean.mvptest.bean.UserInfoModel;

/**
 * 定义 View 和 Model 层规则
 * Created by smartsean on 2018/1/10.
 */
public interface LoginContract {
    interface ILoginModel {
        void login(String username, String password, OnLoginListener loginListener);
    }

    interface ILoginView {

        String getUserName();

        String getPassword();

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity(UserInfoModel userInfoModel);

        void showFailedError();
    }

}
