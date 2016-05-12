package br.dagostini.comum;

import org.hibernate.Session;

import br.dagostini.persistencia.HibernateUtil;

public class Teste05Update {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Colaborador cl = session.get(Colaborador.class, 50L);

		cl.setNome("Perna");
		cl.setSobrenome("Longa");

		session.getTransaction().commit();

		session.close();

		HibernateUtil.finalizar();

	}
}
