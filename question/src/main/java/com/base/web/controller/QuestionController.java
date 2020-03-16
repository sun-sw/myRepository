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

import com.base.web.bean.Question;
import com.base.web.dao.QuestionDao;

@Controller
public class QuestionController extends BaseController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		List<Question> result = QuestionDao.FindAll();
		if (result == null) {
			result = new ArrayList<>();
		}
		mv.addObject("questions", result);
		return mv;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		List<Question> result = QuestionDao.FindAll();
		if (result == null) {
			result = new ArrayList<>();
		}
		mv.addObject("questions", result);
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("question");
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "question/submit", method = RequestMethod.POST)
	public Object submit(Question qu) {
		Map<String, String> result = new HashMap<>();
		if ("".equals(qu.getName())) {
			result.put("status", "fail");
			result.put("message", "名称不能为空");
			return result;
		}
		boolean in_isSuccess = QuestionDao.insert(qu);
		if (!in_isSuccess) {
			result.put("status", "fail");
			result.put("message", "sumbit fail");
			return result;
		}
		result.put("status", "success");
		result.put("message", "sumbit success");
		return result;
	}

	@RequestMapping(value = "question/success", method = RequestMethod.GET)
	public ModelAndView success() {
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}

}
