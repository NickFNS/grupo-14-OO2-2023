package com.grupo14.oob2.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "dateTime")
	private LocalDateTime dateTime;


	//  Un evento puede tener mas de un dispositivo?
//	@OneToMany o @OneToOne?
//  @JoinColumn(name = "dispositivo_id", nullable = false)	
	// private Dispositivo dispositivo;


}
