package co.ud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class SecuenciacionEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secu_generator")
	@SequenceGenerator(name = "secu_generator", sequenceName = "secu_seq", allocationSize = 1)
	private Long id;
	@Column(name = "secuenciaPrinc")
	private String secuenciaPrinc;
	@Column(name = "secuenciaSec")
	private String secuenciaSec;
	
	@Column(name = "jsonMatriz", length= 10485760)
	private String jsonMatriz;
	

}
