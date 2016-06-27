package com.toeat.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toeat.R;

public class FragmentUser extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment_user, container, false);
        return  rootView;
    }
}
