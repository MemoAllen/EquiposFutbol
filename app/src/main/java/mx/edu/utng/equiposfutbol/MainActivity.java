package mx.edu.utng.equiposfutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtCodigo, edtEquipo, edtLiga;
    Button btnAgregar, btnMostrar, btnBuscar, btnEditar, btnEliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtCodigo = (EditText) findViewById(R.id.edtCodigo);
        edtEquipo = (EditText) findViewById(R.id.edtEquipo);
        edtLiga = (EditText) findViewById(R.id.edtLiga);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);


        final BD bd = new BD(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.agregarEquipos(edtCodigo.getText().toString(), edtEquipo.getText().toString(), edtLiga.getText().toString());

                Toast.makeText(getApplicationContext(), "Se agrego correctamente", Toast.LENGTH_SHORT).show();
            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarEquipos = new Intent(getApplicationContext(), EquipoActivity.class);
                startActivity(mostrarEquipos);
            }
        });
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EquiposModelo equipos = new EquiposModelo();
                bd.buscarEquipos(equipos, edtCodigo.getText().toString());
                edtEquipo.setText(equipos.getEquipo());
                edtLiga.setText(equipos.getLiga());
            }
        });
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.editarEquipos(edtCodigo.getText().toString(), edtEquipo.getText().toString(), edtLiga.getText().toString());
                Toast.makeText(getApplicationContext(), "Se modificaron", Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.eliminarEquipos(edtCodigo.getText().toString());
                Toast.makeText(getApplicationContext(), "Se eliminaron", Toast.LENGTH_SHORT).show();
            }
        });


    }
}