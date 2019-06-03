package co.ud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ud.entity.SecuenciacionEntity;

@Repository
public interface ISecuenciacionRepository extends CrudRepository<SecuenciacionEntity, Long>, JpaRepository<SecuenciacionEntity, Long>{

}
