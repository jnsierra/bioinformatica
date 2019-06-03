package co.ud.rest;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ud.dto.ArchivoFastaDto;
import co.ud.entity.ArchivoFastaEntity;
import co.ud.service.IArchivoFastaService;

@RestController
@RequestMapping("/v.1/archivo")
public class ArchivoController {
	
	@Autowired
	@Qualifier("mapperArchivoSimple")
	ModelMapper mapper;
	
	@Autowired
	ModelMapper mapperUno;
	
	@Autowired
	IArchivoFastaService archivoFastaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArchivoFastaDto[]> getAll(){
		return new ResponseEntity<ArchivoFastaDto[]>(mapper.map(archivoFastaService.getAll(), ArchivoFastaDto[].class),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArchivoFastaDto> getById(@PathVariable(value = "id", required = true) Long id){
		Optional<ArchivoFastaEntity> archivo = archivoFastaService.getById(id);
		if(!archivo.isPresent()) {
			return new ResponseEntity<ArchivoFastaDto>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ArchivoFastaDto>(mapperUno.map(archivo.get(), ArchivoFastaDto.class),HttpStatus.OK);
	}
	

}
