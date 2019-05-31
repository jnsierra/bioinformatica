//package co.ud.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name = "caracter")
//@Getter @Setter
//public class CaracterEntity {
//	
//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracter_generator")
//	@SequenceGenerator(name = "caracter_generator", sequenceName = "caracter_seq", allocationSize = 1)
//	private Long id;
//	@Column(name = "letra")
//	private String letra;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "linea_id", nullable = false)
//	private LineaEntity linea;
//	
//	public static CaracterEntity of(String car) {
//		CaracterEntity carac = new CaracterEntity();
//		carac.setLetra(car);
//		return carac;
//	}
//	
//	
//
//}
