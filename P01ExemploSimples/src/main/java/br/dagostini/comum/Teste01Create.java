package br.dagostini.comum;

import java.sql.Date;
import org.hibernate.Session;

import br.dagostini.persistencia.HibernateUtil;

public class Teste01Create {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		for (int i = 1; i <= 100; i++) {
			Colaborador emp = new Colaborador("Nome " + i, "Sobrenome " + i, new Date(System.currentTimeMillis()), "1234-5678");
			session.persist(emp);
		}


		session.getTransaction().commit();

		session.close();

		HibernateUtil.finalizar();

	}
}
