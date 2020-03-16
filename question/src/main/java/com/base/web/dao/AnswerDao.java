package com.base.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.base.web.bean.Answer;

public class AnswerDao {
	private static final String insertSQL = "INSERT INTO `online`.`answer`(`q_id`,`col1`,`col1_answer`,`col2`,`col2_answer`,`col3`,`col3_answer`,`col4`,`col4_answer`,`col5`,`col5_answer`,`col6`,`col6_answer`,`col7`,`col7_answer`,`col8`,`col8_answer`,`col9`,`col9_answer`,`col10`,`col10_answer`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	private static final String queryALLByQIdSQL = "SELECT * FROM answer WHERE q_id = ?";

	// 添加
	public static boolean insert(Answer an) {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DBUtils.getConnection();
			stm = con.prepareStatement(insertSQL);
			stm.setInt(1, an.getQ_id());
			stm.setString(2, an.getCol1());
			stm.setString(3, an.getCol1_answer());
			stm.setString(4, an.getCol2());
			stm.setString(5, an.getCol2_answer());
			stm.setString(6, an.getCol3());
			stm.setString(7, an.getCol3_answer());
			stm.setString(8, an.getCol4());
			stm.setString(9, an.getCol4_answer());
			stm.setString(10, an.getCol5());
			stm.setString(11, an.getCol5_answer());
			stm.setString(12, an.getCol6());
			stm.setString(13, an.getCol6_answer());
			stm.setString(14, an.getCol7());
			stm.setString(15, an.getCol7_answer());
			stm.setString(16, an.getCol8());
			stm.setString(17, an.getCol8_answer());
			stm.setString(18, an.getCol9());
			stm.setString(19, an.getCol9_answer());
			stm.setString(20, an.getCol10());
			stm.setString(21, an.getCol10_answer());
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return false;
	}

	// 查询所有
	public static List<Answer> queryALLByQIdSQL(int qid) {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Answer> answers = null;
		try {
			con = DBUtils.getConnection();
			stm = con.prepareStatement(queryALLByQIdSQL);
			stm.setInt(1, qid);
			ResultSet result = stm.executeQuery();
			if (result == null) {
				return null;
			}
			answers = new ArrayList<>();
			while (result.next()) {
				Answer answer = new Answer();
				answer.setId(result.getInt("id"));
				answer.setQ_id(result.getInt("q_id"));
				answer.setCol1(result.getString("col1"));
				answer.setCol1_answer(result.getString("col1_answer"));
				answer.setCol2(result.getString("col2"));
				answer.setCol2_answer(result.getString("col2_answer"));
				answer.setCol3(result.getString("col3"));
				answer.setCol3_answer(result.getString("col3_answer"));
				answer.setCol4(result.getString("col4"));
				answer.setCol4_answer(result.getString("col4_answer"));
				answer.setCol5(result.getString("col5"));
				answer.setCol5_answer(result.getString("col5_answer"));
				answer.setCol6(result.getString("col6"));
				answer.setCol6_answer(result.getString("col6_answer"));
				answer.setCol7(result.getString("col7"));
				answer.setCol7_answer(result.getString("col7_answer"));
				answer.setCol8(result.getString("col8"));
				answer.setCol8_answer(result.getString("col8_answer"));
				answer.setCol9(result.getString("col9"));
				answer.setCol9_answer(result.getString("col9_answer"));
				answer.setCol10(result.getString("col10"));
				answer.setCol10_answer(result.getString("col10_answer"));
				answers.add(answer);
			}
			return answers;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			DBUtils.release(rs, stm, con);
		}
		return answers;
	}
}
