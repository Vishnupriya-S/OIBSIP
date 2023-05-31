import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reservation  {

    private static Map<String, String> users = new HashMap<>(); 
    private static Map<String, Reservation1> reservations = new HashMap<>(); 
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        
        users.put("john", "password1");
        users.put("emma", "password2");
        users.put("jack", "password3");
       
        boolean loggedIn = false;

        boolean log = false;
        while (!loggedIn) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
           
            if (validateLogin(username, password)) {
                loggedIn = true;
                System.out.println("Login successful. Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
       
        boolean exit = false;
       
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
           
            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for using the Online Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
   
    private static boolean validateLogin(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
   
    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter from destination: ");
        String fromDestination = scanner.nextLine();
        System.out.print("Enter to destination: ");
        String toDestination = scanner.nextLine();
       
        Reservation1 reservation = new Reservation1(name, trainNumber, classType, dateOfJourney, fromDestination, toDestination);
        reservations.put(reservation.getPnrNumber(), reservation);
       
        System.out.println("Reservation successful. Your PNR number is: " + reservation.getPnrNumber());
    }
   
    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter your PNR number: ");
        String pnrNumber = scanner.nextLine();
       
        Reservation1 reservation = reservations.get(pnrNumber);
       
        if (reservation != null) {
            System.out.println("Reservation details:");
            System.out.println(reservation);
            System.out.print("Are you sure you want to cancel this reservation? (Y/N): ");
            String confirmation = scanner.nextLine();
           
            if (confirmation.equalsIgnoreCase("Y")) {
                reservations.remove(pnrNumber);
                System.out.println("Reservation cancelled successfully.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Invalid PNR number. Please try again.");
        }
    }
}

