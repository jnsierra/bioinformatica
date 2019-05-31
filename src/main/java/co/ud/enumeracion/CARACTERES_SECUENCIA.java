package co.ud.enumeracion;

public enum CARACTERES_SECUENCIA {
	
	ADENINA(Short.valueOf("1"), "adenina", "A"), CITOSINA(Short.valueOf("3"), "citosina", "C"),
	GUANINA(Short.valueOf("2"), "guanina", "G"), TIMINA(Short.valueOf("4"), "timina", "T");

	private Short identificacion;
	private String valor;
	private String diminutivo;
	
	private CARACTERES_SECUENCIA(Short identificacion, String valor, String diminutivo) {
		this.identificacion = identificacion;
		this.valor = valor;
		this.diminutivo = diminutivo;
		
	}

	public Short getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Short identificacion) {
		this.identificacion = identificacion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDiminutivo() {
		return diminutivo;
	}

	public void setDiminutivo(String diminutivo) {
		this.diminutivo = diminutivo;
	}
}
