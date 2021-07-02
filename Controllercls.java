package com.example.Findingnumbergame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllercls {
	static String str;
	
	@Autowired
	Repository rep;
	
	@Autowired
	Emailsendercls em;
	
  @RequestMapping()
  public String first()
  {
	  return "index";
  }
  
  @RequestMapping("/step1")
  public String progessOne(Firsthelper fp) {
	 str=fp.getFullName();
	 rep.save(fp);
	 try {
	 String body="Thanks for your valuable time for attending this finding number by math tricks. Have fun. Follow your dreams. Thank you..! ";
 	String sub="Acknowlegement mail for visiting finding number game";
	 em.sender(fp.getEmail(), sub, body);}
	 catch(Exception e) {
		 System.out.println(e);
	 }
	  return "step1";
  }
  @RequestMapping("/step2")
  public String progrestwo() {
	  return "step2";
  }
  @RequestMapping("/result")
  public ModelAndView end(Helpercls hp) {
	  ModelAndView mv=new ModelAndView();
	  int j=hp.getResult();
	  int res=j-5;
	   mv.addObject("output",res);
	  System.out.println(j);
	  System.out.println(str);
	  
	  return mv;
  }
}
