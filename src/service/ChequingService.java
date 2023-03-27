package service;

import java.math.BigDecimal;

import model.account.Chequing;
import repository.AccountRepository;

public class ChequingService implements AccountService {
        
  AccountRepository accountRepository;

  public ChequingService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void createAccount(Chequing account) {
    this.accountRepository.createAccount(account);
  }

  public Chequing retrieveAccount(String id) {
    return (Chequing)this.accountRepository.retrieveAccount(id);
  }

  public String retrieveAccountHolder(String id) {
    return this.retrieveAccount(id).getFullName();
  }

  public void updateAccount(Chequing account) {
    this.accountRepository.updateAccount(account);;
  }

  public void deleteAccount(String id) {
    this.accountRepository.deleteAccount(id);;
  }

  @Override
  public void deposit(String id, BigDecimal amount) {
    Chequing checking = retrieveAccount(id);
    checking.setBalance(checking.getBalance().add(amount));
    updateAccount(checking);
  }

  @Override
  public void withdraw(String id, BigDecimal amount) {
    Chequing checking = retrieveAccount(id);
    checking.setBalance(checking.getBalance().subtract(amount));
    updateAccount(checking);
  }

}
