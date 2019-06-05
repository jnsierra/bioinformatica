package co.ud.rest;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ud.dto.secuencia.SecuenciacionDto;
import co.ud.entity.SecuenciacionEntity;
import co.ud.service.ISecuenciacionService;

@RestController
@RequestMapping(value = "/v.1/secuenciacion")
@CrossOrigin( origins = "*")
public class SecuenciacionController {
	
	@Autowired
	ISecuenciacionService secuenciacionService; 
	
	@Autowired
	ModelMapper mapper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SecuenciacionDto[]> getAll(){
		SecuenciacionDto[] secuencias = mapper.map(secuenciacionService.getAll(), SecuenciacionDto[].class);
		return new ResponseEntity<>(secuencias, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SecuenciacionDto> getById(@PathVariable("id")Long id){
		Optional<SecuenciacionEntity> secuenciacion = secuenciacionService.getById(id);
		if(!secuenciacion.isPresent()) {
			return new ResponseEntity<SecuenciacionDto>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(mapper.map(secuenciacion.get(), SecuenciacionDto.class), HttpStatus.OK); 
	}

}
