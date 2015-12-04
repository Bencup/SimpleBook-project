package com.codingz.simplebook.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codingz.simplebook.iservice.IRoleService;
import com.codingz.simplebook.iservice.IUserService;
import com.codingz.simplebook.model.Book;
import com.codingz.simplebook.model.Role;
import com.codingz.simplebook.model.Type;
import com.codingz.simplebook.model.User;
import com.codingz.simplemember.model.Member;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = "/user.html")
	public ModelAndView index() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user");

			List<User> userList = new ArrayList<User>(userService.findAll());
			/*Set<User> userList = new HashSet<User>(userService.findAll());*/
			mav.addObject("userList", userList);

			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/createUser.html")
	public ModelAndView create() {
		try{
		ModelAndView model = new ModelAndView();
		model.setViewName("createUser");
		
		Set<Role> roleList = new HashSet<Role>(roleService.findAll());
		model.addObject("roleList", roleList);
			
		return model;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/saveuser.html", method = RequestMethod.POST)
	public String save(User user,@RequestParam(value = "role_id") Long roleId ){
			
		try {
			Role role = roleService.findById(roleId);
			user.setRole(role);
			
			userService.save(user);
			return "redirect:/login.html";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/edit_pageuser.html", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(value = "id") Long id) {
		try {
			ModelAndView mav = new ModelAndView();
			User user = userService.findById(id);
			mav.addObject("user", user);

			mav.setViewName("editUser");

			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/editUser.html", method = RequestMethod.POST)
	public String editUser(User user,@RequestParam(value = "role_id") Long roleId,
			@RequestParam String username) {
		try {
			Role role = roleService.findById(roleId);
			user.setRole(role);
			user.setUsername(username);
			userService.update(user);
			return "redirect:/DetailUserLog.html";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteuser.html", method = RequestMethod.POST)
	public String deleteBook(@RequestParam(value = "id") Long id) {
		try {
			User user = userService.findById(id);
			userService.delete(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	
	@RequestMapping(value = "/showUser/{id}.html", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable(value = "id") Long id) {
		try {
			ModelAndView mav = new ModelAndView();
			User user  = userService.findById(id);
			mav.addObject("user", user);
			mav.setViewName("showUser");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/DetailUserLog.html")
	public ModelAndView DetailUser() {
		try {
			ModelAndView model = new ModelAndView();
			model.setViewName("DetailUserLog");
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   	String name =auth.getName();
		   	
		   	User user = userService.findByUsername(name);
			System.out.println("Name == "+user);
		  	
			model.addObject("username",user.getUsername());
		  	model.addObject("userId", user.getId());
		  	model.addObject("userFirstName", user.getFirstname());
		  	model.addObject("userLastName", user.getLastname());
		   
			return model;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
