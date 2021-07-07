package cyr.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cyr.JsonUility;
import cyr.User;
import cyr.data.UserService;

@Controller
@RequestMapping("/addUser")
public class AddUserController {
	
	private UserService service;
	
	public AddUserController(UserService service) {
		this.service=service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "addUser";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid User user,Errors errors,Model model) {
		if(errors.hasErrors() | service.hasThisAccount(user.getAccount())) {
			return "addUser";
		}
		service.addUser(user);
		//System.out.println("已建立帳號:"+user.getAccount());
		return "tok";
	}
	
	@RequestMapping(value ="/allowId",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String allowId(@RequestParam(value = "id") String id) {
		if(service.hasThisAccount(id)) {
			return JsonUility.data("此帳號已存在，請更換",false).toString();
		}
		return JsonUility.data("此帳號可以使用",true).toString();
	}
	
}
