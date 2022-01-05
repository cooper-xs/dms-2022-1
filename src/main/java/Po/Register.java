package Po;

import java.util.Objects;

public class Register {
    private int identity;
    private String account, password;

    @Override
    public String toString() {
        return "register{" +
                "identity=" + identity +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Register)) return false;
        Register register = (Register) o;
        return identity == register.identity && Objects.equals(account, register.account) && Objects.equals(password, register.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, account, password);
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
