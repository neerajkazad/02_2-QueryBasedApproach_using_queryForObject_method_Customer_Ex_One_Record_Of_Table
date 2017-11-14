package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qa.bo.CustomerBo;

public class CustomerDao {
	private final String SQL_COUNT_NO_OF_CUSTOMER = "select count(1) from customer";
	private final String SQL_FIND_FIRST_NM_OF_CUSTOMER_BY_MOBILE = "select first_nm from customer where mobile = ?";
	private final String SQL_FIND_CUSTOMER_BY_NO = "select customer_no, first_nm, last_nm, mobile, email_address from customer where customer_no = ?";

	// select * from customer where customer_no = ?;

	private JdbcTemplate jdbcTemplate;

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getCountNoOfCustomer() {
		return jdbcTemplate.queryForInt(SQL_COUNT_NO_OF_CUSTOMER);
	}

	public String findCustomerFirstName(String mobile) {
		return jdbcTemplate.queryForObject(SQL_FIND_FIRST_NM_OF_CUSTOMER_BY_MOBILE, String.class,new Object[] { mobile });
	}

	private final class CustomerRowMapper implements RowMapper<CustomerBo> {

		@Override
		public CustomerBo mapRow(ResultSet rs, int row) throws SQLException {
			CustomerBo bo = null;
			bo = new CustomerBo();
			bo.setCustomerNo(rs.getInt(1));
			bo.setFirstName(rs.getString(2));
			bo.setLastName(rs.getString(3));
			bo.setMobile(rs.getString(4));
			bo.setEmailAddress(rs.getString(5));

			return bo;
		}

	}

	public CustomerBo findCustomer(int customerNo) {
		return jdbcTemplate.queryForObject(SQL_FIND_CUSTOMER_BY_NO, new CustomerRowMapper(),new Object[] { customerNo });
	}

}
