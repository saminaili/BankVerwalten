package com.example.demo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
private double taux;

public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client) {
	super(codeCompte, dateCreation, solde, client);
	// TODO Auto-generated constructor stub
}

public CompteEpargne() {
	super();
}

public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}



}
