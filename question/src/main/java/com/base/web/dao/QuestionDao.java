package com.base.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.base.web.bean.Question;

public class QuestionDao {
	private static final String insertSQL = "INSERT INTO `online`.`question`(`col1`,`col1_type`,`col1_answer`,`col2`,`col2_type`,`col2_answer`,`col3`,`col3_type`,`col3_answer`,`col4`,`col4_type`,`col4_answer`,`col5`,`col5_type`,`col5_answer`,`col6`,`col6_type`,`col6_answer`,`col7`,`col7_type`,`col7_answer`,`col8`,`col8_type`,`col8_answer`,`col9`,`col9_type`,`col9_answer`,`col10`,`col10_type`,`col10_answer`,`name`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	private static final String queryOneSQL = "SELECT * FROM QUESTION WHERE id = ?;";
	private static final String queryALLSQL = "SELECT * FROM QUESTION;";

	// 添加
	public static boolean insert(Question qu) {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DBUtils.getConnection();
			stm = con.prepareStatement(insertSQL);
			stm.setString(1, qu.getCol1());
			stm.setString(2, qu.getCol1_type());
			stm.setString(3, qu.getCol1_answer());
			stm.setString(4, qu.getCol2());
			stm.setString(5, qu.getCol2_type());
			stm.setString(6, qu.getCol2_answer());
			stm.setString(7, qu.getCol3());
			stm.setString(8, qu.getCol3_type());
			stm.setString(9, qu.getCol3_answer());
			stm.setString(10, qu.getCol4());
			stm.setString(11, qu.getCol4_type());
			stm.setString(12, qu.getCol4_answer());
			stm.setString(13, qu.getCol5());
			stm.setString(14, qu.getCol5_type());
			stm.setString(15, qu.getCol5_answer());
			stm.setString(16, qu.getCol6());
			stm.setString(17, qu.getCol6_type());
			stm.setString(18, qu.getCol6_answer());
			stm.setString(19, qu.getCol7());
			stm.setString(20, qu.getCol7_type());
			stm.setString(21, qu.getCol7_answer());
			stm.setString(22, qu.getCol8());
			stm.setString(23, qu.getCol8_type());
			stm.setString(24, qu.getCol8_answer());
			stm.setString(25, qu.getCol9());
			stm.setString(26, qu.getCol9_type());
			stm.setString(27, qu.getCol9_answer());
			stm.setString(28, qu.getCol10());
			stm.setString(29, qu.getCol10_type());
			stm.setString(30, qu.getCol10_answer());
			stm.setString(31, qu.getName());
			stm.execute();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return false;
	}

	// 查询
	public static Question FindOne(int id) {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Question question = null;
		try {
			con = DBUtils.getConnection();
			stm = con.prepareStatement(queryOneSQL);
			stm.setInt(1, id);
			ResultSet result = stm.executeQuery();
			if (result != null) {
				if (result.next()) {
					question = new Question();
					question.setId(result.getInt("id"));
					question.setName(result.getString("name"));
					question.setCol1(result.getString("col1"));
					question.setCol1_type(result.getString("col1_type"));
					question.setCol1_answer(result.getString("col1_answer"));
					question.setCol2(result.getString("col2"));
					question.setCol2_type(result.getString("col2_type"));
					question.setCol2_answer(result.getString("col2_answer"));
					question.setCol3(result.getString("col3"));
					question.setCol3_type(result.getString("col3_type"));
					question.setCol3_answer(result.getString("col3_answer"));
					question.setCol4(result.getString("col4"));
					question.setCol4_type(result.getString("col4_type"));
					question.setCol4_answer(result.getString("col4_answer"));
					question.setCol5(result.getString("col5"));
					question.setCol5_type(result.getString("col5_type"));
					question.setCol5_answer(result.getString("col5_answer"));
					question.setCol6(result.getString("col6"));
					question.setCol6_type(result.getString("col6_type"));
					question.setCol6_answer(result.getString("col6_answer"));
					question.setCol7(result.getString("col7"));
					question.setCol7_type(result.getString("col7_type"));
					question.setCol7_answer(result.getString("col7_answer"));
					question.setCol8(result.getString("col8"));
					question.setCol8_type(result.getString("col8_type"));
					question.setCol8_answer(result.getString("col8_answer"));
					question.setCol9(result.getString("col9"));
					question.setCol9_type(result.getString("col9_type"));
					question.setCol9_answer(result.getString("col9_answer"));
					question.setCol10(result.getString("col10"));
					question.setCol10_type(result.getString("col10_type"));
					question.setCol10_answer(result.getString("col10_answer"));
					return question;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return question;
	}

	// 查询所有
	public static List<Question> FindAll() {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Question> questions = null;
		try {
			con = DBUtils.getConnection();
			stm = con.prepareStatement(queryALLSQL);
			ResultSet result = stm.executeQuery();
			if (result == null) {
				return null;
			}
			questions = new ArrayList<>();
			while (result.next()) {
				Question question = new Question();
				question.setId(result.getInt("id"));
				question.setName(result.getString("name"));
				question.setCol1(result.getString("col1"));
				question.setCol1_type(result.getString("col1_type"));
				question.setCol1_answer(result.getString("col1_answer"));
				question.setCol2(result.getString("col2"));
				question.setCol2_type(result.getString("col2_type"));
				question.setCol2_answer(result.getString("col2_answer"));
				question.setCol3(result.getString("col3"));
				question.setCol3_type(result.getString("col3_type"));
				question.setCol3_answer(result.getString("col3_answer"));
				question.setCol4(result.getString("col4"));
				question.setCol4_type(result.getString("col4_type"));
				question.setCol4_answer(result.getString("col4_answer"));
				question.setCol5(result.getString("col5"));
				question.setCol5_type(result.getString("col5_type"));
				question.setCol5_answer(result.getString("col5_answer"));
				question.setCol6(result.getString("col6"));
				question.setCol6_type(result.getString("col6_type"));
				question.setCol6_answer(result.getString("col6_answer"));
				question.setCol7(result.getString("col7"));
				question.setCol7_type(result.getString("col7_type"));
				question.setCol7_answer(result.getString("col7_answer"));
				question.setCol8(result.getString("col8"));
				question.setCol8_type(result.getString("col8_type"));
				question.setCol8_answer(result.getString("col8_answer"));
				question.setCol9(result.getString("col9"));
				question.setCol9_type(result.getString("col9_type"));
				question.setCol9_answer(result.getString("col9_answer"));
				question.setCol10(result.getString("col10"));
				question.setCol10_type(result.getString("col10_type"));
				question.setCol10_answer(result.getString("col10_answer"));
				questions.add(question);
			}
			return questions;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return questions;
	}
}
