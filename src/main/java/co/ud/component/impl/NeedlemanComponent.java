package co.ud.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ud.component.INeedlemanComponent;
import co.ud.service.IAlineacionService;

@Component
public class NeedlemanComponent implements INeedlemanComponent{

	@Autowired
	IAlineacionService alineacionService;
	
	@Override
	public Long generarAlgoritmo(Long idPrinc, Long idSecu) {
		return alineacionService.alineacionSecuencias(idPrinc, idSecu);
	}

}
