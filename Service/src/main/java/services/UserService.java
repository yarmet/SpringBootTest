package services;

import entities.Role;
import entities.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }


    public boolean registryUser(User user, Map<String, Object> map) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            map.put("message", "Такой пользователь уже есть!");
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordService.getBcCryptoPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);

        return true;
    }


    public void autoLogin(User user) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );

        if (authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
    }


    public List<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }
}