/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingjcapi;

import java.util.*;

/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
		RandomString rString = new RandomString(10);
		float genBalance;
		TrafficCard myCard;
		Random r = new Random();
		int i;
		for (i = 0; i < 10; i++) {
			genBalance = ((float) r.nextInt(1000) / 10);
			myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
			cardUsers.add(myCard);
		}

		System.out.println("Järjestämätön lista: ");
		Iterator itr = cardUsers.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Comparable TEHT 19
		System.out.println();
		System.out.println("Järjestetty lista Comparable balance: ");
		Collections.sort(cardUsers);
		Iterator iterator = cardUsers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// Comparator TEHT 20
		System.out.println();
		System.out.println("Järjestetty lista Comparator balance: ");
		Collections.sort(cardUsers, new BalanceComparator());
		iterator = cardUsers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println();
		System.out.println("Järjestetty lista Comparator travellernumber: ");
		Collections.sort(cardUsers, new TravellerNumberComparator());
		iterator = cardUsers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// Lamda lauseke TEHT 21
		 System.out.println("matkakortit, joiden saldo > 0 ja < 25:");
		 printTrafficCardsWithPredicate(cardUsers, t -> t.mTravellerNumber > 0);

		// Tietovirrat TEHT 22
		System.out.println();
		System.out.println("Järjestetty lista Tietovirtoina travellernumber: ");
		cardUsers.stream().sorted(Comparator.comparingInt(TrafficCard::getTravellernumber))
				.filter(t -> t.mTravellerNumber > 0).forEach(e -> System.out.println(e.toString()));

	}

	// TEHT 21
	public interface Predicate<TrafficCard> {
		boolean test(TrafficCard t);
	}

	// Operaatio, joka iteroi säiliöidyn tiedon ja kohdistaa testin jokaiseen
	public static void printTrafficCardsWithPredicate(ArrayList<TrafficCard> cardUsers, Predicate<TrafficCard> tester) {
		cardUsers.sort((TrafficCard t1, TrafficCard t2) -> t1.getTravellernumber().compareTo(t2.getTravellernumber()));
		for (TrafficCard t : cardUsers) {
			if (tester.test(t)) {
				System.out.println(t);
			}
		}
	}

}
