package com.uam.biblioteca.service;

import com.uam.biblioteca.model.Editorial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceEditorial {

    public List<Editorial> getAll();

    public Editorial save(Editorial editorial);

}
