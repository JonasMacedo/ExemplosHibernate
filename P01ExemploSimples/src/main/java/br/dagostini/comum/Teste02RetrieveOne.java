package br.dagostini.comum;

import org.hibernate.Session;

import br.dagostini.persistencia.HibernateUtil;

public class Teste02RetrieveOne {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Colaborador cl = session.get(Colaborador.class, 50L);
		System.out.print("\n\nColaborador encontrado:\n\t");
		System.out.println(cl);

		session.close();

		HibernateUtil.finalizar();

	}
}
