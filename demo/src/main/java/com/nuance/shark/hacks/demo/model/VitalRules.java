package com.nuance.shark.hacks.demo.model;

import java.io.Serializable;

import com.nuance.shark.hacks.demo.entity.VitalRulesEntity;

public class VitalRules implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long vitalsRuleSid;
	private String name;
	private String description;
	private String riskLevel;
	private String definition;

	public VitalRules() {
	}

	public VitalRules(VitalRulesEntity e) {
		this.vitalsRuleSid = e.getVitalsRuleSid();
		this.name = e.getName();
		this.description = e.getDescription();
		this.riskLevel = e.getRiskLevel();
		this.definition = e.getDefinition();
	}

	public Long getVitalsRuleSid() {
		return vitalsRuleSid;
	}

	public void setVitalsRuleSid(Long vitalsRuleSid) {
		this.vitalsRuleSid = vitalsRuleSid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

}
