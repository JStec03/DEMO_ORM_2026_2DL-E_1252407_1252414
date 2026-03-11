package isep.eapli.demo_orm.presentation;


import isep.eapli.demo_orm.application.RentalContractController;
import isep.eapli.demo_orm.domain.model.*;
import isep.eapli.demo_orm.util.Console;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentalContractUI {

    private final RentalContractController controller;

    public RentalContractUI(RentalContractController controller) {
        this.controller = controller;
    }

    public void registerRentalContract() {
        try {
            Long clientId = Long.valueOf(Console.readLine("Client ID:"));
            Long carId = Long.valueOf(Console.readLine("Car ID:"));
            LocalDate startDate = LocalDate.parse(Console.readLine("Start date (YYYY-MM-DD):"));
            LocalDate endDate = LocalDate.parse(Console.readLine("End date (YYYY-MM-DD):"));
            int numberOfDrivers = Console.readInteger("Number of authorized drivers:");
            List<AuthorizedDriver> drivers = new ArrayList<>();
            int paymentMethod = Integer.valueOf(Console.readLine("Payment method (1=Credit Card, 2=Check):"));
            LocalDate paymentDate = LocalDate.parse(Console.readLine("Payment date (YYYY-MM-DD):"));
            double amount = Console.readDouble("Payment amount:");
            Payment payment;
            if(paymentMethod == 1) {
                String cardNumber = Console.readLine("Card number:");
                payment = new CardPayment(amount, paymentDate, cardNumber);
            } else if (paymentMethod == 2) {
                String checkNumber = Console.readLine("Check number:");
                payment = new CheckPayment(amount, paymentDate, checkNumber);
            } else {
                System.out.println("Invalid payment method selected.");
                return;
            }

            for (int i = 0; i < numberOfDrivers; i++) {
                System.out.println("Authorized Driver #" + (i + 1));
                String name = Console.readLine("Name:");
                String licenseNumber = Console.readLine("Driving license number:");
                drivers.add(new AuthorizedDriver(name, licenseNumber));
            }

            RentalContract contract = controller.registerRentalContract(
                    clientId, carId, startDate, endDate, drivers, payment
            );

            System.out.println("Rental contract registered: " + contract);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listRentalContracts() {
        List<RentalContract> list = controller.listRentalContracts();

        if (list.isEmpty()) {
            System.out.println("No rental contracts found.");
        } else {
            for (RentalContract contract : list) {
                System.out.println(contract);
            }
        }
    }

    public void searchRentalContractById() {
        try {
            Long id = Long.valueOf(Console.readLine("Rental Contract ID:"));
            Optional<RentalContract> contract = controller.searchRentalContractById(id);

            if (contract.isPresent()) {
                System.out.println("Rental contract found: " + contract.get());
            } else {
                System.out.println("No rental contract found with ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        }
    }
}