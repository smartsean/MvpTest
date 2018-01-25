package cn.smartsean.base;

import android.content.Context;

/**
 * @author SmartSean Created on 2018/1/25 16:18.
 */

public class BasePresenter<M extends BaseModel, V extends BaseView> implements IPresenter {


    protected M mModel;

    protected V mView;

    public BasePresenter(M model, V view) {
        mModel = model;
        mView = view;
    }

    public BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void onDestroy() {
        if (mModel != null) {
            mModel.onDestroy();
        }
        this.mModel = null;
        this.mView = null;
    }

    public Context getViewContext() {
        return null;
    }
}
