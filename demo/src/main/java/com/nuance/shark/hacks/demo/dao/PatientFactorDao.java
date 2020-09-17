
package com.nuance.shark.hacks.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nuance.shark.hacks.demo.entity.PatientFactorEntity;

public interface PatientFactorDao extends CrudRepository<PatientFactorEntity, Long> {

	List<PatientFactorEntity> findByFactorSid(Long factorSid);

}
