package com.james.codebinary.appcato;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.james.codebinary.appcato.fragmentos.FragmentoInicio;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    //Instancia del drawer
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    //Instancia del Navigation Drawer
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    //Instancia del Toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    //Título inicial de drawer
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agregamos el toolbar
        agregarToolbar();

        //Comprobamos si el navigationview es diferente a nulo


    }

    //Método que agrega el toolbar, con nombre de la aplicacion
    public void agregarToolbar(){
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            //Poner icono de drawer toggle
            actionBar.setHomeAsUpIndicator(R.drawable.drawer_toggle);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    //Método que realiza la funcion al precionar las 3 linea del menu se muestra el
    //navigation drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void seleccionarItem(String title){

        //Enviar titulo como argumento del fragmento
        Bundle args = new Bundle();
        args.putString(FragmentoInicio.ARG_SECTION_TITLE, title);

        //Creamos el fragmento
        Fragment fragment = FragmentoInicio.newInstance(title);
        //Setemos el argumento en el fragmento
        fragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();



    }
}
