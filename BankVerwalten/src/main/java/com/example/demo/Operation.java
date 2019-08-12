package com.example.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract  class Operation implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long numero;
private Date dateOperation;
private double montant;
@ManyToOne
@JoinColumn(name="CODE_CPTE")
private Compte compte;//ya3ni operation tentami lel compte:)
public Operation() {
	super();
}
public Operation( Date dateOperation, double montant, Compte cp) {
	super();
	
	this.dateOperation = dateOperation;
	this.montant = montant;
	this.compte = cp;
}
public long getNumero() {
	return numero;
}
public void setNumero(long numero) {
	this.numero = numero;
}
public Date getDateOperation() {
	return dateOperation;
}
public void setDateOperation(Date dateOperation) {
	this.dateOperation = dateOperation;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}


}
