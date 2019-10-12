package br.com.fiap.am.repository;

import br.com.fiap.am.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto,Integer> {
    Produto findByCodigo(int codigo);
}
