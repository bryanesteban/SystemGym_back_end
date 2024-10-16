package com.bryan.backend.usersapp.backendusersapp.models.DTO;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private boolean admin;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String email, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.admin = isAdmin;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
