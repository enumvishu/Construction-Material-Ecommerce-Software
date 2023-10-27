package DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DataTransferObject.Buyer;

public class Buyer_DAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save(Buyer buyer) {
		et.begin();
		em.persist(buyer);
		et.commit();
	}

	public List<Buyer> fetch(long mobile) {

		List<Buyer> list = em.createQuery("select x from Buyer x where mob=?1").setParameter(1, mobile).getResultList();

		return list;
	}

	public List<Buyer> fetch(String email) {

		List<Buyer> list = em.createQuery("select x from Buyer x where email=?1").setParameter(1, email).getResultList();

		return list;
	}

	public Buyer fetchbyid(long custid) {

		Buyer buyer = em.find(Buyer.class, custid);
		return buyer;

	}

	public void update(Buyer buyer) {
		et.begin();
		em.merge(buyer);
		et.commit();

	}

}
