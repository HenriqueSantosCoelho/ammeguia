package br.com.fiap.am.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="pedido",sequenceName = "SQ_T_PEDIDO",allocationSize = 1)
public class Pedido {
    @Id
    @Column(name = "cd_pedido")
    @GeneratedValue(generator = "pedido",strategy = GenerationType.SEQUENCE)
    private int codigo;

    @ManyToOne
    @NotNull
    private Usuario usuario;

    @ManyToOne
    @NotNull
    private Produto produto;

    private LocalDate data;

    @DecimalMax("30")
    @DecimalMin("1")
    @NotNull
    @Column(name="qtd")
    private int quantidade;

    @Column(name="vl_total")
    @NotNull
    private double total;

    @Column(name="vl_frete")
    private double frete;

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = getFrete()+(getQuantidade()*getProduto().getValor());
    }
}
