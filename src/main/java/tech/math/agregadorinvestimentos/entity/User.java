package tech.math.agregadorinvestimentos.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Instant creationTimestamp;
    @UpdateTimestamp
    private Instant lastpdateTimestamp;

    //Empty Constructor
    public User() {
    }
    
    //Constructor
    public User(UUID userId, String username, String email, String password, Instant creationTimestamp,
            Instant lastpdateTimestamp) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationTimestamp = creationTimestamp;
        this.lastpdateTimestamp = lastpdateTimestamp;
    }

    //Getters
    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public Instant getLastpdateTimestamp() {
        return lastpdateTimestamp;
    }

    //Setters
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public void setLastpdateTimestamp(Instant lastpdateTimestamp) {
        this.lastpdateTimestamp = lastpdateTimestamp;
    }

    

}
