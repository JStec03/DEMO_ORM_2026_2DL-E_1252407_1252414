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

	private final   CarGroupUI carGroupUI;
	private final CarUI carUI;
	private final RentalContractUI rentalContractUI;
	public  MainMenu(CarGroupUI carGroupUI, CarUI carUI, RentalContractUI rentalContractUI) {
		 this.carGroupUI = carGroupUI;
		 this.carUI = carUI;
		 this.rentalContractUI = rentalContractUI;

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
				case 7:
					carUI.registerCar();
					break;
				case 8:
					carUI.listCars();
					break;
				case 9:
					carUI.searchCarById();
					break;
				case 10:
					carUI.searchCarByBrand();
					break;
				case 11:
					carUI.searchCarByLicensePlate();
					break;
				case 12:
					rentalContractUI.registerRentalContract();
					break;
				case 13:
					rentalContractUI.listRentalContracts();
					break;
				case 14:
					rentalContractUI.searchRentalContractById();
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
		System.out.println("7. Register Car");
		System.out.println("8. List All Cars");
		System.out.println("9. Search Car by ID");
		System.out.println("10. Search Car by Brand");
		System.out.println("11. Search Car by License Plate");
		System.out.println("12. Register Rental Contract");
		System.out.println("13. List All Rental Contracts");
		System.out.println("14. Search Rental Contract by ID");
		System.out.println("=============================");
		System.out.println("0. Exit\n\n");
		option = Console.readInteger("Please choose an option");
		return option;
	}
}
