package com.mjv.crud.repository;

import com.mjv.crud.model.Crud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Crud, Long> {
}
