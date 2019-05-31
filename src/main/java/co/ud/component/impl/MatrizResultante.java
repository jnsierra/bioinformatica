package co.ud.component.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.ud.component.IMatrizBaseConsultaService;
import co.ud.component.IMatrizResultante;
import co.ud.enumeracion.CARACTERES_SECUENCIA;
import co.ud.enumeracion.TIPO_SECUENCIA;
import lombok.Getter;
import lombok.Setter;

@Component
public class MatrizResultante implements IMatrizResultante {
	@Getter
	@Setter
	private String secPrincipal;
	@Getter
	@Setter
	private String secSecundaria;
	@Getter
	@Setter
	private List<Short> listSecPrincipal;
	@Getter
	@Setter
	private List<Short> listGapPrinc;
	@Getter
	@Setter
	private List<Short> listSecSecundaria;
	@Getter
	@Setter
	private List<Short> listGapSec;
	@Getter
	@Setter
	private List<List<Short>> matrizResultante;

	@Autowired
	IMatrizBaseConsultaService matrizBaseConsultaService;

	private Short GAP_VALUE = Short.valueOf("-5");

	Logger logger = LoggerFactory.getLogger(MatrizBaseConsultaService.class);

	@Override
	public void setSecuencia(TIPO_SECUENCIA tSec, String secuencia) {
		if (tSec.equals(TIPO_SECUENCIA.PRIMARIA)) {
			setSecPrincipal(secuencia);
		} else if (tSec.equals(TIPO_SECUENCIA.SECUNDARIA)) {
			setSecSecundaria(secuencia);
		}
	}

	@Override
	public void generaListaCaracteres() {
		// Secuencia principal
		setListSecPrincipal(stringToList(secPrincipal));
		setListSecSecundaria(stringToList(secSecundaria));
	}

	@Override
	public void generaMatrizResultante() {
		// Iniciar matriz resultante
		matrizResultante = new ArrayList<List<Short>>();
		for (int i = 0; i < secSecundaria.length(); i++) {
			matrizResultante.add(new ArrayList<Short>());
		}
		// Inicial lista para los gaps
		listGapPrinc = new ArrayList<>();
		for (int i = 1; i < secPrincipal.length() + 1; i++) {
			int mult = GAP_VALUE * i;
			String aux = Integer.valueOf(mult).toString();
			listGapPrinc.add(Short.valueOf(aux));
		}

		listGapSec = new ArrayList<>();
		for (int i = 1; i < secSecundaria.length() + 1; i++) {
			int mult = GAP_VALUE * i;
			String aux = Integer.valueOf(mult).toString();
			listGapSec.add(Short.valueOf(aux));
		}

	}

	/**
	 * Metodo con el cual convierto una cadena de caracteres en una lista de
	 * caracteres y cada item es un solo caracter
	 * 
	 * @return
	 */
	private List<Short> stringToList(String linea) {
		List<Short> result = new ArrayList<Short>();
		for (int i = 0; i < linea.length(); i++) {
			result.add(mapeoCaracteres(linea.substring(i, i + 1)));
		}
		return result;
	}

	/**
	 * Metodo con el cual transformo el caracter en un numero
	 * 
	 * @return
	 */
	private Short mapeoCaracteres(String caracter) {
		if (CARACTERES_SECUENCIA.ADENINA.getDiminutivo().equalsIgnoreCase(caracter)) {
			return CARACTERES_SECUENCIA.ADENINA.getIdentificacion();
		} else if (CARACTERES_SECUENCIA.CITOSINA.getDiminutivo().equalsIgnoreCase(caracter)) {
			return CARACTERES_SECUENCIA.CITOSINA.getIdentificacion();
		} else if (CARACTERES_SECUENCIA.GUANINA.getDiminutivo().equalsIgnoreCase(caracter)) {
			return CARACTERES_SECUENCIA.GUANINA.getIdentificacion();
		} else if (CARACTERES_SECUENCIA.TIMINA.getDiminutivo().equalsIgnoreCase(caracter)) {
			return CARACTERES_SECUENCIA.TIMINA.getIdentificacion();
		}
		return null;
	}

	@Override
	public void imprimirMatriz() {
		logger.info("*********** Matriz Base  ***********");
		for (List<Short> filas : getMatrizResultante()) {
			String fila = "";
			for (Short columnas : filas) {
				fila += " " + columnas;
			}
			logger.info("Columna : ".concat(fila));
		}
		logger.info("*********************************");
	}

	@Override
	public Short movimientoUno(Integer x , Integer y ) {
		//Obtener el valor de arriba a la izquierda
		Short arrIzq = arribaIzq(x,y);
		Short score = matrizBaseConsultaService.obtenerPesoSecuencia(getListSecPrincipal().get(x), getListSecSecundaria().get(y));
		Integer total = arrIzq + score;
		return Short.valueOf(total.toString());
	}	

	@Override
	public Short movimientoDos(Integer x, Integer y) {
		Short der = derecha(x,y);
		Short gap = GAP_VALUE;
		Integer total = der + gap;
		return Short.valueOf(total.toString());
	}

	@Override
	public Short movimientoTres(Integer x, Integer y) {
		Short arri = arriba(x,y);
		Short gap = GAP_VALUE;
		Integer total = arri + gap;
		return Short.valueOf(total.toString());
	}

	@Override
	public void setValMatrizRes(Integer x, Integer y, Short val) {
		getMatrizResultante().get(y).add(val);
	}
	/**
	 * Metodo con el cual obtengo el valor de arriba a la izquierda
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private Short arribaIzq(Integer x, Integer y) {
		if (y.equals(Integer.valueOf("0"))) {
			if (x.equals(Integer.valueOf("0"))) {
				return Short.valueOf("0");
			}
			return listGapPrinc.get(x-1);
		}
		if(x.equals(Integer.valueOf("0"))) {
			return listGapSec.get(y-1);
		}
		return getMatrizResultante().get(y-1).get(x-1);
	}
	
	/**
	 * Metodo con el cual obtengo el valor de la derecha
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private Short derecha(Integer x, Integer y) {
		if(x.equals(Integer.valueOf("0"))) {
			return listGapSec.get(y);
		}
		return matrizResultante.get(y).get(x-1);
	}
	/**
	 * Metodo con el cual obtengo el valor de arriba a la izquierda
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private Short arriba(Integer x, Integer y) {
		if(y.equals(Integer.valueOf("0"))) {
			return listGapPrinc.get(x);
		}
		return matrizResultante.get(y-1).get(x);
	}

	@Override
	public Integer valorEjeX() {
		return getSecPrincipal().length();
	}

	@Override
	public Integer valorEjeY() {
		return getSecSecundaria().length();
	}
}
