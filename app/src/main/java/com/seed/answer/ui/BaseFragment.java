package com.seed.answer.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.seed.answer.utils.LogUtil;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: ZhangJun
 * @date: 2018/1/22
 * @ChangeLog: <重大改动>
 */


public class BaseFragment extends Fragment {

    protected static String TAG = "BaseFragment";
    private Context mContext;
    private ProgressDialog loadingDialog;

    public static BaseFragment newInstance(String param1, String param2) {
        BaseFragment baseFragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", param1);
        bundle.putString("param2", param2);
        baseFragment.setArguments(bundle);
        return baseFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mContext = context;
            TAG = getClass().getSimpleName();
            loadingDialog = new ProgressDialog(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
                loadingDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void initView(){

    }

    protected void initData(){

    }

    protected void initEvent(){

    }

    protected void initBundle(){

    }

    protected boolean showLoading() {
        try {
            if (loadingDialog != null && !loadingDialog.isShowing()) {
                loadingDialog.show();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    protected boolean dismissLoading() {
        try {
            if (loadingDialog != null && loadingDialog.isShowing()) {
                loadingDialog.dismiss();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected void finish() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                getActivity().finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showToast(String content, int time) {
        try {
            if (TextUtils.isEmpty(content)) {
                LogUtil.log_e(TAG, "toast内容不能为空!!!!!");
            }
            Toast.makeText(mContext, content, time).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showToast(String content) {
        try {
            if (TextUtils.isEmpty(content)) {
                LogUtil.log_e(TAG, "toast内容不能为空!!!!!");
            }
            Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
