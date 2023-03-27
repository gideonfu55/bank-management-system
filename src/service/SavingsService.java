package service;

import java.math.BigDecimal;

import model.account.Savings;
import repository.AccountRepository;

public class SavingsService implements AccountService {

  AccountRepository accountRepository;
  
  public SavingsService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void createAccount(Savings account) {
    this.accountRepository.createAccount(account);
  }

  public Savings retrieveAccount(String id) {
    return (Savings)this.accountRepository.retrieveAccount(id);
  }

  public String retrieveAccountHolder(String id) {
    return this.retrieveAccount(id).getFullName();
  }

  public void updateAccount(Savings account) {
    this.accountRepository.updateAccount(account);
  }

  public void deleteAccount(String id) {
    this.accountRepository.deleteAccount(id);
  }

  @Override
  public void deposit(String id, BigDecimal amount) {
    Savings savingsAccount = retrieveAccount(id);
    savingsAccount.setBalance(savingsAccount.getBalance().add(amount));
    updateAccount(savingsAccount);
    System.out.println("\nYour deposit is successful. Your new account balance is: " + savingsAccount.getBalance());
  }

  @Override
  public void withdraw(String id, BigDecimal amount) {
    Savings savingsAccount = retrieveAccount(id);
    if (savingsAccount.getBalance().compareTo(amount.add(Savings.WITHDRAWAL_FEE)) > 0) {
      savingsAccount.setBalance(savingsAccount.getBalance().subtract(amount.add(Savings.WITHDRAWAL_FEE)));
    } else {
      System.out.println("Transaction is not approved - insufficient balance.");
    }

  }

}
