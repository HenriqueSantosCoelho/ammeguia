package br.com.fiap.am.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@SequenceGenerator(name="sug",sequenceName = "T_SQ_SUGGERTION", allocationSize = 1)
public class Sugestao {
    @Id
    @GeneratedValue(generator = "sug", strategy = GenerationType.SEQUENCE)
    @Column(name="cd_suggestion")
    private int codigo;
    @Size(max = 255)
    @NotBlank(message = "Nome obrigatório")
    @Column(name="nm_user")
    private String nome;
    @Email(message = "E-mail inválido")
    @NotBlank(message = "Email obrigatório")
    @Column(name = "ds_email")
    private String email;
    @Size(max = 255)
    @Column(name = "ds_subject")
    private String assunto;
    @Size(max = 600)
    @Column(name = "ds_content")
    private String conteudo;

    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
