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

	private static  CarGroupUI carGroupUI;

	public  MainMenu(CarGroupUI carGroupUI) {
		 this.carGroupUI = carGroupUI;
	}

    public void mainLoop() {
		int opcao = 0;
		do {
			opcao = menu();

			switch (opcao) {
				case 0:
					System.out.println("Ending...");
					break;
				case 1:
					carGroupUI.registerCG();
					break;
				case 2:
					carGroupUI.listGAs();
					break;
				case 3:
					carGroupUI.searchCarGroupById();
					break;
				case 4:
					carGroupUI.searchCarGroupByName();
					break;
				case 5:
					carGroupUI.searchCarGroupByDoors();
					break;
				case 6:
					carGroupUI.searchCarGroupByClass();
					break;

				default:
					System.out.println("Unrecognized option.");
					break;
			}
		} while (opcao != 0);

	}

	private static int menu() {
		int option = -1;
		System.out.println();
		System.out.println("=============================");
		System.out.println(" Rent a Car ");
		System.out.println("=============================\n");
		System.out.println("1. Register Car Group");
		System.out.println("2. List All Car Groups");
		System.out.println("3. Search Car Group by ID");
		System.out.println("4. Search Car Group by Name");
		System.out.println("5. Search Car Group by Doors");
		System.out.println("6. Search Car Group by Class");


		System.out.println("=============================");
		System.out.println("0. Exit\n\n");
		option = Console.readInteger("Please choose an option");
		return option;
	}
}
