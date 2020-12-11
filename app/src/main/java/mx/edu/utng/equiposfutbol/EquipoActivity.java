package mx.edu.utng.equiposfutbol;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EquipoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewEquipo;

    private RecyclerViewAdaptador adaptadorEquipo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);


        recyclerViewEquipo =(RecyclerView)findViewById(R.id.recyclerEquipo);
        recyclerViewEquipo.setLayoutManager(new LinearLayoutManager(this));
        BD bd= new BD(getApplicationContext());


        adaptadorEquipo= new RecyclerViewAdaptador(bd.mostrarEquipos());
        recyclerViewEquipo.setAdapter(adaptadorEquipo);
    }

}