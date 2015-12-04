package com.codingz.simplebook.controller;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.simplebook.iservice.IBookService;
import com.codingz.simplebook.iservice.IBorrowService;
import com.codingz.simplebook.iservice.IStatusbService;
import com.codingz.simplebook.iservice.IUserService;
import com.codingz.simplebook.model.Book;
import com.codingz.simplebook.model.Borrow;
import com.codingz.simplebook.model.BorrowForm;
import com.codingz.simplebook.model.Statusb;
import com.codingz.simplebook.model.User;
import com.codingz.simplebook.service.BorrowService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class BorrowController {

	@Autowired
	private IBorrowService borrowService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IBookService bookService;
	@Autowired
	private IStatusbService statusbService;

	@RequestMapping(value = "/borrow.html")
	public ModelAndView index() {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("borrow");

			List<Borrow> borrowList = new ArrayList<Borrow>(
					borrowService.findAll());
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			System.out.println("Youuu== " + name);
			User user = userService.findByUsername(name);

			// mav.addObject("borrowListFindUser", borrowListFindUser);
			mav.addObject("borrowList", borrowList);
			mav.addObject("userId", user.getId());

			/*
			 * Date dateB = borrowList.get(0).getDate_borrow(); Date dateL =
			 * borrowList.get(0).getDate_limit(); Date dateR =
			 * borrowList.get(0).getDate_return(); long dateBor =
			 * dateR.getTime()-dateB.getTime();
			 * System.out.println("he===="+dateBor/(24*60*60*1000));
			 */

			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/createBorrow.html")
	public ModelAndView create(Book book) {
		try {
			ModelAndView model = new ModelAndView();
			model.setViewName("createBorrow");

			Book bookname = bookService.findById(book.getId());

			model.addObject("book", book);
			model.addObject("bookname", bookname);

			List<User> userList = new ArrayList<User>(userService.findAll());
			model.addObject("userList", userList);

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			User user = userService.findByUsername(name);
			model.addObject("username", user.getUsername());
			model.addObject("userId", user.getId());

			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/saveborrow.html", method = RequestMethod.POST)
	public String save(Borrow borrow,
			@RequestParam(value = "book_id") Long bookId,
			@RequestParam(value = "statusb_id") Long statusbId,
			@RequestParam(value = "user_id") Long userId,
			@ModelAttribute(value = "borrowForm") BorrowForm borrowForm) {
		try {
			Book book = bookService.findById(bookId);
			Statusb statusb = statusbService.findById(statusbId);
			User user = userService.findById(userId);
			borrow.setBook(book);
			borrow.setStatusb(statusb);
			borrow.setUser(user);

			Date dateLimit = new Date();
			long dLimit = dateLimit.getTime();
			dLimit += 7 * 24 * 60 * 60 * 1000L;
			dateLimit.setTime(dLimit);

			book.setStatusb(statusb);
			borrow.setDate_borrow(new Date());
			borrow.setDate_limit(dateLimit);
			bookService.update(book);
			borrowService.save(borrow);

			return "redirect:/borrowOfUser.html";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/returnB.html", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(value = "id") Long id) {
		try {
			ModelAndView mav = new ModelAndView();
			Borrow borrow = borrowService.findById(id);

			List<Book> bookList = new ArrayList<Book>(bookService.findAll());
			mav.addObject("borrow", borrow);
			mav.addObject("bookList", bookList);
			mav.setViewName("returnB");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/editBorrow.html", method = RequestMethod.POST)
	public String editBorrow(
			@ModelAttribute(value = "borrowForm") BorrowForm borrowForm,
			@RequestParam(value = "book_id") Long bookId,
			@RequestParam(value = "statusb_id") Long statusbId,
			@RequestParam(value = "user_id") Long userId) {
		try {
			// System.out.print("borrowForm :: " + borrowForm);
			Book book = bookService.findById(bookId);
			Borrow borrow = borrowService.findById(borrowForm.getId());

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date borrowDate = null, limitDate = null;
			try {
				borrowDate = df.parse(borrowForm.getDateBorrow());
				limitDate = df.parse(borrowForm.getDateLimit());

			} catch (ParseException e) {
				e.printStackTrace();
			}

			borrow.setDate_return(new Date());

			System.out.print("borrowForm :: " + borrowForm);

			Statusb statusb = statusbService.findById(statusbId);
			borrow.setStatusb(statusb);
			User user = userService.findById(userId);
			// borrow.setUser(user);
			book.setStatusb(statusb);

			Date dateB = borrow.getDate_borrow();
			Date dateR = borrow.getDate_return();
			long dateBor = dateR.getTime() - dateB.getTime();
			long dateBB = dateBor/(24 * 60 * 60 * 1000);
			System.out.println("heeeee=====" + dateBB);

			if (dateBB < 7) {
				int money = 0;
				borrow.setFine(money);
			} else if (dateBB > 7) {
				int money = 5;
				borrow.setFine(money);
			}

			borrowService.update(borrow);
			bookService.update(book);
			return "redirect:/borrowOfUser.html";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/showBorrow/{id}.html", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable(value = "id") Long id) {
		try {
			ModelAndView mav = new ModelAndView();
			Borrow borrow = borrowService.findById(id);
			mav.addObject("borrow", borrow);
			mav.setViewName("showBorrow");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/borrowedBook.html")
	public ModelAndView borrowedBook() {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("borrowedBook");

			List<Borrow> borrowList = new ArrayList<Borrow>(
					borrowService.findAll());

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			System.out.println("Youuu== " + name);
			User user = userService.findByUsername(name);

			mav.addObject("borrowList", borrowList);
			mav.addObject("userId", user.getId());
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/borrowOfUser.html")
	public ModelAndView borrowOfUser() {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("borrowOfUser");

			List<Borrow> borrowList = new ArrayList<Borrow>(
					borrowService.findAll());

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			System.out.println("Youuu== " + name);
			User user = userService.findByUsername(name);

			// mav.addObject("borrowListFindUser", borrowListFindUser);
			mav.addObject("borrowList", borrowList);
			mav.addObject("userId", user.getId());
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/borrowOfUserReturn.html")
	public ModelAndView borrowOfUserReturn() {

		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("borrowOfUserReturn");

			List<Borrow> borrowList = new ArrayList<Borrow>(
					borrowService.findAll());

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			System.out.println("Youuu== " + name);
			User user = userService.findByUsername(name);

			// mav.addObject("borrowListFindUser", borrowListFindUser);
			mav.addObject("borrowList", borrowList);
			mav.addObject("userId", user.getId());
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
