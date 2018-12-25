package com.jp.tradereporting.vo;

import java.io.Serializable;

public class EntityVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String entityCode;
	private String entityName;
	
	public EntityVO(String entityCode) {
		this.entityCode = entityCode;
	}

	public EntityVO(String entityCode,String entityName) {
		this.entityCode = entityCode;
		this.entityName = entityName;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public String toString(){
		return "Entity: "+entityCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		EntityVO entity = (EntityVO) o;
		return (entityCode.equals(entity.getEntityCode()));
	}
	
	@Override
	public int hashCode() {
	    int hash = 7;
	    hash = 31 * hash + (entityCode == null ? 0 : entityCode.hashCode());
	    hash = 31 * hash + (entityName == null ? 0 : entityName.hashCode());
	    return hash;
	}
}
