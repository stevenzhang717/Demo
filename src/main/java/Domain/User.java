package Domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: penghaozhang
 * Date: 19/03/13
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable, UserDetails {
    private String username;
    private String password;
    private String email;
    private Date accountExpiry;
    private boolean enabled;
    private Date credentialExpiry;
    private boolean locked;
    private Authority authority;

    public User(String username, String password, String email, Authority authority) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAccountExpiry() {
        return accountExpiry;
    }

    public void setAccountExpiry(Date accountExpiry) {
        this.accountExpiry = accountExpiry;
    }

    public Date getCredentialExpiry() {
        return credentialExpiry;
    }

    public void setCredentialExpiry(Date credentialExpiry) {
        this.credentialExpiry = credentialExpiry;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return authority.name();
            }
        });
        return authorities;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPassword() {
        return password;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getUsername() {
        return username;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        //if there is no expiry date defined, just return.
        if (accountExpiry == null) return true;
        return isBeforeToday(accountExpiry);
    }

    @Override
    public boolean isAccountNonLocked() {
        return locked;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (credentialExpiry == null) return true;
        return isBeforeToday(credentialExpiry);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEnabled() {
        return enabled;  //To change body of implemented methods use File | Settings | File Templates.
    }

    //compare the date to check whether it is before today
    private boolean isBeforeToday(Date date) {
        //get the date today
        Calendar cal = Calendar.getInstance();
        Date today = new Date(cal.getTimeInMillis());

        //compare the date to the expiry date
        if (today.after(date)) {
            return false;
        }
        return true;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
