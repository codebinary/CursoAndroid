package com.jcodee.mod2class1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jcodee.mod2class1.models.Usuario;

import java.util.ArrayList;

/**
 * Author: johannfjs
 * Date: 28/5/16
 * Time: 10:38
 */
public class SentenciaSQL {
    //Declarando una variable de tipo conexión a la bd
    private ManageOpenHelper conexion;

    //Creamos un contructor
    public SentenciaSQL(Context context) {
        //Inicializamos nuestra conexión a la bd
        conexion = new ManageOpenHelper(context);
    }

    public boolean registrarUsuario(Usuario usuario) {
        //Obtener permiso de escritura de nuestra bd
        SQLiteDatabase db = conexion.getWritableDatabase();
        try {
            //Cargar los datos que se van a enviar
            ContentValues contentValues = new ContentValues();
            //Cargamos los datos a ingresar a la bd
            contentValues.put("usuario", usuario.getUsuario());
            contentValues.put("nombre_completo", usuario.getNombreCompleto());
            contentValues.put("correo", usuario.getCorreo());
            contentValues.put("contrasenia", usuario.getContrasenia());
            //Insertar el registro a nuestra bd
            db.insert("usuarios", null, contentValues);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validarUsuario(String usuario, String contrasenia) {
        //Obtenemos el permiso de lectura en nuestra bd
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Consultamos en nuestra bd
        Cursor cursor = db.rawQuery(
                "select * from usuarios where usuario='" + usuario + "'" +
                        " and contrasenia='" + contrasenia + "'",
                null
        );
        //Preguntamos si es que hay registros en nuestra respuesta
        if (cursor.moveToFirst()) {
            //Si hay registros va a ejecutarse
            do {
                //retornamos positivo si es que trae al menos un registro
                return true;
            } while (cursor.moveToNext());
        }
        //Retornamos negativo si es que no trae ningún registro
        return false;
    }

    public int validarUsuarioId(String usuario, String contrasenia) {
        //Obtenemos el permiso de lectura en nuestra bd
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Consultamos en nuestra bd
        Cursor cursor = db.rawQuery(
                "select * from usuarios where usuario='" + usuario + "'" +
                        " and contrasenia='" + contrasenia + "'",
                null
        );
        //Preguntamos si es que hay registros en nuestra respuesta
        if (cursor.moveToFirst()) {
            //Si hay registros va a ejecutarse
            do {
                //retornamos positivo si es que trae al menos un registro
                return cursor.getInt(cursor.getColumnIndex("id"));
            } while (cursor.moveToNext());
        }
        //Retornamos negativo si es que no trae ningún registro
        return -1;
    }

    public Usuario obtenerUsuarioPorId(int id) {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from usuarios where id=" + id,
                null
        );
        if (cursor.moveToFirst()) {
            do {
                //Creamos una variable de tipo usuario
                Usuario usuario = new Usuario();
                //Setteamos los datos de nuestro objeto con los datos que se trae de nuestra bd
                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setContrasenia(cursor.getString(cursor.getColumnIndex("contrasenia")));
                usuario.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
                usuario.setNombreCompleto(cursor.getString(cursor.getColumnIndex("nombre_completo")));
                usuario.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
                return usuario;
            } while (cursor.moveToNext());
        }
        return null;
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        //Obtenemos el permiso de lectura de nuestra bd
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Consultamos todos los usuarios que se han registrado
        Cursor cursor = db.rawQuery(
                "select * from usuarios",
                null
        );
        //Creamos una lista de tipo usuario
        ArrayList<Usuario> lista = new ArrayList<>();
        //Validamos que hayan registros en la consulta
        if (cursor.moveToFirst()) {
            //Si es que hay registros, se agregaran a la lista
            do {
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setContrasenia(cursor.getString(cursor.getColumnIndex("contrasenia")));
                usuario.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
                usuario.setNombreCompleto(cursor.getString(cursor.getColumnIndex("nombre_completo")));
                usuario.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
                lista.add(usuario);
            } while (cursor.moveToNext());
        }
        //retornamos la lista de usuarios
        return lista;
    }

    public ArrayList<Usuario> consultarUsuariosPorNombre(String nombreCompleto) {
        //Obtenemos el permiso de lectura de nuestra bd
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Consultamos todos los usuarios que se han registrado
        Cursor cursor = db.rawQuery(
                "select * from usuarios where nombre_completo like '%" + nombreCompleto + "%'",
                null
        );
        //Creamos una lista de tipo usuario
        ArrayList<Usuario> lista = new ArrayList<>();
        //Validamos que hayan registros en la consulta
        if (cursor.moveToFirst()) {
            //Si es que hay registros, se agregaran a la lista
            do {
                Usuario usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setContrasenia(cursor.getString(cursor.getColumnIndex("contrasenia")));
                usuario.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
                usuario.setNombreCompleto(cursor.getString(cursor.getColumnIndex("nombre_completo")));
                usuario.setUsuario(cursor.getString(cursor.getColumnIndex("usuario")));
                lista.add(usuario);
            } while (cursor.moveToNext());
        }
        //retornamos la lista de usuarios
        return lista;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("usuario", usuario.getUsuario());
            contentValues.put("nombre_completo", usuario.getNombreCompleto());
            contentValues.put("correo", usuario.getCorreo());
            contentValues.put("contrasenia", usuario.getContrasenia());
            db.update("usuarios", contentValues, "id=" + usuario.getId(), null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarUsuarioPorId(int id) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        try {
            db.delete("usuarios", "id=" + id, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
