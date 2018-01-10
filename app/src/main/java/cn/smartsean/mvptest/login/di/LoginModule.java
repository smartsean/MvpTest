package cn.smartsean.mvptest.login.di;

import cn.smartsean.mvptest.login.LoginContract;
import cn.smartsean.mvptest.login.LoginModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by smartsean on 2018/1/10.
 */
@Module
public class LoginModule {

    private LoginContract.ILoginView iLoginView;

    public LoginModule(LoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Provides
    LoginContract.ILoginView getLoginView() {
        return iLoginView;
    }

    @Provides
    LoginContract.ILoginModel getLoginModel() {
        return new LoginModel();
    }
}
