package com.example.demo;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankVerwaltenApplication implements CommandLineRunner {
	@Autowired
	private  ClientReposotory clientReposotory;
	@Autowired
	private CompteReposotory compteReposotory;
	@Autowired
	private OperationReposotory operationReposotory;
	@Autowired
	private IBankMetier iBank;
	public static void main(String[] args) {
		SpringApplication.run(BankVerwaltenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Client c1=clientReposotory.save(new Client("HASSAN","hassan@gmail.com"));
		Client c2=clientReposotory.save(new Client("LILA","lila@gmail.com"));
		Client c3=clientReposotory.save(new Client("MAzen","mazen@gmail.com"));
	CompteCourant cp1=compteReposotory.save(new CompteCourant("c1",new Date(),9000,c1,6000) );
	Compte cp2=compteReposotory.save(new CompteCourant("c2",new Date(),9000,c2,5.2) );
	Compte cp3=compteReposotory.save(new CompteCourant("c3",new Date(),9000,c3,12.0) );
	
	Operation op1=operationReposotory.save(new Versement(new Date(),2300,cp1));
	Operation op2=operationReposotory.save(new Versement(new Date(),800,cp2));
	
	iBank.verser("c1", 110);*/
	
	}

}
