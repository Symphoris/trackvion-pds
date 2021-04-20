package beanstest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import beans.Candidate;

public class CandidateTest {
	
	
	/***
	 * Default case
	 * Init: création d'une instance de Candidate  création d'une noteGlobale et les pondérations de finances 
	 * Transition: Utilisation de la méthode calculNoteGlobale avec les differentes pondérations
	 * Result : 7 ==7
	 */
	@Test
	public void testcalculNoteGlobalewithValidNoteGlobale_TheMethodMustBeInvokedSuccessfull() {
		//Init
		float noteGlobale = 0;
		int ponderationSante =50;
		int ponderationFinance= 50;
		int noteSante = 8;
		int noteFinance = 6;
		noteGlobale= (noteSante*ponderationSante/100) + (noteFinance*ponderationFinance/100);
		Candidate candidate = new Candidate();
		candidate.setNoteFinance(6);
		candidate.setNoteSante(8);
		
		
		//Transition
		final float noteGlobaleC = candidate.calculNoteGlobale(ponderationSante,ponderationFinance);

		//Result
		assertTrue(noteGlobale == noteGlobaleC );
	}
	/***
	 * Default case
	 * Init: création d'une instance de Candidate  création d'une noteGlobale érronée et les pondérations de finances 
	 * Transition: Utilisation de la méthode calculNoteGlobale avec les differentes pondérations
	 * Result : 7 !=13
	 */
	@Test
	public void testcalculNoteGlobaleWithInvalidNoteGlobale_TheMethodMustBeInvokedSuccessfull() {
		//Init
		float noteGlobale = 0;
		int ponderationSante =50;
		int ponderationFinance= 50;
		int noteSante = 8;
		int noteFinance = 6;
		noteGlobale= (noteSante*ponderationSante/100) + (noteFinance*ponderationFinance/100) +6;
		Candidate candidate = new Candidate();
		candidate.setNoteFinance(6);
		candidate.setNoteSante(8);
		
		
		//Transition
		final float noteGlobaleC = candidate.calculNoteGlobale(ponderationSante,ponderationFinance);

		//Result
		assertTrue(noteGlobale != noteGlobaleC );
	}
	
	/***
	 * Default case
	 * Init: création d'une instance de deux  Candidats  et l'attribution de deux notes globales différentes
	 * Transition: Utilisation de la méthode compareTo pour comparer les deux notes
	 * Result : -1
	 */
	@Test
	public void testcompareTowithLowerNoteGlobaleTheMethodMustBeInvokedSuccessfull() {
		//Init
		int result = -1;
		Candidate candidate1 = new Candidate();
		Candidate candidate2 = new Candidate();
		candidate1.setNoteGlobale(8);
		candidate2.setNoteGlobale(6);
		
		
		//Transition
		final int resultcompareTo = candidate1.compareTo(candidate2);

		//Result
		assertTrue(resultcompareTo == result );
	}
	
	/***
	 * Default case
	 * Init: création d'une instance de deux  Candidats  et l'attribution de deux notes globales différentes
	 * Transition: Utilisation de la méthode compareTo pour comparer les deux notes
	 * Result : 1
	 */
	@Test
	public void testcompareTowithtUpperNoteGlobaleTheMethodMustBeInvokedSuccessfull() {
		//Init
		int result = 1;
		Candidate candidate1 = new Candidate();
		Candidate candidate2 = new Candidate();
		candidate1.setNoteGlobale(5);
		candidate2.setNoteGlobale(6);
		
		
		//Transition
		final int resultcompareTo = candidate1.compareTo(candidate2);

		//Result
		assertTrue(resultcompareTo == result );
	}
	/***
	 * Default case
	 * Init: création d'une instance de deux  Candidats  et l'attribution de deux notes globales différentes
	 * Transition: Utilisation de la méthode compareTo pour comparer les deux notes
	 * Result : 0
	 */
	@Test
	public void testcompareTowithtEqualNoteGlobaleTheMethodMustBeInvokedSuccessfull() {
		//Init
		int result = 0;
		Candidate candidate1 = new Candidate();
		Candidate candidate2 = new Candidate();
		candidate1.setNoteGlobale(6);
		candidate2.setNoteGlobale(6);
		
		
		//Transition
		final int resultcompareTo = candidate1.compareTo(candidate2);

		//Result
		assertTrue(resultcompareTo == result );
	}

}
