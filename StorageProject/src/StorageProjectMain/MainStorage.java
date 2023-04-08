package StorageProjectMain;

import java.util.*;


public abstract class MainStorage {



    static LinkedHashMap<String, Integer> stokListesi = new LinkedHashMap<>();
    static Queue<String> islemGecmisi = new LinkedList<>();
     public abstract void urunListeleme();

     public abstract void islemGecmisiGorme();

     public abstract void mainMenu();

     public abstract void arama(String urunMiktari);








    }



