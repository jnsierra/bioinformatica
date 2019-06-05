package co.ud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ud.entity.ArchivoFastaEntity;
import co.ud.repository.IArchivoFastaRepository;
import co.ud.service.IArchivoFastaService;

@Service
public class ArchivoFastaService implements IArchivoFastaService{
	
	@Autowired
	IArchivoFastaRepository archivoFastaRepository;

	@Override
	public List<ArchivoFastaEntity> getAll() {
		return archivoFastaRepository.findAll();
	}

	@Override
	public Optional<ArchivoFastaEntity> getById(Long id) {
		return archivoFastaRepository.findById(id);
	}

	@Override
	public Boolean deleteById(Long id) {
		archivoFastaRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public ArchivoFastaEntity insertFile(ArchivoFastaEntity archivo) {
		archivo = archivoFastaRepository.save(archivo);
		return archivo;
	}

}
