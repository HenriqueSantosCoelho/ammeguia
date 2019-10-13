package br.com.fiap.meguia.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import br.com.fiap.meguia.Model.Endereco;
import br.com.fiap.meguia.R;

public class ProblemaActivity extends AppCompatActivity {

    EditText etLocalizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problema);

        etLocalizacao = (EditText)findViewById(R.id.etLocalizacao);

        getSupportActionBar().hide();
    }

    public void report(View view) {
        Toast.makeText(this, "Foi reportado o seu problema com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void pegarLocalizacao(View view) {
        etLocalizacao.setText("Av. Lins de Vasconcelos, 1222 - Aclimação, São Paulo - SP");
    }
}
