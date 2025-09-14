package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@NamedQueries(
        {
                @NamedQuery(
                        name = "getPlayers",
                        query = "select e from Player e"
                ),
                @NamedQuery(
                        name = "getPlayerByName",
                        query = "select e from Player e where e.name = :name"
                )
        }
)
public class Player implements Serializable {

    private Long id;
    private String name;
    private String role;
    private Department department;

    public Player() {}

    public Player(
            String name,
            String role,
            Department department
    ) {
        this.role = role;
        this.name =  name;
        this.department = department;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department="
                + department.getName() + "]";
    }

}
