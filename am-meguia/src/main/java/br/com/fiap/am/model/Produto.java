package br.com.fiap.am.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="produto",sequenceName = "SQ_T_PRODUTO",allocationSize = 1)
public class Produto {
    @Id
    @GeneratedValue(generator = "produto",strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_produto")
    private int codigo;

    @Column(name = "ds_produto")
    @NotEmpty
    private String descricao;

    @Column(name = "vl_produto")
    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
