package co.ud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ud.entity.ArchivoFastaEntity;
import co.ud.entity.LineaEntity;
import co.ud.repository.IArchivoFastaRepository;
import co.ud.service.IPersisteFastaService;

@Service
public class PersisteFastaService implements IPersisteFastaService {

	@Autowired
	IArchivoFastaRepository archivoFastaRepository;

	@Override
	public Boolean persisteFasta(List<String> lineas) {
		Integer numSec = numeroSec(lineas);
		for (int i = 0; i < numSec; i++) {
			String nameSec = getNameSecuence(lineas, i);
			List<String> lineasSec = findSecuence(lineas, i);
			ArchivoFastaEntity archivo = new ArchivoFastaEntity();
			archivo.setNombre(nameSec);
			for (Long j = Long.valueOf("0"); j < lineasSec.size(); j++) {
				LineaEntity linea = new LineaEntity();
				linea.setLinea(j);
				linea.setLineaCaract(lineasSec.get(j.intValue()));
				archivo.addLinea(linea);
			}
			archivo = archivoFastaRepository.save(archivo);
		}
		return Boolean.TRUE;
	}



	/**
	 * Metodo con el cual busco una secuencia
	 * 
	 * @return
	 */
	private List<String> findSecuence(List<String> lineas, Integer sec) {
		List<String> secuencia = new ArrayList<String>();
		int limiteInferior = buscarLimiteInferior(lineas, sec);
		for (int i = limiteInferior + 1; i < buscarLimiteSuperior(lineas, sec); i++) {
			secuencia.add(lineas.get(i));
		}
		return secuencia;
	}

	/**
	 * Metodo con el cual busco el numero de secuencias que se encuentra en la lista
	 * de lineas del archivo
	 * 
	 * @return
	 */
	private Integer numeroSec(List<String> lineas) {
		Integer i = Integer.valueOf("0");
		for (String linea : lineas) {
			if (linea.contains(">")) {
				i++;
			}
		}
		return i;
	}

	/**
	 * Metodo con el cual obtengo la secuencia
	 * 
	 * @param sec
	 * @return
	 */
	private String getNameSecuence(List<String> lineas, Integer sec) {

		Integer i = Integer.valueOf("0");

		for (String linea : lineas) {

			if (linea.contains(">")) {
				if (i.equals(sec)) {
					return linea;
				}
				i++;
			}

		}
		return "";
	}

	private Integer buscarLimiteSuperior(List<String> lineas, Integer sec) {
		Integer i = Integer.valueOf("0");
		Integer conteoLineas = Integer.valueOf("0");
		sec++;
		for (String linea : lineas) {

			if (linea.contains(">")) {
				if (i.equals(sec)) {
					return conteoLineas;
				}
				i++;
			}
			conteoLineas++;

		}
		return lineas.size();
	}

	private Integer buscarLimiteInferior(List<String> lineas, Integer sec) {
		Integer i = Integer.valueOf("0");
		Integer conteoLineas = Integer.valueOf("0");
		for (String linea : lineas) {

			if (linea.contains(">")) {
				if (i.equals(sec)) {
					return conteoLineas++;
				}
				i++;
			}
			conteoLineas++;

		}
		return i;
	}

}
