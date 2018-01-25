package cn.smartsean.mvptest.login1;

import cn.smartsean.base.BaseModel;
import cn.smartsean.base.BaseView;
import cn.smartsean.mvptest.bean.UserInfoModel;

/**
 * 定义 View 和 Model 层规则
 * Created by smartsean on 2018/1/10.
 */
public interface Login1Contract {
    interface ILoginModel extends BaseModel{
        void login(String username, String password, OnLoginListener loginListener);
    }

    interface ILoginView extends BaseView{

        String getUserName();

        String getPassword();

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity(UserInfoModel userInfoModel);

        void showFailedError();
    }

    interface OnLoginListener{
        void loginSuccess(UserInfoModel userInfoModel);

        void loginFailed();
    }

}
