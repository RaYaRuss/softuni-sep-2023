package com.likebookapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{
    @NotNull
    @Size(min = 2, max = 150)
    private String content;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    private int likes;

    @ManyToMany
    private Set<User> userLikes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "moods_id")
    private Mood mood;


    public Post() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Set<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<User> userLikes) {
        this.userLikes = userLikes;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
