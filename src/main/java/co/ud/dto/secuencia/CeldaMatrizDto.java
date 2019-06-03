package co.ud.dto.secuencia;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CeldaMatrizDto {

	private Short valor;
	private Integer movimiento;
	
	
	private Short valorUno;
	private Short valorDos;
	private Short valorTres;
	
	
	
	public static CeldaMatrizDto of(Short valor, Integer movimiento, Short valorUno, Short valorDos, Short valorTres) {
		return new CeldaMatrizDto( valor,  movimiento,  valorUno,  valorDos,  valorTres);
	}

	

	public CeldaMatrizDto(Short valor, Integer movimiento, Short valorUno, Short valorDos, Short valorTres) {
		super();
		this.valor = valor;
		this.movimiento = movimiento;
		this.valorUno = valorUno;
		this.valorDos = valorDos;
		this.valorTres = valorTres;
	}



	public CeldaMatrizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
