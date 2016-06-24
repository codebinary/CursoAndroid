package com.james.codebinary.appcato.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.james.codebinary.appcato.R;

import butterknife.BindView;

/**
 * Created by codebinary on 22/06/16.
 */

//Fragmento para el diseño del home
public class FragmentoInicio extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_inicio, container, false);
        return view;

    }
}
