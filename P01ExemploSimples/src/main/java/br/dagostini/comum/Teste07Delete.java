package br.dagostini.comum;

import org.hibernate.Session;

import br.dagostini.persistencia.HibernateUtil;

public class Teste07Delete {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Colaborador cl = session.get(Colaborador.class, 51L);

		session.delete(cl);

		session.getTransaction().commit();

		session.close();

		HibernateUtil.finalizar();

	}
}
