package service;

import java.math.BigDecimal;

import model.account.Credit;
import repository.AccountRepository;

public class CreditService implements AccountService {

  AccountRepository accountRepository;

  public CreditService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void createAccount(Credit account) {
    this.accountRepository.createAccount(account);
  }

  public Credit retrieveAccount(String id) {
    return (Credit)this.accountRepository.retrieveAccount(id);
  }

  public String retrieveAccountHolder(String id) {
    return this.retrieveAccount(id).getFullName();
  }

  public void updateAccount(Credit account) {
    this.accountRepository.updateAccount(account);
  }

  public void deleteAccount(String id) {
    this.accountRepository.deleteAccount(id);
  }

  @Override
  public void deposit(String id, BigDecimal amount) {
    Credit credit = retrieveAccount(id);
    credit.setCredit(credit.getCredit().subtract(amount));
    updateAccount(credit);

    // Update business logic for if the user deposits an amount > than the current credit/loan amount - which makes the credit negative - i.e. prompts the user that the bank owes $X for overpaid balance.
  }

  @Override
  public void withdraw(String id, BigDecimal amount) {
    Credit creditAccount = retrieveAccount(id);
    if (creditAccount.getCredit().add(amount).compareTo(Credit.DEBT_LIMIT) > 0) {
      System.out.println("\nYour credit is above the maximum debt limit permitted.");
    } else {
      creditAccount.setCredit(creditAccount.getCredit().add(amount.multiply(Credit.INTEREST_RATE.add(new BigDecimal(1)))));
      updateAccount(creditAccount);
    }
  }

}
