package br.com.fiap.am.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Entity
@SequenceGenerator(name="usuario",sequenceName = "ST_T_USER",allocationSize = 1)
public class Usuario {
    @Id
    @GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
    @Column(name="cd_user")
    private int codigo;

    @Size(max = 255)
    @NotBlank(message = "Nome obrigatório")
    @Column(name="nm_user")
    private String nome;

    @Size(max = 12)
    @NotBlank(message = "Senha obrigatória")
    @Column(name = "psw_user")
    private String senha;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "Email obrigatório")
    @Column(name = "ds_email")
    private String email;

    @Column(name="is_deficiente")
    private boolean deficiente;

    public boolean isDeficiente() {
        return deficiente;
    }

    public void setDeficiente(boolean deficiente) {
        this.deficiente = deficiente;
    }

    @Column(name = "ds_endereco")
    private String endereco;

    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Column(name="ds_cep")
    private String cep;
    @CPF
    @Column(name = "ds_cpf")
    private String cpf;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
