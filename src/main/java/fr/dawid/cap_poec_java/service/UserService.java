package fr.dawid.cap_poec_java.service;

import fr.dawid.cap_poec_java.DTO.UserPostDTO;
import fr.dawid.cap_poec_java.entity.Gamer;
import fr.dawid.cap_poec_java.entity.Moderator;
import fr.dawid.cap_poec_java.entity.User;
import fr.dawid.cap_poec_java.exception.NotFoundEntityException;
import fr.dawid.cap_poec_java.repository.UserRepository;
import fr.dawid.cap_poec_java.service.interfaces.DAOServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User>,
                                    UserDetailsService {

    private BCryptPasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public User findByNickname(String username) {
        return userRepository.findByNickname(username)
                .orElseThrow(NotFoundEntityException::new);
    }

    @Override
    public User getObjectById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundEntityException::new);
    }

    public User create(UserPostDTO userDTO) {
        Gamer gamer = new Gamer();
        gamer.setNickname(userDTO.getNickname());
        gamer.setEmail(userDTO.getEmail().toLowerCase());
        gamer.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        gamer.setBirthAt(userDTO.getBirthAt());
        return userRepository.saveAndFlush(gamer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = findByNickname(username);

        return new org.springframework.security.core.userdetails.User(
                user.getNickname(),
                user.getPassword(),
                userGrantedAuthority(user)
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(User user) {
        if (user instanceof Moderator) {
            return List.of(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_GAMER"));
    }
}
