package co.ud.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArchivoFastaDto {
	
	private Long id;
	private String nombre;	
	private List<LineaDto> lineas;
	
	
}
