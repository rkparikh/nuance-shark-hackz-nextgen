
package com.nuance.shark.hacks.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.nuance.shark.hacks.demo.entity.PatientEntity;

public interface PatientDao extends CrudRepository<PatientEntity, Long> {

	PatientEntity findByMrn(String mrn);

}
