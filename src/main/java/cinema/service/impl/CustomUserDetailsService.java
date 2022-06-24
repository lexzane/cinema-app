package cinema.service.impl;

import static org.springframework.security.core.userdetails.User.withUsername;

import cinema.model.User;
import cinema.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(username);

        UserBuilder userBuilder;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userBuilder = withUsername(username);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRoles().stream()
                    .map(e -> e.getName().name())
                    .toArray(String[]::new));
            return userBuilder.build();
        }
        throw new UsernameNotFoundException("Couldn't find user");
    }
}
