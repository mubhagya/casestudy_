package com.payment.paymentservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;





@Document(collection="payment")
public class Payment{
@Id
private int paymentId;
private int profileId;
private double currentBalance;
private List<String> statements;

public Payment(int profileId, double currentBalance, List<String> statements) {
	super();
	this.profileId = profileId;
	this.currentBalance = currentBalance;
	this.statements = statements;
  }


public Payment(int paymentId, int profileId, double currentBalance, List<String> statements) {
	super();
	this.paymentId = paymentId;
	this.profileId = profileId;
	this.currentBalance = currentBalance;
	this.statements = statements;
}


public Payment() {

}


public int getPaymentId() {
	return paymentId;
}

public void setPaymentId(int paymentId) {
	this.paymentId = paymentId;
}

public int getProfileId() {
	return profileId;
}

public void setProfileId(int profileId) {
	this.profileId = profileId;
}

public double getCurrentBalance() {
	return currentBalance;
}

public void setCurrentBalance(double currentBalance) {
	this.currentBalance = currentBalance;
}

public List<String> getStatements() {
	return statements;
}

public void setStatements(List<String> statements) {
	this.statements = statements;
}

@Override
public String toString() {
	return "Payment [paymentId=" + paymentId + ", profileId=" + profileId + ", currentBalance=" + currentBalance
			+ ", statements=" + statements + "]";
}



}