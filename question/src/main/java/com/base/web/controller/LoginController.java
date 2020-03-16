package com.base.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.base.web.dao.*;
import com.base.web.bean.Question;
import com.base.web.bean.UpRole;
import com.base.web.bean.Uppwad;
import com.base.web.bean.User;
import com.base.web.bean.Deluser;
import com.base.web.controller.BaseController;

@Controller
public class LoginController extends BaseController {

	private static final String login = "login";
	private static final String userHome = "userHome";
	private static final String adminHome = "adminHome";

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView(login);
	}
	
	
	@RequestMapping(value = "userHome", method = RequestMethod.GET)
	public ModelAndView user_login() {
		return new ModelAndView(userHome);
	}
	
	
	@RequestMapping(value = "updatepwad", method = RequestMethod.GET)
	public ModelAndView updatepwad() {
		ModelAndView mv=new ModelAndView("updatepwad");
		//mv.addObject("user", user);
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "updatepwad/submit", method = RequestMethod.POST)
	public Object updatepwad_submit(Uppwad up) {
		Map<String, String> result = new HashMap<>();
		if(!up.getNewpassword().equals(up.getNewpassword1())) {
			result.put("status", "fail");
			result.put("message", "更改失败");
			return result;
		}else {
			if(UserDao.uppwad(up)) {
				result.put("status", "success");
				result.put("message", "更改成功");
				return result;
			}
			else {
				result.put("status", "fail");
				result.put("message", "更改失败");
				return result;
			}
		}
	}
	@ResponseBody
	@RequestMapping(value = "deluser/submit", method = RequestMethod.POST)
	public Object deluser_submit(Deluser de) {
		Map<String, String> result = new HashMap<>();
		if("".equals(de.getUsername())) {
			result.put("status", "fail");
			result.put("message", "不能为空");
			return result;
		}	
		if(UserDao.del(de)) {
				result.put("status", "success");
				result.put("message", "删除成功");
				return result;
			}
			else {
				result.put("status", "fail");
				result.put("message", "删除失败");
				return result;
			}
		}
	
	@ResponseBody
	@RequestMapping(value = "setrole/submit", method = RequestMethod.POST)
	public Object setrole_submit(UpRole up) {
		Map<String, String> result = new HashMap<>();
		if("".equals(up.getUsername())) {
			result.put("status", "fail");
			result.put("message", "不能为空");
			return result;
		}	
		if(UserDao.setRole(up)) {
				result.put("status", "success");
				result.put("message", "设置成功");
				return result;
			}
			else {
				result.put("status", "fail");
				result.put("message", "设置失败");
				return result;
			}
		}
	@RequestMapping(value = "adminHome", method = RequestMethod.GET)
	public ModelAndView admin_login() {
		ModelAndView mv=new ModelAndView(adminHome);
		//mv.addObject("user", user);
		return mv;
	}
	@RequestMapping(value = "deluser", method = RequestMethod.GET)
	public ModelAndView del_user() {
		ModelAndView mv=new ModelAndView("deluser");
		//mv.addObject("user", user);
		return mv;
	}
	@RequestMapping(value = "setrole", method = RequestMethod.GET)
	public ModelAndView setrole() {
		ModelAndView mv=new ModelAndView("setrole");
		//mv.addObject("user", user);
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "logincheck", method = RequestMethod.POST)
	public Object loginCheck(User user) {
		System.out.println(user.getUsername()+user.getUrole());
		Map<String, String> result = new HashMap<>();
		if ("".equals(user.getUsername())) {
			result.put("status", "fail");
			result.put("message", "用户名不能为空");
			return result;
		}
		else if(UserDao.check(user.getUsername(),user.getPassword(),user.getUrole())) {
			if("0".equals(user.getUrole())) {
				result.put("status", "success");
				//result.put("message", "登陆成功");
				//result.put("status", "role");
				result.put("message", "0");
				return result;
			}else {
				//result.put("status", "role");
				result.put("message", "1");
				return result;
			}
			}
			else {
				result.put("status", "fail");
				result.put("message", "用户名或密码错误");
				return result;
			} 
	}
	
}
