package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ToggleButton;

import com.google.android.material.button.MaterialButtonToggleGroup;


public class registroLauncher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btEnviar(View view){
        //obtener nombre
        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        EditText txtApellido = (EditText)findViewById(R.id.txtApellido);
        EditText txtEmpresa = (EditText)findViewById(R.id.txtEmpresa);
        EditText txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        EditText txtFechaNacimiento = (EditText)findViewById(R.id.txtFechaNacimiento);
        //guardar nombre
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();
        String empresa = txtEmpresa.getText().toString();
        String telefono= txtTelefono.getText().toString();
        String email = txtEmail.getText().toString();
        String fechanacimiento = txtFechaNacimiento.getText().toString();
        String genero = "";

        MaterialButtonToggleGroup toggleButton = (MaterialButtonToggleGroup) findViewById(R.id.toggleButton);
        int selectedButton = toggleButton.getCheckedButtonId();
        if (selectedButton == 1) { genero = "Hombre"; };
        if (selectedButton == 2) { genero = "Mujer"; };


        Intent intent = new Intent(registroLauncher.this,vistaDatos.class);
        Bundle b = new Bundle();

        b.putString("NOMBRE",nombre);
        b.putString("APELLIDO",apellido);
        b.putString("EMPRESA",empresa);
        b.putString("TELEFONO",telefono);
        b.putString("EMAIL",email);
        b.putString("FECHA_NACIMIENTO",fechanacimiento);
        b.putString("GENERO",genero);

        intent.putExtras(b);

        startActivity(intent);
    }
}