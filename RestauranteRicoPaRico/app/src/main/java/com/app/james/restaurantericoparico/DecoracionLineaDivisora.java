package com.app.james.restaurantericoparico;

/**
 * Created by James on 14/06/16.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ItemDecoration personalizado para dibujar la linea drawable/linea_divisoria.xml en los
 * elementos de un recycler view
 */
public class DecoracionLineaDivisora extends RecyclerView.ItemDecoration {

    private Drawable lineaDivisora;

    public DecoracionLineaDivisora(Context context){
        lineaDivisora = ContextCompat.getDrawable(context, R.drawable.linea_divisora);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++){
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + lineaDivisora.getIntrinsicHeight();

            lineaDivisora.setBounds(left, top, right, bottom);
            lineaDivisora.draw(c);
        }

    }
}
