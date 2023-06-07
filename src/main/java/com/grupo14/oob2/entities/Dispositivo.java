package com.grupo14.oob2.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
@Table(name = "dispositivo")
public abstract class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idDispositivo;

	@Column(name = "name", nullable = false)
	protected String name;

	@Column(name = "enabled")
	protected boolean enabled;

	@Column(name = "type", nullable = false)
	protected String type;

	@Column(name = "created_at")
	@CreationTimestamp
	protected LocalDateTime creadoEn;

	@Column(name = "updated_at")
	@UpdateTimestamp
	protected LocalDateTime actualizadoEn;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dispositivo")
//	protected Set<Evento> eventos = new HashSet<Evento>()

}
