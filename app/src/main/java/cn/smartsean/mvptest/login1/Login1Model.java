package cn.smartsean.mvptest.login1;

import javax.inject.Inject;

import cn.smartsean.mvptest.bean.UserInfoModel;

/**
 * @author SmartSean Created on 2018/1/25 16:49.
 */

public class Login1Model implements Login1Contract.ILoginModel {

    @Inject
    public Login1Model() {
    }

    @Override
    public void login(final String username, final String password, final Login1Contract.OnLoginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("sean".equals(username) && "2".equals(password)) {
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

    @Override
    public void onDestroy() {
        // TODO: 2018/1/25 销毁持有的引用
    }
}
