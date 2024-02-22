package com.mjv.crud.mapper;

import com.mjv.crud.dto.CrudDTO;
import com.mjv.crud.model.Crud;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CrudMapper {
    private final ModelMapper mapper;

    public CrudMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }
    public Crud toEntity(CrudDTO crudDTO){
        return mapper.map(crudDTO, Crud.class);
    }
    public CrudDTO toDTO(Crud crud){
        return mapper.map(crud, CrudDTO.class);
    }
    public List<CrudDTO> toListDTO(List<Crud> cruds){
        return cruds.stream().map((element) -> mapper.map(element, CrudDTO.class)).collect(Collectors.toList());
    }
}
