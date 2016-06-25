package com.jcodee.mod2class2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Author: johannfjs
 * Date: 4/6/16
 * Time: 10:15
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    //Creamos un método el cual nos creara un mensaje
    public void mostrarMensaje(String titulo, String mensaje) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(titulo);
        alertDialog.setMessage(mensaje);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.create().show();
    }
}
