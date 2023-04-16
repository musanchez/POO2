package com.uam.biblioteca.service;

import com.uam.biblioteca.model.Libro;
import com.uam.biblioteca.repository.IRepositoryLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component("ServiceLibro")
public class ServiceLibro implements IServiceLibro{

    @Autowired
    private IRepositoryLibro repo;
    @Override
    public List<Libro> getAll() {
        return repo.findAll();
    }
    @Override
    public Libro save(Libro libro) {
        return repo.save(libro);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
