package com.jp.tradereporting.vo;

import java.io.Serializable;
import java.time.LocalDate;

import com.jp.tradereporting.constants.TransactionType;

public class InstructionVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityVO entity;
	private TransactionType transactionType;
	private Float fxRate;
	private CurrencyVO currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private LocalDate actualSettlementDate;
	private Long units;
	private Float price;

	public EntityVO getEntity() {
		return entity;
	}

	public void setEntity(EntityVO entity) {
		this.entity = entity;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Float getFxRate() {
		return fxRate;
	}

	public void setFxRate(Float fxRate) {
		this.fxRate = fxRate;
	}

	public CurrencyVO getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyVO currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public LocalDate getActualSettlementDate() {
		return actualSettlementDate;
	}

	public void setActualSettlementDate(LocalDate actualSettlementDate) {
		this.actualSettlementDate = actualSettlementDate;
	}

	public Long getUnits() {
		return units;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getUSDValue(){
		return this.price * this.fxRate * this.units;
	}

	@Override
	public String toString() {
		return "entity: " + entity.toString() + " transactionType: " + transactionType + " fxRate: " + fxRate
				+ " currency: " + currency.toString() + " instructionDate: " + instructionDate + " settlementDate: "
				+ settlementDate + " actualSettlementDate: " + actualSettlementDate + " units: " + units + " price: "
				+ price;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		InstructionVO instruction = (InstructionVO) o;
		return (entity.equals(instruction.getEntity()) && transactionType.equals(instruction.getTransactionType()) &&
				fxRate.equals(instruction.getFxRate()) && currency.equals(instruction.getCurrency()) && 
				instructionDate.equals(instruction.getInstructionDate()) && settlementDate.equals(instruction.getSettlementDate()) &&
				units.equals(instruction.getUnits()) && price.equals(instruction.getPrice()));
	}
	
	@Override
	public int hashCode() {
	    int hash = 7;
	    hash = 31 * hash + (entity == null ? 0 : entity.hashCode());
	    hash = 31 * hash + (transactionType == null ? 0 : transactionType.hashCode());
	    hash = 31 * hash + (fxRate == null ? 0 : fxRate.hashCode());
	    hash = 31 * hash + (currency == null ? 0 : currency.hashCode());
	    hash = 31 * hash + (instructionDate == null ? 0 : instructionDate.hashCode());
	    hash = 31 * hash + (settlementDate == null ? 0 : settlementDate.hashCode());
	    hash = 31 * hash + (units == null ? 0 : units.hashCode());
	    hash = 31 * hash + (price == null ? 0 : price.hashCode());
	    return hash;
	}

}
