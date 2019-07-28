package com.webapp.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.dao.StockDetailsDao;
import com.webapp.entities.StockDetails;
import com.webapp.formbeans.Stocksearchbean;

@Controller
public class BotController {

	
	@RequestMapping("/stocksearch")
	public ModelAndView getstockcodes(Model model){
		
		
		StockDetails sd = new StockDetails();
		
		
		ModelAndView mv = new ModelAndView("stockdetailspage", "command", sd);
		
		
		
//		StockDetailsDao sdao = new StockDetailsDao();
		
//		model.addAttribute("stocklist",sdao.getstockdetails() );
		
		return mv;
		
		
		
	}
	
	@RequestMapping("/shdhhsj")
	public String getpage(@ModelAttribute("Stocksearchbean") Stocksearchbean search) {
		
		
		
		return null;
		
		
	}
	
	
	  @ModelAttribute("stocklist")
	  
	  public ArrayList<StockDetails> getstockdetails(){
	  
	  StockDetailsDao sdao = new StockDetailsDao();
	  
	  return sdao.getstockdetails(); }
	 
	
	
}
