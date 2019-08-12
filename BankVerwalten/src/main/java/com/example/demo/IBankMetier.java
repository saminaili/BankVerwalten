package com.example.demo;

import java.util.Optional;

import org.springframework.data.domain.Page;

public interface IBankMetier {
public Compte consulterCompte(String codeCpte);
public void verser(String codeCopte,double monatant);
public void retirer(String codeCopte,double monatant);
public void virment(String codeCopte1,String codeCpte2,double montant);
public Page<Operation>ListeOperation(String codeCpte,int page,int size);




}
