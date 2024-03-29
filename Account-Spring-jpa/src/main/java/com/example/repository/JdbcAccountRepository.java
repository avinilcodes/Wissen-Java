package com.example.repository;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.Txn;

@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {
	private static final Logger LOGGER = Logger.getLogger("App");
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		LOGGER.info("JdbcAccountRepository is created with data source");
	}

	@Override
	public Account load(String accNum) {
		LOGGER.info("loading account " + accNum);
		String sql = "select * from ACCOUNTS where num=?";
		Account account = new Account();
		jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			account.setAccNum(rs.getString("num"));
			account.setBalance(rs.getDouble("balance"));
			return account;
		}, accNum);
		return account;

	}

	@Override
	public Account update(Account account) {
		LOGGER.info("updating account ");
		String sql = "update ACCOUNTS set balance=? where num=?";
		int rowCount = jdbcTemplate.update(sql, account.getBalance(), account.getAccNum());
		return account;
	}

	@Override
	public void save(Txn txn) {
		String sql = "insert into txns(id,amount,closingbalance,datetime,type,num) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, txn.getId(), txn.getAmount(), txn.getClosingBalance(),
				Timestamp.valueOf(txn.getLocalDateTime()), txn.getType().name(), txn.getAccount().getAccNum());

	}

}
