package com.mjv.crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrudDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
    private boolean done;
    private int priority;

    public CrudDTO(String name, String description, boolean done, int priority) {
        this.name = name;
        this.description = description;
        this.done = done;
        this.priority = priority;
    }
}
