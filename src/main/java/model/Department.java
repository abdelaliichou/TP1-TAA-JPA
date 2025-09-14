package model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Department implements Serializable {

    private Long id;
    private String name;
    int codePostal;
    private Collection<Player> players;

    public Department(){}

    public Department(String name, int codePostal) {
        this.name = name;
        this.codePostal = codePostal;
    }

    @Id
    @GeneratedValue
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

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST )
    public Collection<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

}
