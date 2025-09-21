package model;

public class JPQLQueries {
    public static enum Roles {
        STUDENT, TEACHER
    }

    public static String playerFindByEmail = "SELECT p FROM Player p WHERE p.email = :email";
    public static String playerFindQuizByPlayer = "SELECT q FROM Quiz q WHERE q.author.id = :playerId";
    public static String playerFindParticipationsByPlayer = "SELECT p FROM Participation p WHERE p.player.id = :playerId";
    public static String playerAuthenticate = "SELECT COUNT(p) FROM Player p WHERE p.email = :email";

    // --- JPQL Queries for Quiz ---
    public static String quizFindById = "SELECT q FROM Quiz q WHERE q.id = :id";

    public static String quizFindAll = "SELECT q FROM Quiz q ORDER BY q.id DESC";

    public static String quizFindByAuthor = "SELECT q FROM Quiz q WHERE q.author.id = :authorId";

    public static String quizFindWithQuestions = "SELECT q FROM Quiz q LEFT JOIN FETCH q.questions WHERE q.id = :quizId";

    public static String quizDeleteById = "DELETE FROM Quiz q WHERE q.id = :id";

    // TODO same jpql queries for -> Participation | Quiz | Question | Response

}

/*

    getSingleResult() -> we're sur that the result is 1 element
    getResultList() -> we're sur that the result is > 1 element
    setFirstResult(int departPosition)
    setMaxResults(int resultsNumber)
    setFlushMode(FlushModeType mode)

    // return a list of 2 dimension objects containing name and role
    public static List<Object[]> getPlayersNameAndRole(EntityManager manager) {

             we do the query

                for (Object[] info : players) {
                    System.out.println("Player name => " + info[0]);
                    System.out.println("Player role => " + info[1]);
                }



        return List.of();
    }

*/
