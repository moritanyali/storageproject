package StorageProjectMain;


import java.util.Map;
import java.util.Scanner;

public class Storage extends MainStorage{
    Scanner input = new Scanner(System.in);





    public void mainMenu(){
        char button;

        System.out.println("---------DEPO SISTEMI ISLEMLER SAYFASI---------");
        System.out.println();
        do{
            System.out.println("Lutfen yapmak istediginiz islemi seciniz");
            System.out.println("1- Urun Girisi");
            System.out.println("2- Stok Listeleme");
            System.out.println("3- Arama");
            System.out.println("4- Islem Gecmisi Goruntule");
            System.out.println("Q- Ana Menu");



            button = input.next().toLowerCase().charAt(0);

            switch (button){
                case '1':
                    System.out.println("Lutfen eklemek istediginiz urun kodunu ve adetini yaziniz");
                    boolean validInput = false;
                    while (!validInput){
                        try {
                            urunEkleme(input.next().toUpperCase(), input.nextInt());
                            break;
                        }catch (Exception e){
                            System.out.println("Lutfen stok miktarini rakam olarak giriniz");

                        }


                    }

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




    public void urunEkleme(String urun, int adet){




           Integer numOfOccurence = stokListesi.get(urun);

            if(numOfOccurence==null ){




                if (adet<1){
                    System.out.println("Lutfen gecerli bir stok adeti giriniz." + "\n");

                }else {

                    try {
                        stokListesi.replace(urun, stokListesi.get(urun) + adet);
                    }
                    catch (Exception e){
                        System.out.println("Isleniyor...");

                    }


                    stokListesi.put(urun, adet);
                    islemGecmisi.add("Stoga " + adet + " adet " + urun + " eklendi.");
                    if(islemGecmisi.size()==6){
                        islemGecmisi.remove();
                    }

                    System.out.println("----------Urun stoga eklenmistir----------");
                    System.out.println();


                }

            } else {
                stokListesi.replace(urun, stokListesi.get(urun) + adet);
                islemGecmisi.add("Stoga " + adet + " adet " + urun + " eklendi.");
                if(islemGecmisi.size()==6){
                    islemGecmisi.remove();
                }

                System.out.println("----------Urun stoga eklenmistir----------");
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
            System.out.println(w);
        }
        System.out.println();
    }
}


