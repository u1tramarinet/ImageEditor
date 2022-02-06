package com.u1tramarinet.imageeditor.ui.trimming;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.u1tramarinet.imageeditor.R;

public class TrimmingFragment extends Fragment {

    public TrimmingFragment() {
    }


    public static TrimmingFragment newInstance() {
        return new TrimmingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trimming, container, false);
    }
}