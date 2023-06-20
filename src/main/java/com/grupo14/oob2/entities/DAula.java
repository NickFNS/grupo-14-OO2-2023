package com.grupo14.oob2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "d_aula")
public class DAula extends Dispositivo{

    @Column(name = "open_door")
    protected boolean openDoor;

    @Column(name = "lights_on")
    protected boolean lightsOn;

    @Column(name = "computers_on")
    protected boolean computersOn;

    @Column(name = "open_windows")
    protected boolean openWindows;

    @Column(name = "in_use")
    protected boolean inUse;
}
