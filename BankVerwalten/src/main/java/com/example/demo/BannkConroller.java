package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BannkConroller {
@Autowired
private IBankMetier bamquemetrier;
@RequestMapping("/operations")
public String index() {
	return "Comptes";
	
	
}
@RequestMapping(value="/consulterCompte")
public String consulter(Model model,String codeCompte,
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="3")int size
		) {
	model.addAttribute("codeCompte",codeCompte);
	try {
		Compte cp=bamquemetrier.consulterCompte(codeCompte);
		model.addAttribute("compte",cp);
		Page<Operation>pageOperations=bamquemetrier.ListeOperation(codeCompte, page, size);
		model.addAttribute("listOperations",pageOperations.getContent());
		int[]pages=new int[pageOperations.getTotalPages()];
		model.addAttribute("pages", pages);
	} catch (Exception e) {
		model.addAttribute("exception",e);
	}
	return"comptes";
	
}

@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
public String saveOoeration(Model model,String typeOperation,String codeCompte,double montant,String codeCompte2) {
	
try {
	if(typeOperation.equals("VERS")) {
		bamquemetrier.verser(codeCompte, montant);
	}
	if(typeOperation.equals("RET")) {
		bamquemetrier.retirer(codeCompte, montant);
	}
	if(typeOperation.equals("VIR")) {
		bamquemetrier.virment(codeCompte, codeCompte2, montant);
	}
} catch (Exception e) {
		model.addAttribute("error", e);
		return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
}
	return "redirect:/consulterCompte?codeCompte="+codeCompte;
}
}
