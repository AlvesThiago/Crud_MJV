package com.mjv.crud.service;

import com.mjv.crud.dto.CrudDTO;
import com.mjv.crud.mapper.CrudMapper;
import com.mjv.crud.model.Crud;
import com.mjv.crud.repository.CrudRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    private CrudRepository crudRepository;
    private CrudMapper crudMapper;

    public CrudService(CrudRepository crudRepository, CrudMapper crudMapper) {
        this.crudRepository = crudRepository;
        this.crudMapper = crudMapper;
    }

    public List<CrudDTO> create(CrudDTO crudDTO) {
        Crud crudEntity = crudMapper.toEntity(crudDTO); // Convertendo DTO para entidade
        crudRepository.save(crudEntity);
        return list();
    }

    public List<CrudDTO> list() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        List<Crud> cruds = crudRepository.findAll(sort);
        return crudMapper.toListDTO(cruds); // Convertendo lista de entidades para lista de DTOs
    }

    public List<CrudDTO> update(CrudDTO crudDTO) {
        Crud crudEntity = crudMapper.toEntity(crudDTO); // Convertendo DTO para entidade
        crudRepository.save(crudEntity);
        return list();
    }

    public List<CrudDTO> delete(Long id) {
        crudRepository.deleteById(id);
        return list();
    }
}

