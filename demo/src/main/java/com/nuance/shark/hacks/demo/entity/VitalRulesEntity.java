package com.nuance.shark.hacks.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VITALS_RULE")

public class VitalRulesEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VITALS_RULE_SID", unique = true, nullable = false)
	private Long vitalsRuleSid;

	@Column(name = "NAME", length = 32)
	private String name;

	@Column(name = "DESCRIPTION", length = 256)
	private String description;

	@Column(name = "RISK_LEVEL", length = 32)
	private String riskLevel;

	@Column(name = "DEFINITION")
	private String definition;

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
