package postfix;

import java.util.Stack;

public class Laskin {

	Stack<Integer> stack = new Stack<>();

	int laske(String funktio) {
		System.out.println("Postfix: " + funktio);

		//Käydään koko postfix funktio läpi
		for (int i = 0; i < funktio.length(); i++) {
			char merkki = funktio.charAt(i);
			
			//Jos käsiteltävä merkki on numero pusketaan pinoon
			if (Character.isDigit(merkki))
				stack.push(Integer.parseInt(String.valueOf(merkki)));

			//Jos käsiteltävä merkki operaatio suoritetaan operaatio pinon kahdella päällimmäisellä alkiolla
			else {
				int numero1 = stack.pop();
				int numero2 = stack.pop();

				switch (merkki) {
				case '+':
					System.out.println(numero2 + "+" + numero1);
					stack.push(numero2 + numero1);
					break;

				case '-':
					System.out.println(numero2 + "-" + numero1);
					stack.push(numero2 - numero1);
					break;

				case '/':
					System.out.println(numero2 + "/" + numero1);
					stack.push(numero2 / numero1);
					break;

				case '*':
					System.out.println(numero2 + ":" + numero1);
					stack.push(numero2 * numero1);
					break;
				}
			}
		}
		return stack.pop();
	}
}
