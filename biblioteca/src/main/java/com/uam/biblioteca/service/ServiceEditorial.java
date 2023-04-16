package com.uam.biblioteca.service;

import com.uam.biblioteca.model.Editorial;
import com.uam.biblioteca.model.Libro;
import com.uam.biblioteca.repository.IRepositoryEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component("ServiceEditorial")
public class ServiceEditorial implements IServiceEditorial {

    @Autowired
    private IRepositoryEditorial repo;
    @Override
    public List<Editorial> getAll() {
        return repo.findAll();
    }

    @Override
    public Editorial save(Editorial editorial) {
        List<Libro> detalles = editorial.getDetalles();
        Editorial maestro = new Editorial();
        maestro.setDescription(editorial.getDescription());
        maestro.setName(editorial.getName());
        for (Libro libro: detalles) {
            libro.setEditorial(maestro);
        }
        maestro.setDetalles(detalles);
        return repo.save(maestro);
    }
}
