package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class vistaDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vista_datos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtRespNombre = (TextView)findViewById(R.id.txtRespNombre);
        TextView txtRespApellido = (TextView)findViewById(R.id.txtRespApellido);
        TextView txtRespEmpresa = (TextView)findViewById(R.id.txtRespEmpresa);
        TextView txtRespTelefono = (TextView)findViewById(R.id.txtRespTelefono);
        TextView txtRespEmail = (TextView)findViewById(R.id.txtRespEmail);
        TextView txtRespFechaNacimietno = (TextView)findViewById(R.id.txtRespFechaNacimiento);
        TextView txtRespGenero = (TextView)findViewById(R.id.txtRespGenero);

        Bundle b = this.getIntent().getExtras();

        txtRespNombre.append(b.getString("NOMBRE"));
        txtRespApellido.append(b.getString("APELLIDO"));
        txtRespEmpresa.append(b.getString("EMPRESA"));
        txtRespTelefono.append(b.getString("TELEFONO"));
        txtRespEmail.append(b.getString("EMAIL"));
        txtRespFechaNacimietno.append(b.getString("FECHA_NACIMIENTO"));
        txtRespGenero.append(b.getString("GENERO"));



    }
}