package co.ud.service;

public interface IAlineacionService {
	/**
	 * Metodo con el cual alineo dos secuencias en formato FASTA
	 * @param idSecUno
	 * @param idSecDos
	 * @return Long Id del resultado de las secuencias resultantes de la alineacion de las secuencias
	 */
	Long alineacionSecuencias(Long idSecUno, Long idSecDos);

}
