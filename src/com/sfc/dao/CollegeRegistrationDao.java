package com.sfc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sfc.bo.CollegeRegistrationBo;
import com.sfc.bo.CourseRegistrationBo;
import com.sun.corba.se.spi.orbutil.fsm.State;

@Repository
public class CollegeRegistrationDao {
	private final String SQL_COLLEGE_REGISTRATION = "insert into college_tbl(college_nm,university) values(?,?)";
	private final String SQL_COLLEGE_COURSE = "insert into course_tbl(course_nm,fee,collegeidfk) values(?,?,?) ";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * public CollegeRegistrationDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate
	 * = jdbcTemplate; }
	 */
	public int registerCollege(CollegeRegistrationBo crBo) {
		int result = 0;
		KeyHolder keyHolder = null;
		keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement(SQL_COLLEGE_REGISTRATION,
						new String[] { "college_id" });
				statement.setString(1, crBo.getCollegeName());
				statement.setString(2, crBo.getUniversity());
				return statement;
			}
		}, keyHolder);
		result = keyHolder.getKey().intValue();
		System.out.println("result  :" + result);
		return result;
	}

	public int courseInsert(CourseRegistrationBo courseRegistrationBo) {
		return jdbcTemplate.update(SQL_COLLEGE_COURSE, new Object[] { courseRegistrationBo.getCourse(),
				courseRegistrationBo.getFee(), courseRegistrationBo.getCollegeidfk() });

	}
}
