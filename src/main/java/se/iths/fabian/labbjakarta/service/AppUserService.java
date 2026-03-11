package se.iths.fabian.labbjakarta.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import se.iths.fabian.labbjakarta.entity.AppUser;
import se.iths.fabian.labbjakarta.repository.AppUserRepository;

import java.util.List;

@ApplicationScoped
public class AppUserService {

    @Inject
    private AppUserRepository appUserRepository;

    @Transactional
    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }
}
