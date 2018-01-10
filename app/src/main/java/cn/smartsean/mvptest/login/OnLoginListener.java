package cn.smartsean.mvptest.login;

import cn.smartsean.mvptest.bean.UserInfoModel;

/**
 * Created by smartsean on 2018/1/10.
 */

public interface OnLoginListener {
    void loginSuccess(UserInfoModel userInfoModel);

    void loginFailed();
}
