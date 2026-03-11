package se.iths.fabian.labbjakarta.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.iths.fabian.labbjakarta.entity.AppUser;
import se.iths.fabian.labbjakarta.service.AppUserService;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    @Inject
    private AppUserService appUserService;

    private String username;
    private String password;
    private AppUser loggedInUser;

    public String login() {
        AppUser user = appUserService.login(username, password);

        if (user != null) {
            this.loggedInUser = user;
            return "chat.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Inloggning misslyckades", "Fel användarnamn eller lösenord"));
            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    // Getters och Setters
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

    public AppUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(AppUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
