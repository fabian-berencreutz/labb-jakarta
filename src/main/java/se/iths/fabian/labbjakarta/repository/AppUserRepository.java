package se.iths.fabian.labbjakarta.repository;

import se.iths.fabian.labbjakarta.entity.AppUser;

import java.util.List;

public interface AppUserRepository {
    AppUser save(AppUser user);
    List<AppUser> findAll();
}
