package bg.softuni.battleships.services;

import bg.softuni.battleships.models.User;
import bg.softuni.battleships.models.dtos.LoginDTO;
import bg.softuni.battleships.models.dtos.UserRegistrationDTO;
import bg.softuni.battleships.repositories.UserRepository;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final LoggedUser userSession;

    public AuthService(UserRepository userRepository, LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(UserRegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

        if (byEmail.isPresent()) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());

        if (byUsername.isPresent()) {
            return false;
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setFullName(registrationDTO.getFullName());
        user.setPassword(registrationDTO.getPassword());

        this.userRepository.save(user);

        return true;

    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (user.isEmpty()) {
            return false;
        }

        this.userSession.login(user.get());

        return true;
    }
}
