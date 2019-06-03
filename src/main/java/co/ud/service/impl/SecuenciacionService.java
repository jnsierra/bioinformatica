package co.ud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ud.entity.SecuenciacionEntity;
import co.ud.repository.ISecuenciacionRepository;
import co.ud.service.ISecuenciacionService;

@Service
public class SecuenciacionService implements ISecuenciacionService{
	@Autowired
	ISecuenciacionRepository secuenciacionRepository;

	@Override
	public List<SecuenciacionEntity> getAll() {
		return secuenciacionRepository.findAll();
	}

	@Override
	public Optional<SecuenciacionEntity> getById(Long id) {
		return secuenciacionRepository.findById(id);
	}

}
