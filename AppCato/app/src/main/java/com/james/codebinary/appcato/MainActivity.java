package com.james.codebinary.appcato;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.james.codebinary.appcato.fragmentos.FragmentoCalendario;
import com.james.codebinary.appcato.fragmentos.FragmentoHomenaje;
import com.james.codebinary.appcato.fragmentos.FragmentoInicio;
import com.james.codebinary.appcato.fragmentos.FragmentoNovedad;
import com.james.codebinary.appcato.fragmentos.FragmentoPaises;
import com.james.codebinary.appcato.fragmentos.FragmentoProgramacion;
import com.james.codebinary.appcato.fragmentos.FragmentoVideos;

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
        if(navigationView != null){
            prepararDrawer(navigationView);
            //Seleccionamos el item por defecto
            seleccionarItem(navigationView.getMenu().getItem(0));
        }

    }

    private void prepararDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                //Pintamos el item seleccionado
                seleccionarItem(menuItem);
                //Cerramos el drawerLayout al pulsar un item del menu
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    //Metodo que selecciona el fragmento a utilizar
    private void seleccionarItem(MenuItem itemDrawer) {
        Fragment fragmentoGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Aqui realizamos el cambio de fragmento
        switch (itemDrawer.getItemId()){
            case R.id.nav_home:
                fragmentoGenerico = new FragmentoInicio();
                break;
            case R.id.nav_novedades:
                fragmentoGenerico = new FragmentoNovedad();
                break;
            case R.id.nav_calendario:
                fragmentoGenerico = new FragmentoCalendario();
                break;
            case R.id.nav_programacion:
                fragmentoGenerico = new FragmentoProgramacion();
                break;
            case R.id.nav_homenaje:
                fragmentoGenerico = new FragmentoHomenaje();
                break;
            case R.id.nav_paises:
                fragmentoGenerico = new FragmentoPaises();
                break;
            case R.id.nav_videos:
                fragmentoGenerico = new FragmentoVideos();
                break;
        }
        //Reemplazamos el fragmento por el fragmento del item seleccionado
        //Para eso hacemos una transacción
        if(fragmentoGenerico != null){
            fragmentManager.beginTransaction()
                    .replace(R.id.main_content, fragmentoGenerico)
                    .commit();
        }
        //Seteamos el titulo
        setTitle(itemDrawer.getTitle());
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
            case R.id.action_buscar:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //Método que agrega botones al Action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.boton_accion, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
