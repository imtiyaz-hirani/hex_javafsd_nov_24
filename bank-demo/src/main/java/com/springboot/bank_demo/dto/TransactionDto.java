package com.springboot.bank_demo.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class TransactionDto {

	private double amount;
	private LocalDate dateOfTransfer;
	private String modeOfTransfer;
	private String senderAccountnumber;
	private String beneficiaryAccountNumber;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDateOfTransfer() {
		return dateOfTransfer;
	}
	public void setDateOfTransfer(LocalDate dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}
	public String getModeOfTransfer() {
		return modeOfTransfer;
	}
	public void setModeOfTransfer(String modeOfTransfer) {
		this.modeOfTransfer = modeOfTransfer;
	}
	public String getSenderAccountnumber() {
		return senderAccountnumber;
	}
	public void setSenderAccountnumber(String senderAccountnumber) {
		this.senderAccountnumber = senderAccountnumber;
	}
	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	@Override
	public String toString() {
		return "TransactionDto [amount=" + amount + ", dateOfTransfer=" + dateOfTransfer + ", modeOfTransfer="
				+ modeOfTransfer + ", senderAccountnumber=" + senderAccountnumber + ", beneficiaryAccountNumber="
				+ beneficiaryAccountNumber + "]";
	}

	 

}
