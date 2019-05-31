package co.ud.exception;

public class FileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer line;
	private String archivo;

	public FileException(Integer line, String archivo) {
		super();
		this.line = line;
		this.archivo = archivo;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

}
