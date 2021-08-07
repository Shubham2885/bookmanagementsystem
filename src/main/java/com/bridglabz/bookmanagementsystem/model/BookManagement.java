package com.bridglabz.bookmanagementsystem.model;

import java.util.Date;

public class BookManagement {
	private int managementId;
	private int customerId;
	private int bookId;
	private Date dateOfIssue;
	private Date dataOfReturn;
	private int quantity;
	private int totalBillAmount;

	public int getManagementId() {
		return managementId;
	}

	public void setManagementId(int managementId) {
		this.managementId = managementId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDataOfReturn() {
		return dataOfReturn;
	}

	public void setDataOfReturn(Date dataOfReturn) {
		this.dataOfReturn = dataOfReturn;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(int totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}
}
