package br.com.fiap.am.repository;

import br.com.fiap.am.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
