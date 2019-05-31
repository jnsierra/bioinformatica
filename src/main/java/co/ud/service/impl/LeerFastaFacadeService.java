package co.ud.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ud.service.ILeerFastaFacadeService;
import co.ud.service.IPersisteFastaService;
import co.ud.service.IReaderFileService;

@Service
public class LeerFastaFacadeService implements ILeerFastaFacadeService {
	
	@Autowired
	IReaderFileService readerFileService; 
	
	@Autowired
	IPersisteFastaService persisteFastaService; 

	@Override
	public Boolean leeArchivoFasta() throws IOException {
		//Leemos el archivo que corresponde
		List<String> lineas = readerFileService.getFile();
		//Persistimos en la base de datos todas las secuencias que se requiera
		return persisteFastaService.persisteFasta(lineas);
	}

}
