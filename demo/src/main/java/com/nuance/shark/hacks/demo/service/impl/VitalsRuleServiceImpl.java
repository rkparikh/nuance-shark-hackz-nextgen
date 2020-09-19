
package com.nuance.shark.hacks.demo.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuance.shark.hacks.demo.dao.VitalsRuleDao;
import com.nuance.shark.hacks.demo.entity.VitalRulesEntity;
import com.nuance.shark.hacks.demo.model.VitalRules;
import com.nuance.shark.hacks.demo.service.VitalsRulesService;

@Service
public class VitalsRuleServiceImpl implements VitalsRulesService {

	@Autowired
	private VitalsRuleDao vitalsRuleDao;

	@Override
	public List<VitalRules> getAllRules() {
		List<VitalRules> rules = new ArrayList<>();
		Iterable<VitalRulesEntity> dBrules = vitalsRuleDao.findAll();
		dBrules.forEach(r -> rules.add(new VitalRules(r)));
		rules.sort(Comparator.comparing(VitalRules::getName));
		return rules;
	}
}
