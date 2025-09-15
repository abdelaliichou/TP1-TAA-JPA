package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String name;
    private String role;

    // Un utilisateur peut créer plusieurs quiz
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Quiz> quizzes = new ArrayList<>();

    // Un utilisateur peut participer à plusieurs quiz
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Participation> participations = new ArrayList<>();

    public Player() {}

    public Player(
            String name,
            String role
    ) {
        this.role = role;
        this.name =  name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }

}
