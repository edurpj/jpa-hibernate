package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		
		Pessoa p1 = new Pessoa(null, " Carlos", " carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, " Eduardo", " eduardo@gmail.com");
		Pessoa p3 = new Pessoa(null, " Jos�", " jose@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
	
		/* como j� inseriu n�o precisa inserir mais
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		//Buscando no db
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		
		//Para excluir tem que usar o .fnd() antes de usar o em.close()	
		Pessoa pTeste = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(pTeste);
		em.getTransaction().commit();
		
		
		System.out.println("Pronto!");
		emf.close();
		em.close();
	}

}
