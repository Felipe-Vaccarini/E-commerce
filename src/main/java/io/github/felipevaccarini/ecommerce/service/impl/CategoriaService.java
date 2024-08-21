package io.github.felipevaccarini.ecommerce.service.impl;

import io.github.felipevaccarini.ecommerce.domain.entity.Categoria;
import io.github.felipevaccarini.ecommerce.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends GenericServiceImpl<Categoria, Long> {

    @Autowired
    public CategoriaService(CategoriaRepository repository){
        super(repository);
    }
}
