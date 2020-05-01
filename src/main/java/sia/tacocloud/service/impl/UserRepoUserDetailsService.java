package sia.tacocloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sia.tacocloud.domain.User;
import sia.tacocloud.repo.UserRepo;

/**
 * @author Orlov Diga
 */
@Service
public class UserRepoUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserRepoUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found");

    }
}

