package com.example.demo;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BanqueMetierImplemtion implements IBankMetier {
@Autowired
	private CompteReposotory compteReposotory;
@Autowired
private OperationReposotory operationReposotory;

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp=compteReposotory.findById(codeCpte).orElse(null);
		if(cp==null)throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCopte, double monatant) {
		Compte cp=consulterCompte(codeCopte);
		Versement v=new Versement(new Date(),monatant,cp);
		operationReposotory.save(v);
		cp.setSolde(cp.getSolde()+monatant);//mettre a joure le compte
		compteReposotory.save(cp);//ensajel el compte bel mo3tayete ejdida
	}

	@Override
	public void retirer(String codeCopte, double monatant) {
		// TODO Auto-generated method stub
		Compte cp=consulterCompte(codeCopte);
		double facilescaisse=0;
		if(cp instanceof CompteCourant)
			          facilescaisse=(((CompteCourant) cp).getDecouvert());
		if(cp.getSolde()+facilescaisse<monatant)
			            throw new RuntimeException("Solde insuffisant");
		
		Retrait v=new Retrait(new Date(),monatant,cp);
		operationReposotory.save(v);
		cp.setSolde(cp.getSolde()-monatant);//mettre a joure le compte
		compteReposotory.save(cp);//ensajel el compte bel mo3tayete ejdida
	}

	@Override
	public void virment(String codeCopte1, String codeCpte2, double montant) {
	if(codeCopte1.equals(codeCpte2))
		throw new RuntimeException("Imposible de Vriment sur la meme compte");
		retirer(codeCopte1, montant);
		verser(codeCpte2, montant);
	}

	@Override
	public Page<Operation> ListeOperation(String codeCpte, int page, int size) {
		// TODO Auto-generated method stubuest()
		return operationReposotory.listOperation(codeCpte,PageRequest.of(page, size));
	}

}
