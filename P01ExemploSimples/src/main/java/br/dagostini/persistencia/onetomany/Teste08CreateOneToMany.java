package br.dagostini.persistencia.onetomany;

import java.util.ArrayList;

import org.hibernate.Session;

import br.dagostini.persistencia.HibernateUtil;

public class Teste08CreateOneToMany {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Setor setor = new Setor();
		setor.setNome("Comercial");
		session.persist(setor);

		Empregado emp1 = new Empregado("Hugo", "Silva", "111");
		emp1.setSetor(setor); // Atribuindo o setor ao empregado.

		Empregado emp2 = new Empregado("José", "Souza", "222");
		emp2.setSetor(setor); // Atribuindo o setor ao empregado.

		Empregado emp3 = new Empregado("Luiz", "Almeida", "333");
		emp3.setSetor(setor); // Atribuindo o setor ao empregado.

		setor.setEmpregados(new ArrayList<Empregado>());

		setor.getEmpregados().add(emp1); // Atribuindo o empregado ao setor.
		setor.getEmpregados().add(emp2); // Atribuindo o empregado ao setor.
		setor.getEmpregados().add(emp3); // Atribuindo o empregado ao setor.

		session.getTransaction().commit();

		session.close();

		HibernateUtil.finalizar();
	}
}
