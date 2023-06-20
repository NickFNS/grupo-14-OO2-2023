package com.grupo14.oob2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DispositivoCreate {
    private String name;
    private boolean enabled;
    private String type;
    private int idSector;
}
