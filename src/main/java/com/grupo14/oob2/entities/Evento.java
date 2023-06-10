package com.grupo14.oob2.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dispositivo")
	private Dispositivo dispositivo;

}
