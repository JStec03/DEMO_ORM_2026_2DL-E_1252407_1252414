/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.util.Console;

/**
 *
 * @author mcn
 */
public class MainMenu {
    public static void mainLoop() {
		int opcao = 0;
		do {
			opcao = menu();

			switch (opcao) {
				case 0:
					System.out.println("Ending..."); [cite: 158]
					break;
				case 1:
					System.out.println("Not yet implemented..."); [cite: 179]
					break;
				case 2:
					System.out.println("Not yet implemented..."); [cite: 180]
					break;

				default:
					System.out.println("Unrecognized option.");
					break;
			}
		} while (opcao != 0);

	}

	private static int menu() {
		int option = -1;
		System.out.println("");
		System.out.println("=============================");
		System.out.println(" Rent a Car "); [cite: 18]
		System.out.println("=============================\n");
		System.out.println("1. Register Car Group");
		System.out.println("2. List All Car Groups");

		System.out.println("=============================");
		System.out.println("0. Exit\n\n");
		option = Console.readInteger("Please choose an option");
		return option;
	}
}
