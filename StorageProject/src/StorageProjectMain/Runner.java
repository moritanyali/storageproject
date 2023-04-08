package StorageProjectMain;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

    mainMenu();



    }

    static Scanner scn = new Scanner(System.in);
        public static void mainMenu() {
            MainStorage storage = new Storage();
            MainStorage store = new Store();

            String button;
            do {
                System.out.println();
                System.out.println("|*******BEYAZ ESYA DEPO SISTEMI ANA MENU*******|");
                System.out.println();
                System.out.println("Lutfen yapmak istediginiz islemi secin.");
                System.out.println("1- Depo calisan girisi");
                System.out.println("2- Bayi calisan girisi");
                System.out.println("Q- Cikis");
                button = scn.next();

                if (button.equalsIgnoreCase("q")) {
                    System.out.println("Depo sistemini kullandiginiz icin tesekkur ederiz.");
                    break;
                }

                switch (button){

                    case ("1"):
                        storage.mainMenu();
                        break;

                    case("2"):
                        store.mainMenu();
                        break;


                }

            } while (button.toLowerCase() != "q");

    }

}
