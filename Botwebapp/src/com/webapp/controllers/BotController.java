package com.webapp.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.dao.StockDetailsDao;
import com.webapp.entities.StockDetails;
import com.webapp.formbeans.Stocksearchbean;
import com.webapp.services.StockDetailsDaoService;

@Controller
public class BotController {

	@Autowired
	private StockDetailsDaoService sdaoservice;

	@RequestMapping("/stocksearch")

	public ModelAndView getstockcodes(Model model) {

		StockDetails sd = new StockDetails();

		model.addAttribute("stocksearchbean", new Stocksearchbean());

		ModelAndView mv = new ModelAndView("stockdetailspage", "command", sd);

//		StockDetailsDao sdao = new StockDetailsDao();

//		model.addAttribute("stocklist",sdao.getstockdetails() );

		return mv;

	}

	@RequestMapping("/gettabledata")

	public ModelAndView getpage(@ModelAttribute("stocksearchbean") Stocksearchbean stockformbean, Model model) {

		String stockname = stockformbean.getStockname();

		System.out.println("Ziggy" + stockname);

		// StockDetailsDao sdao = new StockDetailsDao();

		// sdao.checkajaxcall(stockname);

		ModelAndView mv = new ModelAndView("stockdetailspage", "command", sdaoservice.checkajaxcall(stockname));
		return mv;
	}

	@RequestMapping("/strategysearch")
	public ModelAndView getstrategydetails() {
		StockDetails sd = new StockDetails();
		return new ModelAndView("strategysearch", "command", sd);

	}

	@ModelAttribute("stocklist")

	public ArrayList<StockDetails> getstockdetails() {

		// StockDetailsDao sdao = new StockDetailsDao();

		return sdaoservice.getstockdetails();
	}

}
