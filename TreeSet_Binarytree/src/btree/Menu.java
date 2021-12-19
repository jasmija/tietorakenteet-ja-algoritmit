/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

import java.util.TreeSet;

/**
 *
 * @author kamaj
 */
public class Menu {
//Main alkaa-----------------------------------------------------------------------------
	public static void main(String[] args) {
		printMenu();
	}

//Main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
	private static void printMenu() {
		char select;
		String data;
		TreeSet<Integer> tree = new TreeSet();
		
		do {
			System.out.println("\n\t\t\t1. Lisää avain.");
			System.out.println("\t\t\t2. Etsi avaimella.");
			System.out.println("\t\t\t3. Käy puu läpi.");
			System.out.println("\t\t\t5. Lopetus.");
			System.out.print("\n\n"); // Tehdään tyhjiä rivejä
			select = Lue.merkki();
			
			switch (select) {
			case '1':
				System.out.println("Anna uusi avain (merkkijono)");
				data = Lue.rivi();
				tree.add(Integer.parseInt(data));
				break;
			case '2':
				System.out.println("Anna etsittävä avain (merkkijono)");
				data = Lue.rivi();
				 if(tree.contains(Integer.parseInt(data))) {
                     System.out.println("Löytyi " + data);
                 }
				 else {
					System.out.println("Avainta ei löytynyt.");
				 }
				break;
			case '3':
				for(Integer number : tree){
		            System.out.println(number);
		        }  
				break;
			case '4':
				break;
			}
		} while (select != '4');
	}
//printMenu loppuu ----------------------------------------------------------------
}
