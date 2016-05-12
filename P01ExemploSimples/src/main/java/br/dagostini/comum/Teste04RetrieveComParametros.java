package br.dagostini.comum;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.dagostini.persistencia.HibernateUtil;

public class Teste04RetrieveComParametros {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria cr = session.createCriteria(Colaborador.class);

		cr.add(Restrictions.like("nome", "%5%"));

		// Outros parâmetros:
		// Buscar campos maiores que (greater than).
		// cr.add(Restrictions.gt("salario", 2000));

		// Buscar valores menores que (less than).
		// cr.add(Restrictions.lt("salario", 2000));

		// Buscar valores que começam com teste
		// cr.add(Restrictions.like("nome", "teste%"));

		// Buscar valores que começam com teste NÃO se importando com maiúsculas e minúsculas.
		// cr.add(Restrictions.ilike("nome", "teste%"));

		// Buscar valores entre 1000 e 2000
		// cr.add(Restrictions.between("salario", 1000, 2000));

		// Buscar valores nulos
		// cr.add(Restrictions.isNull("salario"));

		// Buscar valores NÃO nulos
		// cr.add(Restrictions.isNotNull("salario"));

		// Buscar valores vazios
		// cr.add(Restrictions.isEmpty("salario"));

		// Buscar valores não vazios
		// cr.add(Restrictions.isNotEmpty("salario"));

		@SuppressWarnings("unchecked")
		List<Colaborador> lista = cr.list();

		for (Colaborador cl : lista) {
			System.out.print("\n\nColaborador encontrado:\n\t");
			System.out.println(cl);
		}

		System.out.println(lista.size() + " registros encontrados.");

		session.close();

		HibernateUtil.finalizar();
	}
}
