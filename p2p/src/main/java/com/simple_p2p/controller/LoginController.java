package com.simple_p2p.controller;

import com.simple_p2p.entity.*;
import com.simple_p2p.repository.ChatRepository;
import com.simple_p2p.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class LoginController {


	@Autowired
	private UserService userService;

	private UsersDao usersDao = new UsersDao();

	private ChatDao chatDao = new ChatDao();

	@Autowired
	private ChatRepository chatRepository;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}


	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}

	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		chatDao.getChats().clear();
		ModelAndView modelAndView = new ModelAndView();
		ChatForm chatForm = new ChatForm();
		chatDao.initData();
		modelAndView.addObject("chatForm", chatForm);
		ArrayList<Chats> list = chatDao.getChats();
		modelAndView.addObject("chats", list);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","You are logined! Hello test");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@RequestMapping(value = { "/settings" }, method = RequestMethod.GET)
	public String selectUsersOnline(Model model) {
		usersDao.getUsers().clear();
		PersonForm form = new PersonForm();
		usersDao.initData();
		model.addAttribute("personForm", form);
		model.addAttribute("chat", new Chat());
		ArrayList<Users> list = usersDao.getUsers();
		model.addAttribute("users", list);

		return "settings";
	}

	@RequestMapping(value="/admin/home", method=RequestMethod.POST)
	public ModelAndView creatingChatSubmit(@ModelAttribute Chat chat, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		chatDao.getChats().clear();
		model.addAttribute("chat", chat);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		chatDao.initData();
		ChatForm chatForm = new ChatForm();
		modelAndView.addObject("chatForm", chatForm);
		ArrayList<Chats> list = chatDao.getChats();
		modelAndView.addObject("chats", list);
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","You are created chat!");
		System.out.println(chat.getChatName());
		System.out.println(chat.getDescription());
        chatRepository.save(chat);
		modelAndView.setViewName("/admin/home");
		return modelAndView;
	}

	@RequestMapping(value={"/sharedchat"}, method = RequestMethod.GET)
	public ModelAndView sharedChat(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("chat");
		return modelAndView;
	}
}
