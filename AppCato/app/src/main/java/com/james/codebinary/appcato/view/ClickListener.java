package com.james.codebinary.appcato.view;

import android.view.View;

/**
 * Created by James on 23/06/16.
 */
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
