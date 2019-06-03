package co.ud.service;

import java.util.List;
import java.util.Optional;

import co.ud.entity.SecuenciacionEntity;

public interface ISecuenciacionService {
	/**
	 * Metodo con el cual obtengo todas las secuencias generadas en el sistema
	 * @return
	 */
	List<SecuenciacionEntity> getAll();
	/**
	 * Metodo con el cual envio la secuencia por id
	 * @return
	 */
	Optional<SecuenciacionEntity> getById(Long id);

}
