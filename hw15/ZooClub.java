package hw15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ZooClub {

	Map<Person, ArrayList<Animal>> zooClub = new HashMap<Person, ArrayList<Animal>>();

	public Map<Person, ArrayList<Animal>> getZooClub() {
		return zooClub;
	}
	
	public void addNewMember() {
		System.out.println("Enter the name of new club member");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Enter age of new club member");
		int age = sc.nextInt();

		Person person = new Person(name, age);

		System.out.println("Enter number of his/her animals");
		int number = sc.nextInt();
		ArrayList<Animal> list = new ArrayList<Animal>();

		if (number >= 1) {
			for (int i = 0; i < number; i++) {

				System.out.println("Enter the type of his/her animal");
				String type = sc.next();

				System.out.println("Enter the animalName of this animal");
				String animalName = sc.next();

				Animal animal = new Animal(type, animalName);

				list.add(animal);
			}
		}
		zooClub.put(person,list);
		showClub();
	}

	public void addAnimalToMember() {
		System.out.println("Enter the name of club member");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Enter age of club member");
		int age = sc.nextInt();

		Person person = new Person(name, age);

		boolean typeCorrect = isPersonExists(zooClub, name, age);
		
		if (typeCorrect) {
			System.out.println("Enter the type of his/her new animal");
			String type = sc.next();
			System.out.println("Enter the animalName of this animal");
			String animalName = sc.next();

			Animal newAnimal = new Animal(type, animalName);

			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();
				
				if (next.getKey().equals(person)) {
					ArrayList<Animal> value = next.getValue();
					value.add(newAnimal);
					next.setValue(value);
				}
			}
		} else {
			System.out.println("This person is not the club member");
		}
		System.out.println("---------");
		showClub();
	}

	public void deleteAnimalFromMember() {
		System.out.println("Enter the name of club member");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Enter age of club member");
		int age = sc.nextInt();
		Person person = new Person(name, age);

		boolean typeCorrect = isPersonExists(zooClub, name, age);

		if (typeCorrect) {
			System.out.println("Enter the type of animal");
			String type = sc.next();
			System.out.println("Enter the animalName of animal");
			String animalName = sc.next();
			Animal animal = new Animal(type, animalName);

			boolean typeAnimalCorrect = isZooClubMemberAnimalExists(zooClub, name, age, type, animalName);

			if (typeAnimalCorrect) {
				Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

				while (iterator.hasNext()) {
					Entry<Person, ArrayList<Animal>> next = iterator.next();
					
					if (next.getKey().equals(person)) {

						ArrayList<Animal> animalList = next.getValue();
						
						Iterator<Animal> iterator1 = animalList.iterator();
						
						while (iterator1.hasNext()) {
							Animal next1 = iterator1.next();
							
							if (next1.getType().equalsIgnoreCase(type)&&next1.getName().equals(animalName)) {
								iterator1.remove();
							}

						}
					}
				}
			} else {
				System.out.println("This club member doesn`t have such an animal");
			}
		} else {
			System.out.println("This person isn`t the club member");
		}
		System.out.println("---------");
		showClub();
	}

	public void deleteMember() {

		System.out.println("Enter the name of member");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter age of member");
		int age = sc.nextInt();

		Person person = new Person(name, age);

		boolean typeCorrect = isPersonExists(zooClub, name, age);

		if (typeCorrect) {
			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();
				if (next.getKey().equals(person)) {
					iterator.remove();
				}
			}
		} else {
			System.out.println("This person isn`t the club member");
		}
		System.out.println("---------");
		showClub();
	}

	public void deleteAnimalFromClub() {
		System.out.println("Enter the type of animal");
		Scanner sc = new Scanner(System.in);
		String type = sc.nextLine();

		boolean typeCorrect = isAnimalExists(zooClub, type);

		if (typeCorrect) {

			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();

				ArrayList<Animal> animalList = next.getValue();

				Iterator<Animal> iterator1 = animalList.iterator();

				while (iterator1.hasNext()) {
					Animal next1 = iterator1.next();

					if (next1.getType().equalsIgnoreCase(type)) {
						iterator1.remove();
					}

				}

			}
		}else {
			System.out.println("There is no such animal in the club");
		}
		System.out.println("---------");
		showClub();
	}

	public void showClub() {
		if(zooClub.size()!=0) {
		for (Person person : zooClub.keySet()) {
			System.out.println(person + " has:");
			for (Animal animal : zooClub.get(person)) {
				System.out.println("      " + animal);
			}

		}
		
	}else {
		System.out.println("ZooClub is empty");}
	}
	
	private boolean isPersonExists(Map<Person, ArrayList<Animal>> zooClub, String name, int age) {
		boolean flag = false;
		
		Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> next = iterator.next();

			if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
				flag = true;
			}
		}
		return flag;
	}
	
	private boolean isAnimalExists(Map<Person, ArrayList<Animal>> zooClub, String type) {
		boolean flag = false;

		Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> next = iterator.next();

			ArrayList<Animal> animalList = next.getValue();
			Iterator<Animal> iterator2 = animalList.iterator();

			while (iterator2.hasNext()) {
				Animal next2 = iterator2.next();

				if (next2.getType().equalsIgnoreCase(type)) {
					flag = true;
				}
			}
		}
		return flag;
	}
	
	private boolean isZooClubMemberAnimalExists(Map<Person, ArrayList<Animal>> zooClub2, String name, int age,
			String type, String animalName) {
		
		boolean flag = false;
		
		Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> next = iterator.next();

			if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
				ArrayList<Animal> animalList = next.getValue();

				Iterator<Animal> iterator2 = animalList.iterator();

				while (iterator2.hasNext()) {
					Animal next2 = iterator2.next();

					if (next2.getType().equalsIgnoreCase(type) && next2.getName().equalsIgnoreCase(animalName)) {
						flag = true;
					}
				}
			}
		}
		
		return flag;
	}

}
 