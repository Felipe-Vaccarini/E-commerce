package io.github.felipevaccarini.ecommerce.service.impl;

import io.github.felipevaccarini.ecommerce.domain.entity.Usuario;
import io.github.felipevaccarini.ecommerce.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericServiceImpl<Usuario, Long>{

    @Autowired
    public UsuarioService(UsuarioRepository repository){
        super(repository);
    }
}
