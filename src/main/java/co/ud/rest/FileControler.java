package co.ud.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.ud.component.INeedlemanComponent;
import co.ud.service.ILeerFastaFacadeService;

@RestController
@RequestMapping(value = "/v.1/file")
@CrossOrigin( origins = "*")
public class FileControler {
	
	@Autowired
	ILeerFastaFacadeService leerFastaFacadeService;
	@Autowired
	INeedlemanComponent needlemanComponent;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> upload() throws IOException{
		return new ResponseEntity<>(leerFastaFacadeService.leeArchivoFasta().toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/algorithm/{secPri}/{secSec}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> generateAlgorithm(@PathVariable(required = true, value = "secPri")Long secPrinc,@PathVariable(required = true, value = "secSec")Long secSec ){
		return new ResponseEntity<>(needlemanComponent.generarAlgoritmo(secPrinc, secSec), HttpStatus.OK);
	}
	
}