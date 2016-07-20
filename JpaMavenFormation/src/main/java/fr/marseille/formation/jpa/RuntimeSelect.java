package fr.marseille.formation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RuntimeSelect {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaMavenFormation");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Personne personne = entityManager.find(Personne.class, 3);
		if (null != personne) {
			System.out.println("Nom: " + personne.getNom());
			System.out.println("Prenom: " + personne.getPrenom());
			System.out.println("Identifiant : " + personne.getId());
		} else {
			System.out.println("Personne inexistante en base de données");
		}
		entityManager.close();
		entityManagerFactory.close();

	}

}
