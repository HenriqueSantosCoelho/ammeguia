package br.com.fiap.am.repository;

import br.com.fiap.am.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
    @Query("SELECT SUM(m.total) FROM Pedido m")
    double sumTotal();
    @Query("SELECT SUM(m.total) FROM Pedido m WHERE m.data BETWEEN ?1 AND ?2")
    double sumByDataBetween(LocalDate start, LocalDate end);

    List<Pedido> findByDataBetween(LocalDate start, LocalDate end);

    List<Pedido> findByUsuario_Email(String email);
}
