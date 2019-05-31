package co.ud.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "archivo")
@Getter @Setter
public class ArchivoFastaEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "archivo_generator")
	@SequenceGenerator(name = "archivo_generator", sequenceName = "archivo_seq", allocationSize = 1)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "archivo",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LineaEntity> lineas = new ArrayList<>();
	
	public void addLinea(LineaEntity linea) {
		linea.setArchivo(this);
		lineas.add(linea);
	}
}
