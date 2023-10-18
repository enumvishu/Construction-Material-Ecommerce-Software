package DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DataTransferObject.Company;

public class Company_DAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save(Company dto) {
		et.begin();
		em.persist(dto);
		et.commit();

	}

	public List<Company> check1(String email) {

		List<Company> list = em.createQuery("select x from Company x where Email=?1").setParameter(1, email).getResultList();
		return list;

	}

	public List<Company> check1(long mob) {
		List<Company> list = em.createQuery("select x from Company x where Mobile=?1").setParameter(1, mob).getResultList();
		return list;
	}

	public List<Company> check2(String pan) {

		List<Company> list = em.createQuery("select x from Company x where PAN=?1").setParameter(1, pan).getResultList();
		return list;

	}

	public List<Company> check2(long regst) {
		List<Company> list = em.createQuery("select x from Company x where Registration_No=?1").setParameter(1, regst).getResultList();
		return list;
	}

}
