package com.algorepublic.cityhistory.cityhistory;

import android.support.v4.app.Fragment;

/**
 * Created by waqas on 6/18/15.
 */
public class BaseFragment extends Fragment {

    public static BaseFragment newInstance(String param1, String param2) {
        BaseFragment fragment = new BaseFragment();
        return fragment;
    }
}
