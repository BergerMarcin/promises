package honestit.akwilina.promises.services.impl;

import honestit.akwilina.promises.domain.entities.Role;
import honestit.akwilina.promises.domain.entities.User;
import honestit.akwilina.promises.domain.repositories.RoleRepository;
import honestit.akwilina.promises.domain.repositories.UserRepository;
import honestit.akwilina.promises.dtos.RegistrationDataDTO;
import honestit.akwilina.promises.services.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(RegistrationDataDTO registrationData) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(registrationData, User.class);
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);

        // Ustawienia roli dla użytkwonika
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);

        userRepository.save(user);
    }
}
