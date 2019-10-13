package br.com.fiap.meguia.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import br.com.fiap.meguia.Helper.UsuarioFirebase;
import br.com.fiap.meguia.Model.Voluntario;
import br.com.fiap.meguia.R;
import br.com.fiap.meguia.config.ConfiguracaoFirebase;

public class LoginActivity extends AppCompatActivity {

    private EditText campoEmail, campoSenha;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.edtUser);
        campoSenha = findViewById(R.id.edtPsw);

        getSupportActionBar().hide();
    }

    public void validarLoginUsuario(View view){
        String textoEmail = campoEmail.getText().toString();
        String textoSenha = campoEmail.getText().toString();

        if(!textoEmail.isEmpty()){
            if(!textoSenha.isEmpty()){
                Voluntario voluntario = new Voluntario();
                voluntario.setEmail(textoEmail);
                voluntario.setSenha(textoSenha);

                logarVoluntario(voluntario);
            }else{
                Toast.makeText(this, "Preencha a senha", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Preencha um email", Toast.LENGTH_SHORT).show();
        }
    }

    public void logarVoluntario(Voluntario voluntario){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                voluntario.getEmail(), voluntario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    UsuarioFirebase.redirecionaUsuarioLogado(LoginActivity.this);
                }else{
                    String excecao = "";
                    try {
                        throw task.getException();
                    }catch ( FirebaseAuthInvalidUserException e ) {
                        excecao = "Voluntário não está cadastrado.";
                    }catch ( FirebaseAuthInvalidCredentialsException e ){
                        excecao = "E-mail e senha não correspondem a um voluntário cadastrado";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar voluntário: "  + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goSignUp(View view) {
        Intent it = new Intent(this, SignUpActivity.class);
        startActivity (it);
    }
}
