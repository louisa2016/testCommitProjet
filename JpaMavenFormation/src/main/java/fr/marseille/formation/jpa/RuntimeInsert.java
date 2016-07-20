package fr.marseille.formation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RuntimeInsert {

	public static void main(String[] args) {
		// main proposant l'ajout d'une personne dans ma base
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaMavenFormation");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Debuter une transaction : Ouvrir la transaction
		entityManager.getTransaction().begin();
		// Ajout d'une personne
		Personne personne = new Personne();
		personne.setNom("MARTIN");
		personne.setPrenom("Marie");
		personne.setSalaire(2500.0);
		// Sauvegarde
		entityManager.persist(personne);
		// Termine la transaction
		entityManager.getTransaction().commit();
		// Fin de transaction : on ferme EntityManager
		entityManager.close();
		entityManagerFactory.close();

	}

}
