package se.iths.fabian.labbjakarta.web;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.iths.fabian.labbjakarta.entity.AppUser;
import se.iths.fabian.labbjakarta.service.AppUserService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserBean implements Serializable {

    @Inject
    private AppUserService appUserService;

    private String username;
    private String password;

    public void save() {
        AppUser newUser = new AppUser();
        newUser.setUsername(this.username);
        newUser.setPassword(this.password);

        appUserService.saveUser(newUser);

        this.username = "";
        this.password = "";
    }

    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    public AppUserService getAppUserService() {
        return appUserService;
    }

    public void setAppUserService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
