package com.example.service;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.model.Txn;
import com.example.model.TxnType;
import com.example.repository.AccountRepository;
import com.example.repository.TxnRepository;

@Service("txrService")
public class TxrServiceImpl implements TxrService {

	private static final Logger LOGGER = Logger.getLogger("App");
	@Autowired
	private TxnRepository txnRepository;
	
	private AccountRepository accountRepository;

	private String txrType="NEFT";

	public TxrServiceImpl() {
		LOGGER.info("TxrServiceImpl created");
	}
	
	
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	public void setTxrType(String txrType) {
		this.txrType = txrType;
	}

	@PostConstruct
	public void init() {
		LOGGER.info("TxrService :: init()");
		if (txrType.isEmpty())
			this.txrType = "NEFT";
	}

	public String getTxrType() {
		return txrType;
	}
	@Transactional//jpa transactionmanager
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		LOGGER.info("Txr initiated");

		Account fromAccount = accountRepository.findById(fromAccNum).get();
		Account toAccount = accountRepository.findById(toAccNum).get();

		
		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		
		Txn debitTxn=new Txn();
		debitTxn.setAccount(fromAccount);
		debitTxn.setAmount(amount);
		debitTxn.setClosingBalance(fromAccount.getBalance());
		debitTxn.setType(TxnType.DEBIT);
		debitTxn.setLocalDateTime(LocalDateTime.now());
		
		
		Txn creditTxn=new Txn();
		creditTxn.setAccount(toAccount);
		creditTxn.setAmount(amount);
		creditTxn.setClosingBalance(toAccount.getBalance());
		creditTxn.setType(TxnType.CREDIT);
		creditTxn.setLocalDateTime(LocalDateTime.now());
		
		txnRepository.save(debitTxn);
		txnRepository.save(creditTxn);

		LOGGER.info("Txr finished");
		return true;

	}

}
