package com.android.neo.tp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.neo.tp.FragmetViewActivity;
import com.android.neo.tp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FirstFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // do modification here before returning
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
