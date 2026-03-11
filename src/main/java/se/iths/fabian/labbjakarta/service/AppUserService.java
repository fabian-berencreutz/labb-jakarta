package se.iths.fabian.labbjakarta.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import se.iths.fabian.labbjakarta.entity.AppUser;
import se.iths.fabian.labbjakarta.repository.AppUserRepository;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class AppUserService {

    private static final Logger logger = Logger.getLogger(AppUserService.class.getName());

    @Inject
    private AppUserRepository appUserRepository;

    @Transactional
    public AppUser saveUser(AppUser user) {
        logger.info("Försöker spara användare: " + user.getUsername());
        return appUserRepository.save(user);
    }

    public List<AppUser> getAllUsers() {
        logger.info("Hämtar alla användare från databasen.");
        return appUserRepository.findAll();
    }
}
