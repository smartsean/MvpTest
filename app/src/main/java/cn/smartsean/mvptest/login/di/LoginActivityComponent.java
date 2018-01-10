package cn.smartsean.mvptest.login.di;

import cn.smartsean.mvptest.login.LoginActivity;
import dagger.Component;

/**
 * Created by smartsean on 2018/1/10.
 */
@Component(modules = LoginModule.class)
public interface LoginActivityComponent {
    void inject(LoginActivity loginActivity);
}
