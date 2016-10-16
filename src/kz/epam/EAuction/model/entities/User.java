package kz.epam.EAuction.model.entities;

import java.io.Serializable;

/**
 * Created by Вит on 16.10.2016.
 */
public class User extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int roleId;
    private int repositoryId;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String secondName;

    public User(int roleId, int repositoryId, String login, String password, String email, String firstName, String secondName) {
        super();
        this.roleId = roleId;
        this.repositoryId = repositoryId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(int id, int roleId, int repositoryId, String login, String password, String email, String firstName, String secondName) {
        super(id);
        this.roleId = roleId;
        this.repositoryId = repositoryId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(int repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (roleId != user.roleId) return false;
        if (repositoryId != user.repositoryId) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!firstName.equals(user.firstName)) return false;
        return secondName.equals(user.secondName);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + roleId;
        result = 31 * result + repositoryId;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "User{" +
                "roleId=" + roleId +
                ", repositoryId=" + repositoryId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
