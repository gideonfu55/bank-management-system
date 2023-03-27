package model.account;

import java.math.BigDecimal;

import model.account.interfaces.Taxable;

public class Chequing extends Account implements Taxable {

    private BigDecimal balance;

    public Chequing(String id, String email, String fullName, String signature, BigDecimal balance) {
        super(id, email, fullName, signature);
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
        return new Chequing(super.getId(), super.getEmail(), super.getFullName(), super.getSignature(), this.balance);
    }

    @Override
    public void tax(double income) {
        throw new UnsupportedOperationException("Unimplemented method 'tax'");
    }

}
