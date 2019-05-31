package co.ud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ud.entity.ArchivoFastaEntity;

@Repository
public interface IArchivoFastaRepository extends JpaRepository<ArchivoFastaEntity, Long>, CrudRepository<ArchivoFastaEntity, Long>{

}
