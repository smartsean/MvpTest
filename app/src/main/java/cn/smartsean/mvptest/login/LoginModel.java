package cn.smartsean.mvptest.login;

import cn.smartsean.mvptest.bean.UserInfoModel;

/**
 * Created by smartsean on 2018/1/10.
 */
public class LoginModel implements LoginContract.ILoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("smartsean".equals(username) && "123456".equals(password)) {
                    UserInfoModel userInfoModel = new UserInfoModel();
                    userInfoModel.setUsername(username);
                    userInfoModel.setPassword(password);
                    loginListener.loginSuccess(userInfoModel);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
