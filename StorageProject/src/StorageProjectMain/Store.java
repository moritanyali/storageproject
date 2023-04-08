package StorageProjectMain;

import java.util.Map;
import java.util.Scanner;

public class Store extends MainStorage{
    Scanner input = new Scanner(System.in);


    public void mainMenu(){
        char button;

        System.out.println("---------DEPO SISTEMI ISLEMLER SAYFASI---------");
        System.out.println();
        do{
            System.out.println("Lutfen yapmak istediginiz islemi seciniz");
            System.out.println("1- Urun Cikisi");
            System.out.println("2- Stok Listeleme");
            System.out.println("3- Arama");
            System.out.println("4- Islem Gecmisi Goruntule");
            System.out.println("Q- Ana Menu");

            button = input.next().toLowerCase().charAt(0);

            switch (button){
                case '1':
                    System.out.println("Lutfen cikisini yapmak istediginiz urunun kodunu ve adetini yaziniz");
                    urunCikarma(input.next().toUpperCase(), input.nextInt());

                    break;
                case '2': urunListeleme();
                    break;

                case '3': System.out.println("Lutfen arama yapmak istediginiz urunun kodunu giriniz");
                    arama(input.next().toUpperCase());

                    break;
                case '4': islemGecmisiGorme();
                break;

            }
        }while(button!='q');
    }




    public void urunCikarma(String urun, int adet){




        Integer numOfOccurence = stokListesi.get(urun);

        if(numOfOccurence==null){

            if (adet<1){
                System.out.println("Lutfen gecerli bir adet giriniz." + "\n");

            }else {stokListesi.remove(urun, adet);
                System.out.println("----------Urun stoktan cikilmistir----------");
                System.out.println();

                try {
                    stokListesi.remove(urun, adet);
                }catch (Exception e){
                    System.out.println("Isleniyor...");
                }
            }

        } else {
            stokListesi.replace(urun, stokListesi.get(urun) - adet);
            islemGecmisi.add("Stoktan " + adet + " adet " + urun + " cikildi.");
            if (stokListesi.get(urun)<1){
                islemGecmisi.add(urun + " stogu tukendi!");
                System.out.println(urun + " stogu tukendi!");
                stokListesi.remove(urun);
                islemGecmisi.remove();


                if(islemGecmisi.size()==6){
                    islemGecmisi.remove();
                }
            }
            else if(islemGecmisi.size()==6){
                islemGecmisi.remove();
            }
            System.out.println("----------Urun stoktan cikilmistir----------");
            System.out.println();

        }

    }

    @Override
    public void urunListeleme() {
        System.out.println("|*******BEYAZ ESYA STOK LISTESI*******|");
        for(Map.Entry<String, Integer> w : stokListesi.entrySet()){
            System.out.println(w.getKey() + " - " + w.getValue());
        }
        System.out.println();
    }




    @Override
    public void arama(String arananUrun) {
        if (stokListesi.get(arananUrun) == null){
            System.out.println("Stok bilgisi bulunamadi" + "\n");
        }else{
            System.out.println(arananUrun + " adeti = " +(stokListesi.get(arananUrun)) +"\n");
        }
    }

    @Override
    public void islemGecmisiGorme() {
        System.out.println("|*******STOK HAREKET GECMISI*******|");
        for(String w : islemGecmisi){
            System.out.println("- " + w);
        }
        System.out.println();
    }
}


