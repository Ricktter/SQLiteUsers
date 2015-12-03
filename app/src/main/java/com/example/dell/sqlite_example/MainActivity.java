package com.example.dell.sqlite_example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerSQLite helper = new HandlerSQLite(this);
        TextView miTexto = (TextView) findViewById(R.id.mitexto1);
        helper.abrir();
        helper.insertarReg("usuario3", "pass3");
        helper.cerrar();
        miTexto.setText(helper.leer());


    }


}
