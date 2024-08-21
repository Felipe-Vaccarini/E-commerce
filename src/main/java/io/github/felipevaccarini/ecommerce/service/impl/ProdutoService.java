package io.github.felipevaccarini.ecommerce.service.impl;

import io.github.felipevaccarini.ecommerce.domain.entity.Produto;
import io.github.felipevaccarini.ecommerce.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends GenericServiceImpl<Produto, Long>{

    @Autowired
    public ProdutoService(ProdutoRepository repository){
        super(repository);
    }
}
