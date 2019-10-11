package br.com.fiap.am.model;



import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="problema",sequenceName = "ST_T_PROBLEM",allocationSize = 1)
public class Problema {
    @Id
    @GeneratedValue(generator = "problema", strategy = GenerationType.SEQUENCE)
    @Column(name="cd_problem")
    private int codigo;


    @Column(name="ds_tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoProblema tipo;

    @Size(max = 255)
    @NotBlank(message = "Localização é obrigatório")
    @Column(name="ds_localizacao")
    private String localizacao;

    private LocalDate data;

    @ManyToOne
    @NotNull
    private Usuario usuario;

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

    public TipoProblema getTipo() {
        return tipo;
    }

    public void setTipo(TipoProblema tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
