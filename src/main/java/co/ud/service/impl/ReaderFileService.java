package co.ud.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import co.ud.service.IReaderFileService;

@Service("readerFileService")
public class ReaderFileService implements IReaderFileService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReaderFileService.class);

	@Value("classpath:archivoTexto.txt")
	private Resource res;

	@Override
	public List<String> getFile() throws IOException {
		LOGGER.debug(".:: Inicio de la lectura del archivo plano ::.");
		List<String> lines = Files.readAllLines(Paths.get(res.getURI()), StandardCharsets.UTF_8);
		return lines;
	}

}
