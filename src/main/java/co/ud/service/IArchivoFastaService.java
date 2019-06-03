package co.ud.service;

import java.util.List;
import java.util.Optional;

import co.ud.entity.ArchivoFastaEntity;


public interface IArchivoFastaService {
	/**
	 * Metodo con el cual obtengo todos los archivos en el sistema
	 * @return
	 */
	List<ArchivoFastaEntity> getAll();
	/**
	 * Metodo con el cual obtengo un archivo por id
	 * @param id
	 * @return
	 */
	Optional<ArchivoFastaEntity> getById(Long id);
}
