package com.jcodee.clasetabbar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jcodee.clasetabbar.adapters.DatosAdapter;
import com.jcodee.clasetabbar.fragments.ContactoFragment;
import com.jcodee.clasetabbar.fragments.LlamadaFragment;
import com.jcodee.clasetabbar.fragments.MensajeFragment;
import com.jcodee.clasetabbar.modelos.Datos;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private DatosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar.setTitle("Hola desde Java");
        adapter = new DatosAdapter(getSupportFragmentManager());
        adapter.agregarPantallas(new Datos(new LlamadaFragment(), "Llamada"));
        adapter.agregarPantallas(new Datos(new MensajeFragment(), "Mensaje"));
        adapter.agregarPantallas(new Datos(new ContactoFragment(), "Contacto"));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_launcher));

        toolbar.setVisibility(View.INVISIBLE);
        /*
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 1)
                    viewPager.setCurrentItem(0);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
    }
}
