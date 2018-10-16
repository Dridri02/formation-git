package fr.insee.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.insee.bar.model.Client;
import fr.insee.bar.repository.ClientRepository;

@Controller
public class ClientsController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/clients")
	public String clients(Model model, Pageable pageable) {
		Page<Client> clients = clientRepository.findAll(pageable);
		model.addAttribute("clients", clients);
		return "clients";
	}
}
