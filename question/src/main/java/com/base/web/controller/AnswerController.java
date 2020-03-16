package com.base.web.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.base.web.bean.Answer;
import com.base.web.bean.Question;
import com.base.web.dao.AnswerDao;
import com.base.web.dao.QuestionDao;

@Controller
public class AnswerController extends BaseController {
	@RequestMapping(value = "answer_question", method = RequestMethod.GET)
	public ModelAndView answerQuestion(String id) {
		ModelAndView mv = null;
		if (id == null || "".equals(id)) {
			System.err.println("id不能为空");
			mv = new ModelAndView("fail");
			return mv;
		}
		Question question = QuestionDao.FindOne(Integer.valueOf(id));
		if (question == null) {
			System.err.println("没有找到此问题，id=" + id);
			mv = new ModelAndView("fail");
			return mv;
		}
		mv = new ModelAndView("answer");
		mv.addObject("question", question);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "answer/submit", method = RequestMethod.POST)
	public Object submit(Answer an) {
		Map<String, String> result = new HashMap<>();
		boolean in_isSuccess = AnswerDao.insert(an);
		if (!in_isSuccess) {
			result.put("status", "fail");
			result.put("message", "sumbit fail");
			return result;
		}
		result.put("status", "success");
		result.put("message", "sumbit success");
		return result;
	}

	@RequestMapping(value = "answer_count", method = RequestMethod.GET)
	public ModelAndView answer_count(String qid) {
		ModelAndView mv = null;
		if (qid == null || "".equals(qid)) {
			System.err.println("qid不能为空");
			mv = new ModelAndView("fail");
			return mv;
		}
		Question question = QuestionDao.FindOne(Integer.valueOf(qid));
		if (question == null) {
			System.err.println("没有找到此问题，id=" + qid);
			mv = new ModelAndView("fail");
			return mv;
		}
		List<Answer> answers = AnswerDao.queryALLByQIdSQL(Integer.valueOf(qid));
		if (answers == null || answers.size() == 0) {
			System.err.println("没有找到此问题结果，id=" + qid);
			mv = new ModelAndView("fail");
			return mv;
		}
		// 初始化问题选项
		// 问题， 答案， 票数
		Map<String, Map<String, Integer>> result = new LinkedHashMap<>();
		Map<String, Integer> re = new LinkedHashMap<>();
		if ("0".equals(question.getCol1_type())) {
			String[] ans = question.getCol1_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol1(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol2_type())) {
			String[] ans = question.getCol2_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol2(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol3_type())) {
			String[] ans = question.getCol3_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol3(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol4_type())) {
			String[] ans = question.getCol4_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol4(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol5_type())) {
			String[] ans = question.getCol5_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol5(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol6_type())) {
			String[] ans = question.getCol6_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol6(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol7_type())) {
			String[] ans = question.getCol7_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol7(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol8_type())) {
			String[] ans = question.getCol8_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol8(), re);

		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol9_type())) {
			String[] ans = question.getCol9_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol9(), re);
		
		re = new LinkedHashMap<>();
		if ("0".equals(question.getCol10_type())) {
			String[] ans = question.getCol10_answer().split("\\|\\|\\|");
			for (String ss : ans) {
				re.put(ss, new Integer(0));
			}
		}
		result.put(question.getCol10(), re);

		// 开始计算
		for (Answer an : answers) {
			if ("0".equals(question.getCol1_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol1());
				Integer in = dupMap.get(an.getCol1());
				in++;
				dupMap.put(an.getCol1(), in);
			} else {
				result.get(question.getCol1()).put(an.getCol1_answer(), 0);
			}

			if ("0".equals(question.getCol2_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol2());
				Integer in = dupMap.get(an.getCol2());
				in++;
				dupMap.put(an.getCol2(), in);
			} else {
				result.get(question.getCol2()).put(an.getCol2_answer(), 0);
			}

			if ("0".equals(question.getCol3_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol3());
				Integer in = dupMap.get(an.getCol3());
				in++;
				dupMap.put(an.getCol3(), in);
			} else {
				result.get(question.getCol3()).put(an.getCol3_answer(), 0);
			}

			if ("0".equals(question.getCol4_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol4());
				Integer in = dupMap.get(an.getCol4());
				in++;
				dupMap.put(an.getCol4(), in);
			} else {
				result.get(question.getCol4()).put(an.getCol4_answer(), 0);
			}

			if ("0".equals(question.getCol5_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol5());
				Integer in = dupMap.get(an.getCol5());
				in++;
				dupMap.put(an.getCol5(), in);
			} else {
				result.get(question.getCol5()).put(an.getCol5_answer(), 0);
			}

			if ("0".equals(question.getCol6_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol6());
				Integer in = dupMap.get(an.getCol6());
				in++;
				dupMap.put(an.getCol6(), in);
			} else {
				result.get(question.getCol6()).put(an.getCol6_answer(), 0);
			}

			if ("0".equals(question.getCol7_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol7());
				Integer in = dupMap.get(an.getCol7());
				in++;
				dupMap.put(an.getCol7(), in);
			} else {
				result.get(question.getCol7()).put(an.getCol7_answer(), 0);
			}

			if ("0".equals(question.getCol8_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol8());
				Integer in = dupMap.get(an.getCol8());
				in++;
				dupMap.put(an.getCol8(), in);
			} else {
				result.get(question.getCol8()).put(an.getCol8_answer(), 0);
			}

			if ("0".equals(question.getCol9_type())) {
				Map<String, Integer> dupMap = result.get(question.getCol9());
				Integer in = dupMap.get(an.getCol9());
				in++;
				dupMap.put(an.getCol9(), in);
			} else {
				result.get(question.getCol9()).put(an.getCol9_answer(), 0);
			}

			if ("0".equals(question.getCol10_type())) {
				Integer in = result.get(question.getCol10()).get(an.getCol10());
				in++;
				result.get(question.getCol10()).put(an.getCol10(), in);
			} else {
				result.get(question.getCol10()).put(an.getCol10_answer(), 0);
			}
		}
//		NumberFormat nf = NumberFormat.getInstance();
//		nf.setMaximumFractionDigits(2);
//		System.out.println(nf.format(12.125f));
		mv = new ModelAndView("answer_result");
		mv.addObject("answers", result);
		mv.addObject("name", question.getName());
		return mv;
	}
}
