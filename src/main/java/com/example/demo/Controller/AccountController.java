package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.AccountModel;
import com.example.demo.Service.AccountService;

@Controller
public class AccountController{
	@Autowired
	private AccountService akun_service;
	
	
	
	@RequestMapping(value="/list-all-account", method=RequestMethod.GET)
	private String listAllAccount(Model model, HttpServletRequest req ) {
		List<AccountModel> all_account = akun_service.get_all_account();
		model.addAttribute("seluruh_akun",all_account);
		return "seluruh_akun";
	}
	
	@RequestMapping(value="/add-account", method=RequestMethod.GET)
	private String addAccount(Model model, HttpServletRequest req ) {
		return "tambah_akun";
	}
	
	@RequestMapping(value="/add-account/submit", method=RequestMethod.POST)
	private String addAccountSave(Model model, 
			@ModelAttribute AccountModel account, 
			HttpServletRequest req,
			RedirectAttributes redir) {
		akun_service.add_account(account);
		redir.addFlashAttribute("notif", "Berhasil menambahkan akun dengan nama "+account.getUsername());		
		return "redirect:/list-all-account";
	}
	
	//bikin delete
	@RequestMapping(value="/delete-account", method=RequestMethod.GET)
	private String deleteAccount(Model model, 
			@RequestParam(value = "akun_id") String akun_id, 
			HttpServletRequest req,
			RedirectAttributes redir) {
		akun_service.delete_account(akun_service.get_account_by_id(Long.valueOf(akun_id)));
		return "redirect:/list-all-account";
	}
	
	
	//bikin find by id
	@RequestMapping(value="/find-by-id", method=RequestMethod.GET)
	private String findById(Model model, 
			HttpServletRequest req) {
		String id_user = req.getParameter("id");
		AccountModel target_account = akun_service.get_account_by_id(Long.valueOf(id_user));
		model.addAttribute("akun_target",target_account);
		return "find_by_id";
	}
	
	
	
}