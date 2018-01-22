package com.seed.answer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seed.answer.R;
import com.seed.answer.ui.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: ZhangJun
 * @date: 2018/1/22
 * @ChangeLog: <重大改动>
 */


public class HomeFragment extends BaseFragment {

    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), R.layout.fragment_home, null);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //获取
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
