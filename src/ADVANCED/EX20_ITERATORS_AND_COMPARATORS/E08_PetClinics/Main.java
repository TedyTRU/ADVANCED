package ADVANCED.EX20_ITERATORS_AND_COMPARATORS.E08_PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Clinic clinic = new Clinic("asd", 5);
//        for (int i = 1; i <= 3; i++) {
//            Pet pet = new Pet("pet" + i, 5, "cat");
//            clinic.AddPet(pet);
//        }
//        clinic.release();
//        clinic.printClinicRoomInfo(2);
//

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    if (tokens[1].equals("Pet")) {
                        //create pet
                        String petName = tokens[2];
                        Pet pet = new Pet(petName,
                                Integer.parseInt(tokens[3]), tokens[4]);
                        pets.putIfAbsent(petName, pet);

                    } else {
                        //create clinic
                        try {
                            String clinicName = tokens[2];
                            Clinic clinic = new Clinic(clinicName, Integer.parseInt(tokens[3]));
                            clinics.putIfAbsent(clinicName, clinic);

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);
                    System.out.println(clinic.addPet(pet));
                    break;
                case "Release":
                    Clinic c = clinics.get(tokens[1]);
                    System.out.println(c.release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Print":
                    String clinikName = tokens[1];
                    Clinic klinik = clinics.get(clinikName);
                    if (tokens.length == 2) {
                        //print each room in the specified clinic
                        for (Pet p : klinik.getPets()) {
                            if (p == null) {
                                System.out.println("Room empty");
                            } else {
                                System.out.println(p.toString());
                            }
                        }

                    } else {
                        int room = Integer.parseInt(tokens[2]);
                        klinik.printClinicRoomInfo(room);
                    }
                    break;
            }
        }

    }
}
