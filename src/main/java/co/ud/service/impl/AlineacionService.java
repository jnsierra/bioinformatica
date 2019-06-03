package co.ud.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ud.component.IMatrizResultante;
import co.ud.dto.secuencia.CeldaMatrizDto;
import co.ud.entity.ArchivoFastaEntity;
import co.ud.enumeracion.TIPO_SECUENCIA;
import co.ud.repository.IArchivoFastaRepository;
import co.ud.service.IAlineacionService;
import lombok.Getter;
import lombok.Setter;

@Service
public class AlineacionService implements IAlineacionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReaderFileService.class);

	@Autowired
	IArchivoFastaRepository archivoFastaRepository;
	@Getter
	@Setter
	private ArchivoFastaEntity secuenciaPrincipal;
	@Getter
	@Setter
	private ArchivoFastaEntity secuenciaSecundaria;
	@Autowired
	IMatrizResultante matrizResultante;

	@Override
	public Long alineacionSecuencias(Long idSecUno, Long idSecDos) {
		asignaSecuencias(idSecUno, idSecDos);
		matrizResultante.setSecuencia(TIPO_SECUENCIA.PRIMARIA, concatenaLineas(getSecuenciaPrincipal()));
		matrizResultante.setSecuencia(TIPO_SECUENCIA.SECUNDARIA, concatenaLineas(getSecuenciaSecundaria()));
		matrizResultante.generaMatrizResultante();
		matrizResultante.generaListaCaracteres();
		generarMatrizResultante();
		matrizResultante.imprimirMatriz();
		return matrizResultante.persisteSecuenciacion();
	}

	/**
	 * Metodo con el cual concateno las lineas de la secuencias
	 * 
	 * @param archivo
	 * @return
	 */
	public String concatenaLineas(ArchivoFastaEntity archivo) {
		return archivo.getLineas().stream().parallel().map(item -> item.getLineaCaract()).reduce((x, y) -> x.concat(y))
				.orElse("");
	}

	/**
	 * Metodo con el cual se asignan las secuencias que corresponden a la secuencia
	 * principal o secundaria
	 * 
	 * @param idSecUno
	 * @param idSecDos
	 */
	public void asignaSecuencias(Long idSecUno, Long idSecDos) {
		// Buscamos secuencia principal
		setSecuenciaPrincipal(obtieneSecuciaById(idSecUno));
		// Buscamos secuencia secundaria
		setSecuenciaSecundaria(obtieneSecuciaById(idSecDos));
	}

	/**
	 * Metodo con el cual obtengo una secuencia por medio de su id
	 * 
	 * @param id
	 */
	public ArchivoFastaEntity obtieneSecuciaById(Long id) {
		Optional<ArchivoFastaEntity> archivo = archivoFastaRepository.findById(id);
		if (!archivo.isPresent()) {
			LOGGER.info("Secuencia no encontrada: ".concat(id.toString()));
		}
		return archivo.get();
	}

	/**
	 * Metodo con el cual se genera la matriz resultante
	 */
	public void generarMatrizResultante() {
		LOGGER.info("Valor de X".concat(matrizResultante.valorEjeX().toString()) );
		LOGGER.info("Valor de Y".concat(matrizResultante.valorEjeY().toString()) );
		for(int i = 0 ; i < matrizResultante.valorEjeX() ; i++) {
			for(int j = 0 ; j < matrizResultante.valorEjeY() ; j++) {
				CeldaMatrizDto valMaximo =  evaluaMovimientosPosicion(i,j);
				//LOGGER.info("Valor Maximo de la posición: ".concat(valMaximo.toString()));
				matrizResultante.setValMatrizRes(i,j,valMaximo);
			}
		}
	}

	/**
	 * Metodo con el cual se obtienen todos los posibles movimientos y se da el
	 * valor maximo
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private CeldaMatrizDto evaluaMovimientosPosicion(Integer x, Integer y) {
		LOGGER.debug("Valores para las coordenadas X = ".concat(x.toString()).concat(" ... Y = ").concat(y.toString()));
		Short movUno = matrizResultante.movimientoUno(x, y);
		LOGGER.debug("Valor moviemiento uno: ".concat(movUno.toString()));
		Short movDos = matrizResultante.movimientoDos(x, y);
		LOGGER.debug("Valor moviemiento Dos: ".concat(movDos.toString()));
		Short movTres = matrizResultante.movimientoTres(x, y);
		LOGGER.debug("Valor moviemiento Dos: ".concat(movTres.toString()));
		return evaluaMayor(movUno, movDos, movTres) ;
	}
	/**
	 * Metodo con el cual evaluo cual es el numero mayor de las tres posibles
	 * @param uno
	 * @param dos
	 * @param tres
	 * @return
	 */
	private CeldaMatrizDto evaluaMayor(Short uno, Short dos, Short tres) {
		if(uno.compareTo(dos) >= 0 && uno.compareTo(tres) >= 0 ) {
			return CeldaMatrizDto.of(uno, Integer.valueOf("1"), uno, dos, tres);
		}else if(dos.compareTo(uno) >= 0 && dos.compareTo(tres) >= 0 ) {
			return CeldaMatrizDto.of(dos, Integer.valueOf("2"), uno, dos, tres);
		}else if(tres.compareTo(dos) >= 0 && tres.compareTo(uno) >= 0 ) {
			return CeldaMatrizDto.of(tres, Integer.valueOf("3"), uno, dos, tres);
		}
		return null;
		
	}

}
