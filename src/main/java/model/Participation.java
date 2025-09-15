package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Participation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int score;

    // one player can participate in many participations
    @ManyToOne
    private Player player;

    // many participation est liée à un quiz
    @ManyToOne
    private Quiz quiz;


    public Participation() {}

    public Participation(
            String nickname,
            int score
    ) {
        this.nickname = nickname;
        this.score=  score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickname;
    }
    public void setNickName(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return this.score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
