package com.example.vuelovmovil.sqlite.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.vuelovmovil.sqlite.DataBaseHelper;
import com.example.vuelovmovil.sqlite.contracts.UsuarioContract;
import com.example.vuelovmovil.sqlite.models.Usuario;

public class UsuarioDaoImpl implements IEntityDao<Usuario, Long> {

    private final SQLiteDatabase db;

    public UsuarioDaoImpl(Context context) {
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public boolean save(Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put(UsuarioContract._ID, usuario.getId());
        values.put(UsuarioContract.COLUMN_NAME_USERNAME, usuario.getUsername());
        values.put(UsuarioContract.COLUMN_NAME_PASSWORD, usuario.getPassword());

        long newRowId = db.insert(UsuarioContract.TABLE_NAME, null, values);

        return newRowId != -1;
    }

    public Usuario getUser() {
        String[] projection = {
                BaseColumns._ID,
                UsuarioContract.COLUMN_NAME_USERNAME,
                UsuarioContract.COLUMN_NAME_PASSWORD
        };
        Cursor cursor = db.query(
                UsuarioContract.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        long id = 0L;
        String username = null,
                password = null;
        if (cursor.moveToFirst()) {
            id = cursor.getLong(
                    cursor.getColumnIndexOrThrow(UsuarioContract._ID));
            username = cursor.getString(
                    cursor.getColumnIndexOrThrow(UsuarioContract.COLUMN_NAME_USERNAME));
            password = cursor.getString(
                    cursor.getColumnIndexOrThrow(UsuarioContract.COLUMN_NAME_PASSWORD));
        } else {
            cursor.close();
            return null;
        }

        cursor.close();
        return new Usuario(id, username, password);
    }

    @Override
    public Usuario getById(Long id) {
        String[] projection = {
                BaseColumns._ID,
                UsuarioContract.COLUMN_NAME_USERNAME,
                UsuarioContract.COLUMN_NAME_PASSWORD
        };

        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query(
                UsuarioContract.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        String username = null,
                password = null;
        if (cursor.moveToFirst()) {
            username = cursor.getString(
                    cursor.getColumnIndexOrThrow(UsuarioContract.COLUMN_NAME_USERNAME));
            password = cursor.getString(
                    cursor.getColumnIndexOrThrow(UsuarioContract.COLUMN_NAME_PASSWORD));
        } else {
            cursor.close();
            return null;
        }

        cursor.close();
        return new Usuario(id, username, password);
    }

    @Override
    public boolean update(Usuario usuario) {
        return false; // TODO: implement this!
    }

    @Override
    public boolean delete(Usuario usuario) {
        String selection = UsuarioContract._ID + " = ?";
        String[] selectionArgs = {usuario.getId().toString()};
        int deletedRows = db.delete(UsuarioContract.TABLE_NAME, selection, selectionArgs);
        return deletedRows > 0;
    }

    public boolean deleteAll() {
        int deletedRows = db.delete(UsuarioContract.TABLE_NAME, null, null);
        return deletedRows > 0;
    }
}
