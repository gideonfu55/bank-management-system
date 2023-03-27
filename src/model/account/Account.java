package model.account;

public abstract class Account {

    private String id;
    private String email;
    private String fullName;
    private String signature;

    public Account(String id, String email, String fullName, String signature) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Account Id cannot be null or blank. Please check again.");
        }
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.signature = signature;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Account Id cannot be null or blank. Please check again.");
        }
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", email='" + getEmail() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", signature='" + getSignature() + "'" +
            "}";
    }
    
    /*****************
     * Account Methods
     *****************
     */

    public abstract Account clone();

}
