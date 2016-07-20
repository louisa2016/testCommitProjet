package fr.marseille.formation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RuntimeUpdate {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaMavenFormation");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Debuter une transaction : Ouvrir la transaction
		entityManager.getTransaction().begin();
		// Mise a jour d'une personne
		Personne personne = entityManager.find(Personne.class, 1);
		if (null != personne) {
			// personne.setNom("Martin");
			personne.setPrenom("Paul");
			personne.setSalaire(8000.0);
		} else {
			System.out.println("Personne inexistante en base de données");
		}

		// entityManager.persist(personne);pas utile, commit est suffisant
		entityManager.getTransaction().commit();
		// Affichage des donnees
		// pas obligatoire, on ne peut modifier que le prenom et le salaire
		// System.out.println("Nom: " + personne.getNom());

		System.out.println("Prenom: " + personne.getPrenom());
		System.out.println("Identifiant : " + personne.getId());

		entityManager.close();
		entityManagerFactory.close();

	}

}
