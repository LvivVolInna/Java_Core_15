package hw15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AppZooClub {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ZooClub club = new ZooClub();
		
		club.getZooClub().put(new Person("Olga", 15), new ArrayList<Animal>
				(Arrays.asList(new Animal("dog", "Molly"), new Animal("cat", "Smoky"), new Animal("humster", "Bob"))));
		club.getZooClub().put(new Person("Mary", 43), new ArrayList<Animal> 
				(Arrays.asList(new Animal("cat", "Snow"), new Animal("cat", "Black"))));
		club.getZooClub().put(new Person("Irena", 18), new ArrayList<Animal> 
				(Arrays.asList(new Animal("dog", "Miracle"), new Animal("dog", "Snack"))));
		club.getZooClub().put(new Person("Dan", 35), new ArrayList<Animal>
				(Arrays.asList(new Animal("rat", "Small"), new Animal("rat", "Smell"), new Animal("fish", "Gold"))));
		club.getZooClub().put(new Person("Peter", 15), new ArrayList<Animal>
				(Arrays.asList(new Animal("dog", "Lemon"), new Animal("cat", "Cute"), new Animal("parrot", "Pirate"))));

		while (true) {
			System.out.println();
			System.out.println("press 1 to add new member to ZOOclub" + "\npress 2 to add new animal to club member"
					+ "\npress 3 to delete the animal from club member "
					+ "\npress 4 to delete club member from ZOOclub"
					+ "\npress 5 to delete some animal from all club members" + "\npress 6 to sow ZOOclub"
					+ "\npress 7 to exit the program");
			switch (scanner.next()) {

			case "1": {
				club.addNewMember();

				break;
			}

			case "2": {
				club.addAnimalToMember();

				break;
			}
//
			case "3": {
				club.deleteAnimalFromMember();

				break;
			}

			case "4": {
				club.deleteMember();

				break;
			}

			case "5": {
				club.deleteAnimalFromClub();

				break;
			}

			case "6": {
				club.showClub();

				break;
			}

			case "0": {
				System.out.println("Exit");
				System.exit(0);

				break;
			}
			
			default: {
				System.out.println("Please enter number from 0 to 6!");
				break;
			}

			}

		}
	}

}
