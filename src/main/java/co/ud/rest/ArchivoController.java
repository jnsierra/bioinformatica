package co.ud.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ud.dto.ArchivoFastaDto;

@RestController
@RequestMapping("/v.1/archivo")
public class ArchivoController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ArchivoFastaDto>> getAll(){
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
