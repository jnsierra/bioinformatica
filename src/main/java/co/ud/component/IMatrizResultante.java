package co.ud.component;

import co.ud.enumeracion.TIPO_SECUENCIA;

public interface IMatrizResultante {
	void setValMatrizRes(Integer x, Integer y, Short val);
	
	/**
	 * Metodo con el cual seteo las secuencias que se desean alinear
	 */
	void setSecuencia(TIPO_SECUENCIA tSec, String secuencia);
	/**
	 * Metodo con el cual genero una lista con los caracteres de las secuencias
	 */
	void generaListaCaracteres();
	
	/**
	 * Metodo con el cual se genera la matriz resultante del algoritmo
	 */
	void generaMatrizResultante();
	/**
	 * Metodo con el cua imprimo la matriz 
	 */
	void imprimirMatriz();
	/**
	 * Metodo con el cual se genera el primer movimiento
	 * @param x
	 * @param y
	 * @return
	 */
	Short movimientoUno(Integer x , Integer y );
	/**
	 * Metodo con el cual se genera el Segundo movimiento
	 * @param x
	 * @param y
	 * @return
	 */
	Short movimientoDos(Integer x , Integer y );
	/**
	 * Metodo con el cual se genera el Tercer movimiento
	 * @param x
	 * @param y
	 * @return
	 */
	Short movimientoTres(Integer x , Integer y );
	/**
	 * Metodo con el cual se obtendra el valor del eje x de la matriz
	 * @return
	 */
	Integer valorEjeX();
	/**
	 * Metodo con el cual se obtendra el valor del eje Y de la matriz
	 * @return
	 */
	Integer valorEjeY();
	
}