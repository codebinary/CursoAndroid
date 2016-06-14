package com.jcodee.clasetabbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MostrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        //overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
    }
}
