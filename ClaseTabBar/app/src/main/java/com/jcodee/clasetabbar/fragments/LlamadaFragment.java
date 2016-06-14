package com.jcodee.clasetabbar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jcodee.clasetabbar.MostrarActivity;
import com.jcodee.clasetabbar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: johannfjs
 * Date: 11/6/16
 * Time: 12:44
 */
public class LlamadaFragment extends Fragment {
    @BindView(R.id.btnAnimacion)
    Button btnAnimacion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_llamada, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnAnimacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MostrarActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                //getActivity().overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
            }
        });
    }
}
