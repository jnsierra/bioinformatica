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
	/**
	 * Metodo con el cual elimino un archivo por medio de su id
	 * @param id
	 * @return
	 */
	Boolean deleteById(Long id);
	
	/**
	 * Metodo con el cual inserto un archivo secuencia
	 * @param archivo
	 * @return
	 */
	ArchivoFastaEntity insertFile(ArchivoFastaEntity archivo);
}
