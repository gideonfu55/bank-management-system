package model.account;

import java.math.BigDecimal;

public class Credit extends Account {

    private BigDecimal credit;
    public static final BigDecimal DEBT_LIMIT = new BigDecimal(10000.00);
    public static final BigDecimal INTEREST_RATE = new BigDecimal(0.02);

    public Credit(String id, String email, String fullName, String signature, BigDecimal credit) {
        super(id, email, fullName, signature);
        this.credit = credit;
    }

    public BigDecimal getCredit() {
        return this.credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public Account clone() {
        return new Credit(super.getId(), super.getEmail(), super.getFullName(), super.getSignature(), this.credit);
    }

}
