package com.mjv.crud.controller;

import com.mjv.crud.dto.CrudDTO;
import com.mjv.crud.service.CrudService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cruds")
public class CrudController {

    private final CrudService crudService;

    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @PostMapping
    public List<CrudDTO> create(@RequestBody @Valid CrudDTO crudDTO){
        return crudService.create(crudDTO);
    }

    @GetMapping
    public List<CrudDTO> list(){
        return crudService.list();
    }

    @PutMapping
    public List<CrudDTO> update(@RequestBody @Valid CrudDTO crudDTO){
        return crudService.update(crudDTO);
    }

    @DeleteMapping("{id}")
    public List<CrudDTO> delete(@PathVariable("id") Long id){
        return crudService.delete(id);
    }
}

