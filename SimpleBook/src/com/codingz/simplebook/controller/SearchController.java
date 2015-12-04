package com.codingz.simplebook.controller;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.codingz.simplebook.iservice.IUserService;

@Controller
public class SearchController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/search.html")
	public ModelAndView Search(@RequestParam(value = "searchTerm", required = false) 
	 String pSearchTerm, HttpServletRequest request, HttpServletResponse response) throws Exception {
	   ModelAndView mav = new ModelAndView("search");

	   mav.addObject("searchTerm", pSearchTerm);
	   mav.addObject("searchResult", userService.findByUsername(pSearchTerm));      

	   return mav;
	  }
	
}
