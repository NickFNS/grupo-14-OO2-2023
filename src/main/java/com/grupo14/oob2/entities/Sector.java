package com.grupo14.oob2.entities;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "sector")
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSector;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime created_at;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private LocalDateTime updated_at;

	// Collection 'com.grupo14.oob2.entities.Sector.dispositivos' is 'mappedBy' a
	// property named 'sector' which does not exist in the target entity
	// 'com.grupo14.oob2.entities.Dispositivo' -> saque [mappedBy = "sector"]
	//@OneToMany(fetch = FetchType.LAZY)
	//private Set<Dispositivo> dispositivos = new HashSet<Dispositivo>();


}
