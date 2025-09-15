package model;

public class Utils {
    public static enum Roles {
        STUDENT, TEACHER
    }
    public static String allPlayersQuery = "select e from Player as e";
    public static String playersByDepartmentQuery = "select e from Player e where e.department.name = :departmentName";
    public static String playerByNameQuery = "select p from Player as p where p.name = :name";
    public static String playerNameAndRoleQuery = "select e.name, e.role from Player as e";
    public static String complexQuery = "select d.nom, avg(e.salaire) from department d join d.players e group by d.nom having count(d.nom) > 5";

}
