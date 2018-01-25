package cn.smartsean.mvptest.login1.di;

import cn.smartsean.mvptest.login1.Login1Contract;
import cn.smartsean.mvptest.login1.Login1Model;
import dagger.Module;
import dagger.Provides;

/**
 * @author SmartSean Created on 2018/1/25 17:02.
 */

@Module
public class Login1Module {

    private Login1Contract.ILoginView mILoginView;

    public Login1Module(Login1Contract.ILoginView ILoginView) {
        mILoginView = ILoginView;
    }

    @Provides
    Login1Contract.ILoginView getView() {
        return mILoginView;
    }

    @Provides
    Login1Contract.ILoginModel getModel(Login1Model model) {
        return model;
    }
}
