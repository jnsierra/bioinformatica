package co.ud.component;

public interface INeedlemanComponent {
	/**
	 * Fachada en la cual se genera el algoritmo
	 * @param idPrinc
	 * @param idSecu
	 * @return
	 */
	Long generarAlgoritmo(Long idPrinc, Long idSecu);

}
