package com.app.statement;

import java.time.LocalDate;

public class Statement {
//TransactionDate,Narration,WithdrawalAmount,DepositAmount
	private String transactionDate;
	private String narration;
	private double withdrawalAmount;
	private double depositeAmount;
	public Statement(String transactionDate, String narration, double withdrawalAmount, double depositeAmount) {
		super();
		this.transactionDate = transactionDate;
		this.narration = narration;
		this.withdrawalAmount = withdrawalAmount;
		this.depositeAmount = depositeAmount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	public double getDepositeAmount() {
		return depositeAmount;
	}
	public void setDepositeAmount(double depositeAmount) {
		this.depositeAmount = depositeAmount;
	}
	@Override
	public String toString() {
		return "Statement [transactionDate=" + transactionDate + ", narration=" + narration + ", withdrawalAmount="
				+ withdrawalAmount + ", depositeAmount=" + depositeAmount + "]";
	}
	
	
}
