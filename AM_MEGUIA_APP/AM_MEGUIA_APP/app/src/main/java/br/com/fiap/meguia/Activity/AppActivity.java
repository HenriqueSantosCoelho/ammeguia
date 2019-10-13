package br.com.fiap.meguia.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.fiap.meguia.R;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        getSupportActionBar().hide();
    }

    public void goProblema(View view) {
        Intent it = new Intent(this, ProblemaActivity.class);
        startActivity(it);
    }

    public void goPerfil(View view) {
        Intent it = new Intent(this, PerfilActivity.class);
        startActivity(it);
    }

    public void goWalk (View view) {
        Intent it = new Intent(this, GuiaActivity.class);
        startActivity(it);
    }
}
