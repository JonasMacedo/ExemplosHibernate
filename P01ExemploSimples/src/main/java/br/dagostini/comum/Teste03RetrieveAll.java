package br.dagostini.comum;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.dagostini.persistencia.HibernateUtil;

public class Teste03RetrieveAll {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria crit = session.createCriteria(Colaborador.class);

		@SuppressWarnings("unchecked")
		List<Colaborador> lista = crit.list();

		for (Colaborador cl : lista) {
			System.out.print("\n\nColaborador encontrado:\n\t");
			System.out.println(cl);
		}

		System.out.println(lista.size() + " registros encontrados.");

		session.close();

		HibernateUtil.finalizar();

	}
}
