package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.BankAccount;

public class Bank_Dao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save(BankAccount bankaccount) {
		et.begin();
		em.persist(bankaccount);
		et.commit();
	}

	public List<BankAccount> fetchAllBank() {

		List<BankAccount> list = em.createQuery("select x from BankAccount x").getResultList();
		return list;

	}

}
