package com.base.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.base.web.bean.User;
import com.base.web.controller.BaseController;
import com.base.web.dao.UserDao;
@Controller
public class RegisterController extends BaseController{
	private static final String register = "register";

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView(register);
	}
	@ResponseBody
	@RequestMapping(value = "register/submit", method = RequestMethod.POST)
	public Object register_submit(User user) {
		System.out.println(user.getUsername()+user.getUrole());
		Map<String, String> result = new HashMap<>();
		if (UserDao.insert(user)) {
			result.put("status", "success");
			result.put("message", "注册成功");
			return result;
		}else {
			result.put("status", "fail");
			result.put("message", "注册失败");
			return result;
		}
	}
}
