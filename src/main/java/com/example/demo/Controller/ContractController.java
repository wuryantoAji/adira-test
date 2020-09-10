package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.ContractModel;
import com.example.demo.Service.ContractService;

@Controller
public class ContractController {
	@Autowired 
	private ContractService contract_service;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	private String home(Model model, HttpServletRequest req) {
		List<ContractModel> all_contract = contract_service.get_all_contract();
		model.addAttribute("seluruh_contract",all_contract);
		return "home";
	}
	
	@RequestMapping(value="/add-contract/submit", method=RequestMethod.POST)
	private String addContractSave(Model model, 
			@ModelAttribute ContractModel contract, 
			HttpServletRequest req,
			RedirectAttributes redir) {
		contract_service.add_contract(contract);
		return "redirect:/";
	}
	
	@RequestMapping(value="/bayar-kontrak", method=RequestMethod.POST)
	private String bayarKontrak(Model model, 
			HttpServletRequest req,
			RedirectAttributes redir) {
		String payment_input = req.getParameter("total_bayar");
		String kontrak_no_input = req.getParameter("contract_no");
		int payment_nominal = Integer.valueOf(payment_input);
		int kontrak_no = Integer.valueOf(kontrak_no_input);
		contract_service.do_payment(payment_nominal, kontrak_no);
		
		
		return "redirect:/";
	}
	
	
	
	
}
