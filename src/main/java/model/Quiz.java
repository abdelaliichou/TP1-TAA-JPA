package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    // Plusieurs quiz appartiennent à un utilisateur (auteur)
    @ManyToOne
    private Player player;

    // Un quiz contient plusieurs questions
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    // Un quiz contient plusieurs participations
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Participation> participations = new ArrayList<>();


    public Quiz() {}

    public Quiz(
            String title,
            String description
    ) {
        this.title = title;
        this.description=  description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
}
