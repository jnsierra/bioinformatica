package co.ud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "linea")
@Getter @Setter
public class LineaEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "linea_generator")
	@SequenceGenerator(name = "linea_generator", sequenceName = "linea_seq", allocationSize = 1)	
	private Long id;
	@Column(name = "linea")
	private Long linea;
	@Column(name = "lineaCaract")
	private String lineaCaract;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "archivo_id", nullable = false)
	private ArchivoFastaEntity archivo;
	
//	@OneToMany(mappedBy = "linea", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<CaracterEntity> caracteres = new ArrayList<>();;
//	
//	
//	public void addCaracter(CaracterEntity caracter) {
//		caracteres.add(caracter);
//		caracter.setLinea(this);
//	}
	
	

}
