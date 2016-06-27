package com.toeat.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toeat.R;

import java.util.zip.Inflater;

public class FragmentDown extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_fragment_down,container,false);
    }
}
