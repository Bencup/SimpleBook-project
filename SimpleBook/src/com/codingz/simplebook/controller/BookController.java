package com.codingz.simplebook.controller;
//import about images
import java.awt.Color;
import java.io.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.simplebook.dto.DataCover;
import com.codingz.simplebook.iservice.IBookService;
import com.codingz.simplebook.iservice.IBorrowService;
import com.codingz.simplebook.iservice.IStatusbService;
import com.codingz.simplebook.iservice.ITypeService;
import com.codingz.simplebook.iservice.IUserService;
import com.codingz.simplebook.model.Book;
import com.codingz.simplebook.model.Borrow;
import com.codingz.simplebook.model.Statusb;
import com.codingz.simplebook.model.Type;
import com.codingz.simplebook.model.User;
import com.codingz.simplebook.service.BookService;
import com.codingz.simplebook.service.BorrowService;
import com.codingz.simplebook.service.StatusbService;
import com.codingz.simplebook.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class BookController {

	@Autowired
	private IBookService bookService;
	@Autowired
	private ITypeService typeService;
	@Autowired
	private IBorrowService borrowService;
	@Autowired
	private IStatusbService statusbService;
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/book.html")
	public ModelAndView index() throws IOException{
		
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("book");

			// List<Member> memberList = memberService.findAll();
			List<Book> bookList = new ArrayList<Book>(bookService.findAll());
			List<Borrow> borrowList = new ArrayList<Borrow>(borrowService.findAll());
			
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userId", user.getId());
			System.out.println("What id +++"+user.getRole());			
			
			mav.addObject("bookList", bookList);
			mav.addObject("borrowList", borrowList);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/bookadmin.html")
	public ModelAndView adminbook() throws IOException{
		
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("bookadmin");

						
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userId", user.getId());
			System.out.println("What id +++"+user.getRole());			
			
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/createBook.html")
	public ModelAndView create() {
		try {
			ModelAndView model = new ModelAndView();
			model.setViewName("createBook");

			List<Type> typeList = new ArrayList<Type>(typeService.findAll());
			model.addObject("typeList",typeList);
			return model;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	@RequestMapping(value = "/savebook.html", method = RequestMethod.POST)
	public String save(Book book,
			@RequestParam(value="type_id") Long typeId,@RequestParam(value="statusb_id") Long statusbId,
			MultipartHttpServletRequest request)throws Exception {
			
		try {
			Type type = typeService.findById(typeId);
			book.setType(type);
			
			Statusb statusb = statusbService.findById(statusbId);
			book.setStatusb(statusb);
			
			/*String utf = new String (book.getBook_detail().getBytes(),"UTF-8");
			book.setBook_detail(utf);*/
			System.out.println(book.getBook_detail());
			
			bookService.save(book);
			/*typeService.save(type);*/
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String , MultipartFile> all_pic = request.getFileMap();
		MultipartFile pic_book =  all_pic.get("imgBook");
		String fileName = "";
		System.out.println("pic_book==="+pic_book.getOriginalFilename());
		if(pic_book != null){
			String [] content_type = pic_book.getContentType().split("/");
			System.out.println("img==="+content_type[1]);
			fileName = "Bimg-"+book.getId()+".png";
			
		     try {
//                 String imageName = u.getEmployeeCode() + "."+type[1];
                 String imagePath = "C:/Users/ITeam5/workspace/SimpleBook/WebContent/img/ImgBook/"+fileName;
                 byte[] bytes = pic_book.getBytes();
                 BufferedOutputStream stream = new BufferedOutputStream(
                         new FileOutputStream(new File(imagePath)));
                 stream.write(bytes);
                 stream.close();
             	return "redirect:/book.html";
             //    u.setPicPath(photoName);
             } catch (Exception e) {
                 e.printStackTrace();
             }
		}
		
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/deletebook.html", method = RequestMethod.POST)
	public String deleteBook(@RequestParam(value = "id") Long id) {
		try {
			Book book = bookService.findById(id);
			bookService.delete(book);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	@RequestMapping(value = "/showbook/{id}.html", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable(value = "id") Long id) {
		try {
			ModelAndView mav = new ModelAndView();
			Book book = bookService.findById(id);
			mav.addObject("book", book);
			mav.setViewName("showbook");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/edit_pagebook.html", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(value = "id") Long id) {
		try {
			ModelAndView mav = new ModelAndView();
			Book book = bookService.findById(id);
			mav.addObject("book", book);
			
			List<Type> typeList = new ArrayList<Type>(typeService.findAll());
			mav.addObject("typeList",typeList);

			// **add this here***
			mav.setViewName("editbook");

			// ***add this here***
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}

	@RequestMapping(value = "/editbook.html", method = RequestMethod.POST)
	public String editBook(Book book,@RequestParam(value="type_id") Long typeId,
			@RequestParam(value="statusb_id") Long statusbId ) {
		try {
			
			Type type = typeService.findById(typeId);
			book.setType(type);
			Statusb statusb = statusbService.findById(statusbId);
			book.setStatusb(statusb);
			
			
			bookService.update(book);
			return "redirect:/book.html";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/ableBook.html")
	public ModelAndView ableBook() {
		
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("ableBook");

			// List<Member> memberList = memberService.findAll();
			List<Book> bookList = new ArrayList<Book>(bookService.findAll());
			List<Borrow> borrowList = new ArrayList<Borrow>(borrowService.findAll());
			mav.addObject("bookList", bookList);
			mav.addObject("borrowList", borrowList);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/technologyBook.html")
	public ModelAndView technologyBook() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("technologyBook");
			List<Book> bookList = new ArrayList<Book>(bookService.findAll());
			List<Borrow> borrowList = new ArrayList<Borrow>(borrowService.findAll());			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userId", user.getId());
			mav.addObject("bookList", bookList);
			mav.addObject("borrowList", borrowList);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/margetingBook.html")
	public ModelAndView margetingBook() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("margetingBook");
			List<Book> bookList = new ArrayList<Book>(bookService.findAll());
			List<Borrow> borrowList = new ArrayList<Borrow>(borrowService.findAll());			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userId", user.getId());
			mav.addObject("bookList", bookList);
			mav.addObject("borrowList", borrowList);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/programmingBook.html")
	public ModelAndView programmingBook() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("programmingBook");
			List<Book> bookList = new ArrayList<Book>(bookService.findAll());
			List<Borrow> borrowList = new ArrayList<Borrow>(borrowService.findAll());			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userId", user.getId());
			mav.addObject("bookList", bookList);
			mav.addObject("borrowList", borrowList);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/languageBook.html")
	public ModelAndView languageBook() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("languageBook");
			List<Book> bookList = new ArrayList<Book>(bookService.findAll());
			List<Borrow> borrowList = new ArrayList<Borrow>(borrowService.findAll());			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			mav.addObject("userId", user.getId());
			mav.addObject("bookList", bookList);
			mav.addObject("borrowList", borrowList);
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//headers="Accept=*/*"
	@ResponseBody
	@RequestMapping(value="/testshow.html",method=RequestMethod.GET)
	public String filldataBook() throws Exception {
		
		
		List<Book> bookList = new ArrayList<Book>(bookService.findAll());
		
		DataCover<Book> cover = new DataCover<Book>();
		System.out.println("test==="+cover);
		cover.setRecordsFiltered(bookList.size());
		cover.setData(bookList);		
		ObjectWriter ob = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		System.out.println(ob.writeValueAsString(cover));
		return ob.writeValueAsString(cover);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/showProgramming.html",method=RequestMethod.GET)
	public String filldataProgramming() throws Exception {
		
		
		List<Book> bookList = new ArrayList<Book>(bookService.findAll());
		List<Book> programmigList = new ArrayList<Book>();
		for(Book book : bookList) {
			if(book.getType().getId()==1){
				programmigList.add(book);
			}
			
		}
		DataCover<Book> cover = new DataCover<Book>();
		cover.setRecordsFiltered(programmigList.size());
		cover.setData(programmigList);
		ObjectWriter ob = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		return ob.writeValueAsString(cover);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/showBusiness.html",method=RequestMethod.GET)
	public String filldataBusiess() throws Exception {
		
		
		List<Book> bookList = new ArrayList<Book>(bookService.findAll());
		List<Book> BList = new ArrayList<Book>();
		for(Book book : bookList) {
			if(book.getType().getId()==3){
				BList.add(book);
			}
			
		}
		DataCover<Book> cover = new DataCover<Book>();
		cover.setRecordsFiltered(BList.size());
		cover.setData(BList);
		ObjectWriter ob = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		return ob.writeValueAsString(cover);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/showLang.html",method=RequestMethod.GET)
	public String filldataLang() throws Exception {
		
		
		List<Book> bookList = new ArrayList<Book>(bookService.findAll());
		List<Book> BList = new ArrayList<Book>();
		for(Book book : bookList) {
			if(book.getType().getId()==4){
				BList.add(book);
			}
			
		}
		DataCover<Book> cover = new DataCover<Book>();
		cover.setRecordsFiltered(BList.size());
		cover.setData(BList);
		ObjectWriter ob = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		return ob.writeValueAsString(cover);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/showInspi.html",method=RequestMethod.GET)
	public String filldataInspi() throws Exception {
		
		
		List<Book> bookList = new ArrayList<Book>(bookService.findAll());
		List<Book> BList = new ArrayList<Book>();
		for(Book book : bookList) {
			if(book.getType().getId()==2){
				BList.add(book);
			}
			
		}
		DataCover<Book> cover = new DataCover<Book>();
		cover.setRecordsFiltered(BList.size());
		cover.setData(BList);
		ObjectWriter ob = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		return ob.writeValueAsString(cover);
		
	}

}
