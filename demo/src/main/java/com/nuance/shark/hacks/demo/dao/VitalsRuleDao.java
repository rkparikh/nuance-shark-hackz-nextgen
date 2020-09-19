
package com.nuance.shark.hacks.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.nuance.shark.hacks.demo.entity.VitalRulesEntity;

public interface VitalsRuleDao extends CrudRepository<VitalRulesEntity, Long> {

}
