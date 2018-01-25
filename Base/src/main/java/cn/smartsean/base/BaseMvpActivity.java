package cn.smartsean.base;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * @author SmartSean Created on 2018/1/25 16:24.
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P mPresenter;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        this.mPresenter = null;
    }
}
