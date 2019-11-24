package edu.dam.pgl.examenreview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MultimediaSQLiteOpenHelper extends SQLiteOpenHelper {
    String sqlCreateTable = "CREATE TABLE audios (_id INTEGER PRIMARY KEY, titulo TEXT, compositor TEXT, recurso TEXT)";
    String sqlInsert1     = "INSERT INTO audios VALUES (NULL, 'Marcha turca', 'Mozart', 'marcha_turca')";
    String sqlInsert2     = "INSERT INTO audios VALUES (NULL, 'Serenata nº 13', 'Mozart', 'serenata_13')";
    String sqlInsert3     = "INSERT INTO audios VALUES (NULL, 'Marcha turca', 'Mozart', 'marcha_turca')";
    String sqlInsert4     = "INSERT INTO audios VALUES (NULL, 'Serenata nº 13', 'Mozart', 'serenata_13')";
    String sqlDropTable   = "DROP TABLE audios";

    public MultimediaSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateTable);
        db.execSQL(sqlInsert1);
        db.execSQL(sqlInsert2);
        db.execSQL(sqlInsert3);
        db.execSQL(sqlInsert4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlDropTable);
        db.execSQL(sqlCreateTable);
        db.execSQL(sqlInsert1);
        db.execSQL(sqlInsert2);
        db.execSQL(sqlInsert3);
        db.execSQL(sqlInsert4);
    }
}
