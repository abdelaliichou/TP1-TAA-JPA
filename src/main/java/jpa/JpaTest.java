package jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Department;
import model.Player;
import model.Utils;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

            Department dep = new Department("Rennes", 35000);
            Player ichou = new Player(
                    "ichou",
                    Utils.Roles.STUDENT.name(),
                    dep
            );

            Player olivier = new Player(
                    "olivier",
                    Utils.Roles.TEACHER.name(),
                    dep
            );

            manager.persist(ichou);
            manager.persist(olivier);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}




}
