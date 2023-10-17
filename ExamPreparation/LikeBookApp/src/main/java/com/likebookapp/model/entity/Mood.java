package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private MoodName moodName;

    private String description;

    @OneToMany(mappedBy = "mood")
    private Set<Post> posts;

    public Mood() {
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodName name) {
        this.moodName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
