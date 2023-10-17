package com.likebookapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Size(min = 3, max = 20)
    @Column(nullable = false, unique = true)
    private String username;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    @ManyToMany(mappedBy = "userLikes")
    private Set<Post> likedPosts;

    public User() {
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
