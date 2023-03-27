package model.account;

import java.math.BigDecimal;

public class Savings extends Account {

  public static final BigDecimal WITHDRAWAL_FEE = new BigDecimal("5.00");
  private BigDecimal balance;

  public Savings(String id, String email, String name, String signature, BigDecimal balance) {
    super(id, email, name, signature);
    this.balance = balance;
  }

  public BigDecimal getBalance() {
    return this.balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  @Override
  public Account clone() {
    return new Savings(super.getId(), super.getEmail(), super.getFullName(), super.getSignature(), this.balance);
  }

}
