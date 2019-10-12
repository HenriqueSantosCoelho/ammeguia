package br.com.fiap.am.repository;

import br.com.fiap.am.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
    @Query("SELECT SUM(m.total) FROM Pedido m")
    double sumTotal();
}
