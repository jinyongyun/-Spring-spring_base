package com.jinyong.newWebProject;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
       // binder.setValidator(new UserValidator());
       // binder.addValidators(new UserValidator());
       List<Validator> validatorList = binder.getValidators();
       System.out.println("validatorList="+validatorList);
	}
	
	
  @RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
  public String register() {
	  return "registerForm";
  }
  
  
  @PostMapping("/save") // 얘 바꿔 
  public String save(@Valid User user, BindingResult result, Model m) throws Exception {
	  
		// UserValidator userValidator = new UserValidator();
		// userValidator.validate(user, result);
	 
	 if(result.hasErrors()) {
		 return "registerForm";
		 
	 }
	  //if(!isValid(user)) {
	//	  String msg = URLEncoder.encode("id를 잘못입력하셨습니다!", "utf-8");
		  
	//	  m.addAttribute("msg", msg);
	//	  return "forward:/register/add";
	 // }
	  
	  return "registerInfo";
	  
  }
  
   private boolean isValid(User user) {
	   return true;
	   
   }
}
