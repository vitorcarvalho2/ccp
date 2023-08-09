package br.edu.ufj.CCP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufj.CCP.models.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Integer>{

}
