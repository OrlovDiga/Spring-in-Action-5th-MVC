package sia.tacocloud.form;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.domain.User;

/**
 * Data class for User Entity
 *
 * @author Orlov Diga
 */
@Data
public class RegistrationForm {

    private final String username;
    private final String password;
    private final String fullname;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final String phone;

    public User toUser(PasswordEncoder encoder) {
        return new User(username,
                        encoder.encode(password),
                        fullname,
                        street,
                        city,
                        state,
                        zip,
                        phone);
    }
}
