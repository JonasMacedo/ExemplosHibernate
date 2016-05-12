package br.dagostini.comum;

import java.util.Date;

import org.hibernate.Session;

import br.dagostini.persistencia.HibernateUtil;

public class Teste06UpdateCuidados {
	public static void main(String[] args) {


		System.out.println("Sessão fechada.====================================");
		{
			Session session = HibernateUtil.getSessionFactory().openSession();

			Colaborador cl = session.get(Colaborador.class, 50L);

			session.close();

			// se a sessão tiver fechada, o objeto estará em estado detached e o
			// banco não será atualizado.

			cl.setNome("Perna");
			cl.setSobrenome("Longa");
		}

		System.out.println("Evict===============================================");
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();


			Colaborador cl = session.get(Colaborador.class, 50L);

			// mesmo com a sessão aberta se você chamar o evict o objeto é
			// retirado do contexto do hibernate e o update não é feito.
			session.evict(cl);

			cl.setNome("Perna");
			cl.setSobrenome("Longa");

			session.getTransaction().commit();

			session.close();
		}

		System.out.println("Merge===============================================");
		{
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Colaborador cl = new Colaborador();
			cl.setId(50L);

			session.merge(cl);

			System.out.println(cl);

			cl.setNome("Perna");
			cl.setSobrenome("Longa");

			session.getTransaction().commit();

			session.close();
		}

		System.out.println("Insert depois Update=================================");
		{
			Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			Colaborador cl = new Colaborador();
			cl.setAniversario(new java.sql.Date(System.currentTimeMillis()));
			cl.setCelular("9090-1234");
			cl.setNome("nome");
			cl.setSobrenome("sobrenome");

			session.persist(cl);

			System.out.println(cl);

			cl.setNome("Perna");
			cl.setSobrenome("Longa");

			session.getTransaction().commit();

			session.close();
		}

		HibernateUtil.finalizar();
	}
}
