package com.webapp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.dao.TableDao;
import com.webapp.entities.SMAdata;
import com.webapp.services.StockDetailsDaoService;

@Controller
public class ViewController {

	private StockDetailsDaoService dservice;

	@RequestMapping("/")
	public String Homepage() {
		return "Home";
	}

	@RequestMapping("/table")
	public String tablepage() {

		return "Table";
	}

	@RequestMapping(value = "/tabledata/{pageid}")
	public String tabledatapage(@PathVariable("pageid") int id, Model model) {

		int pageid = id;
		int total = 10;
		if (pageid == 1) {
		} else {
			pageid = pageid - 1;
			pageid = pageid * total + 1;
			System.out.println("PageId" + pageid);
		}

		List<SMAdata> list = new TableDao().getRecords(pageid, total);

		model.addAttribute("list", list);

		return "TableData";
	}

}
