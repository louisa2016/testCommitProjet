package fr.marseille.formation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RuntimeDelete {

	public static void main(String[] args) {
		// main proposant l'ajout d'une personne dans ma base
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaMavenFormation");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Debuter une transaction : Ouvrir la transaction
		entityManager.getTransaction().begin();
		Personne personne = entityManager.find(Personne.class, 2);
		if (null != personne) {
			entityManager.remove(personne);
		} else {
			System.out.println("Personne inexistante en base de données");
		}
		// Termine la transaction
		entityManager.getTransaction().commit();
		// Fin de transaction : on ferme EntityManager
		entityManager.close();
		entityManagerFactory.close();

	}

}
