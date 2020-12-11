package mx.edu.utng.equiposfutbol;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class BD extends SQLiteOpenHelper {


    private static final String NOMBRE_BD = "bdequipo";
    private static final int VERSION_BD=1;
    private static final String TABLA_EQUIPOS="CREATE TABLE EQUIPOS(CODIGO VARCHAR PRIMARY KEY, EQUIPO VARCHAR,LIGA VARCHAR )";

    public BD(Context context) {
        super(context,NOMBRE_BD,null,VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_EQUIPOS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i, int i1) {
        sqLiteDatabase.execSQL(" CREATE TABLE EQUIPOS(CODIGO VARCHAR PRIMARY KEY, EQUIPO VARCHAR,LIGA VARCHAR )");
        sqLiteDatabase.execSQL(TABLA_EQUIPOS);
    }
    public void agregarEquipos(String codigo, String equipo, String liga){
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!= null){
            bd.execSQL("INSERT INTO EQUIPOS VALUES('"+codigo+"','"+equipo+"','"+liga+"')");
            bd.close();
        }
    }


    public List<EquiposModelo>mostrarEquipos(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT *FROM EQUIPOS", null);
        List<EquiposModelo>equipo = new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                equipo.add(new EquiposModelo(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        return equipo;
    }


    public void buscarEquipos(EquiposModelo equipo, String codigo){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM EQUIPOS WHERE CODIGO='"+codigo+"'",null);
        if (cursor.moveToFirst()){
            do{
                equipo.setEquipo(cursor.getString(1));
                equipo.setLiga(cursor.getString(2));

            }while(cursor.moveToNext());
        }

    }

    public void editarEquipos(String codigo, String equipo, String liga){
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!= null){
            bd.execSQL("UPDATE EQUIPOS SET EQUIPO='"+equipo+"',LIGA='"+liga+"'WHERE CODIGO='"+codigo+"'");
            bd.close();
        }
    }

    public void eliminarEquipos(String codigo){
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!= null){
            bd.execSQL("DELETE FROM EQUIPOS WHERE CODIGO='"+codigo+"'");
            bd.close();
        }
    }
}
