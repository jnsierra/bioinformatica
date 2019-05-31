package co.ud.service;

import java.util.List;

public interface IPersisteFastaService {
	/**
	 * Metodo con el cual persisto las lineas y le doy un formato fasta
	 * @param lineas
	 * @return
	 */
	Boolean persisteFasta(List<String> lineas);

}
