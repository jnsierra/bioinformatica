package co.ud.component.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import co.ud.component.IMatrizBaseConsultaService;

@Component
public class MatrizBaseConsultaService implements IMatrizBaseConsultaService {

	private List<List<Short>> matrizBase;

	Logger logger = LoggerFactory.getLogger(MatrizBaseConsultaService.class);

	@PostConstruct
	public void init() {
		matrizBase = new ArrayList<List<Short>>();
		logger.info(".:: Iniciando construccion de la matriz base ::.");
		// Inicalizo las filas
		this.matrizBase.add(new ArrayList<Short>());
		this.matrizBase.add(new ArrayList<Short>());
		this.matrizBase.add(new ArrayList<Short>());
		this.matrizBase.add(new ArrayList<Short>());
		// Inserto las columnas
		// Primera fila
		this.matrizBase.get(0).add(Short.valueOf("10"));
		this.matrizBase.get(0).add(Short.valueOf("-1"));
		this.matrizBase.get(0).add(Short.valueOf("-3"));
		this.matrizBase.get(0).add(Short.valueOf("-4"));

		// Segunda fila
		this.matrizBase.get(1).add(Short.valueOf("-1"));
		this.matrizBase.get(1).add(Short.valueOf("7"));
		this.matrizBase.get(1).add(Short.valueOf("-5"));
		this.matrizBase.get(1).add(Short.valueOf("-3"));

		// Tercera fila
		this.matrizBase.get(2).add(Short.valueOf("-3"));
		this.matrizBase.get(2).add(Short.valueOf("-5"));
		this.matrizBase.get(2).add(Short.valueOf("9"));
		this.matrizBase.get(2).add(Short.valueOf("0"));

		// Tercera fila
		this.matrizBase.get(3).add(Short.valueOf("-4"));
		this.matrizBase.get(3).add(Short.valueOf("-3"));
		this.matrizBase.get(3).add(Short.valueOf("0"));
		this.matrizBase.get(3).add(Short.valueOf("8"));
		logger.info("*********** Matriz Base  ***********");
		for (List<Short> filas : matrizBase) {
			String fila = "";
			for (Short columnas : filas) {
				fila += " " + columnas;
			}
			logger.info("Columna : ".concat(fila));
		}
		logger.info("*********************************");

	}

	@Override
	public Short obtenerPesoSecuencia(Short x, Short y) {
		return getMatrizBase().get(x-1).get(y-1);
	}

	public List<List<Short>> getMatrizBase() {
		return matrizBase;
	}

	public void setMatrizBase(List<List<Short>> matrizBase) {
		this.matrizBase = matrizBase;
	}

}