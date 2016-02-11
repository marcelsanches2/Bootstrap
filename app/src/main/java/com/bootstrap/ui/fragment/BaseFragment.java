package com.bootstrap.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bootstrap.ui.activity.BaseActivity;

import butterknife.ButterKnife;
import roboguice.fragment.RoboFragment;

/**
 * Created by msanches on 04/09/15.
 */
public abstract class BaseFragment extends RoboFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    protected abstract int getLayoutResource();


    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }


}
