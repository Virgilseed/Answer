package com.seed.answer.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.seed.answer.utils.LogUtil;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: ZhangJun
 * @date: 2018/1/22
 * @ChangeLog: <重大改动>
 */


public class BaseActivity extends AppCompatActivity {

    protected static String TAG = "BaseActivity";
    private static Toast mToast = null;

    private ProgressDialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataTag();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (mLoadingDialog != null) {
                mLoadingDialog.dismiss();
                mLoadingDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected boolean showLoading() {
        try {
            if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
                mLoadingDialog.show();
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
            if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
                mLoadingDialog.dismiss();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void initDataTag() {
        TAG = getClass().getSimpleName();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void showToast(String content, int duration) {
        try {
            if (TextUtils.isEmpty(content)) {
                LogUtil.log_e(TAG, "toast内容不能为空!!!!!");
                return;
            }
            if (mToast == null) {
                mToast = Toast.makeText(this, content, duration);
            } else {
                mToast.setText(content);
                mToast.setDuration(duration);
            }

            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showToast(String content) {
        try {
            showToast(content, Toast.LENGTH_SHORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchFragmentForReplace(int layoutId, BaseFragment fragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(layoutId, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showFragment(int layoutId, BaseFragment fragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(layoutId, fragment).show(fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
