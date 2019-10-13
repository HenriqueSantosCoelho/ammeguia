package br.com.fiap.meguia.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.fiap.meguia.R;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        getSupportActionBar().hide();
    }


}
