package com.jcodee.claserecycler.view;

import android.view.View;

/**
 * Author: johannfjs
 * Date: 11/6/16
 * Time: 11:54
 */
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
