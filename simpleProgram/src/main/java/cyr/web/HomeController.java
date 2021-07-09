package cyr.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cyr.User;
import cyr.data.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private UserService service;
	
	public HomeController(UserService service) {
		this.service=service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String check(@RequestParam("account") String account,@RequestParam("password") String password,Model model,RedirectAttributes attr) {
		if(service.hasThisAccount(account)) {
			if(service.truePassword(account, password)) {
				User user=service.findById(account);
				//System.out.println(user.getLastName());
				//model.addAttribute("user",user);
				attr.addFlashAttribute("user", user);
				return "redirect:/home/singin";
			}
			return "ttok";
		}
		return "tno";
	}
	
	@RequestMapping(value="/singin",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public String myHome(@ModelAttribute("user") User attuser,Model model) {
		User user=attuser;
		model.addAttribute("user",user);
		return "myhome";
	}
	
	@RequestMapping(value="/singin",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String updateUser(@Valid User user,RedirectAttributes attr,RedirectAttributes att) {
		System.out.println("123");
		User u=user;
		service.updateUser(u);
		att.addFlashAttribute("user", u);
		return "redirect:/home/singin";
	}
}
