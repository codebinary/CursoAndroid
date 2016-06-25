package com.jcodee.mod2class1;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jcodee.mod2class1.sqlite.SentenciaSQL;

import butterknife.ButterKnife;

/**
 * Author: johannfjs
 * Date: 28/5/16
 * Time: 11:15
 */
public class BaseActivity extends AppCompatActivity {
    //Declaramos una variable de tipo sentenciaSQL para la interacción con nuestra BD
    public SentenciaSQL sentenciaSQL;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //Inicializamos todos los componentes de ButteKnife
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inicializamos nuestra variable
        sentenciaSQL = new SentenciaSQL(this);
    }
}
