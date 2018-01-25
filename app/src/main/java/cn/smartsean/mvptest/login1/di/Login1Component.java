package cn.smartsean.mvptest.login1.di;


import cn.smartsean.mvptest.login1.Login1Activity;
import dagger.Component;

/**
 * @author SmartSean Created on 2018/1/25 17:01.
 */
@Component(modules = Login1Module.class)
public interface Login1Component {
    void inject(Login1Activity login1Activity);
}
