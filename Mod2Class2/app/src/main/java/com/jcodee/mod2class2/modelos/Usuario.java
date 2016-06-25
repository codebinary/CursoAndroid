package com.jcodee.mod2class2.modelos;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Author: johannfjs
 * Date: 4/6/16
 * Time: 10:31
 */
public class Usuario extends RealmObject {
    public static final String C_USUARIO = "usuario";
    public static final String C_CONTRASENIA = "contrasenia";
    public static final String C_ID = "id";

    @PrimaryKey
    private long id;
    private String usuario;
    private String correo;
    private String nombre;
    private String contrasenia;

    //Obtener el último id de la tabla
    public static int getLastId() {
        Realm realm = Realm.getDefaultInstance();
        Number result = realm.where(Usuario.class).max(C_ID);
        return result == null ? 0 : result.intValue() + 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
