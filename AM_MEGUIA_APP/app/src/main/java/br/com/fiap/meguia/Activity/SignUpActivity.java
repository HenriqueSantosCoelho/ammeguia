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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import br.com.fiap.meguia.Model.Voluntario;
import br.com.fiap.meguia.R;
import br.com.fiap.meguia.config.ConfiguracaoFirebase;

public class SignUpActivity extends AppCompatActivity {

    private EditText campoEmail, campoNome, campoSenha, campoTelefone;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        campoEmail = findViewById(R.id.mail);
        campoNome = findViewById(R.id.usrusr);
        campoSenha = findViewById(R.id.pswrdd);
        campoTelefone = findViewById(R.id.mobphone);

        getSupportActionBar().hide();
    }

    public void validarCadastroVoluntario(View view) {
        String textoEmail = campoEmail.getText().toString();
        String textoNome = campoNome.getText().toString();
        String textoSenha = campoSenha.getText().toString();
        String textoTelefone = campoTelefone.getText().toString();

        if(!textoEmail.isEmpty()){
            if(!textoNome.isEmpty()){
                if(!textoSenha.isEmpty()){
                    if(!textoTelefone.isEmpty()){
                        Voluntario voluntario = new Voluntario();
                        voluntario.setEmail(textoEmail);
                        voluntario.setSenha(textoSenha);
                        voluntario.setNome(textoNome);
                        voluntario.setTelefone(textoTelefone);

                        cadastrarVoluntario(voluntario);
                    }else{
                        Toast.makeText(this, "Preencha um número de Telefone!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Preencha uma Senha!", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Preencha um Nome!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Preencha um Email!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastrarVoluntario(final Voluntario voluntario){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                voluntario.getEmail(),
                voluntario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    try{
                        String idVoluntario = task.getResult().getUser().getUid();
                        voluntario.setId( idVoluntario );
                        voluntario.salvar();
                        startActivity(new Intent(SignUpActivity.this, AppActivity.class));
                        finish();
                        Toast.makeText(SignUpActivity.this, "Cadastro feito com sucesso!", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    String excecao = "";
                    try {
                        throw task.getException();
                    }catch ( FirebaseAuthWeakPasswordException e){
                        excecao = "Digite uma senha mais forte!";
                    }catch ( FirebaseAuthInvalidCredentialsException e){
                        excecao= "Por favor, digite um e-mail válido";
                    }catch ( FirebaseAuthUserCollisionException e){
                        excecao = "Este conta já foi cadastrada";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário: "  + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(SignUpActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goLogin(View view) {
        Intent it = new Intent(this, LoginActivity.class);
        startActivity (it);
    }
}
