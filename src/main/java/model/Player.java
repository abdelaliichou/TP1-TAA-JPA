package model;

import jakarta.persistence.*;

@Entity
public class Player {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // cascad means that if the department entity will be automatically persist
    // in case a new object of it will be created by a persist class like Player
    @ManyToOne(cascade = CascadeType.PERSIST)
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
