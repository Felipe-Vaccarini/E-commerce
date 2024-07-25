package io.github.felipevaccarini.ecommerce.service.impl;

import io.github.felipevaccarini.ecommerce.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    public GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id){
        return repository.findById(id);
    }

    @Override
    public List<T> findAll(){
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id){
        repository.deleteById(id);
    }


}
