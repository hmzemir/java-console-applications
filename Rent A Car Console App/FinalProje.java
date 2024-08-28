import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinalProje {
    static int toplamFiyat;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Araç listesini oluştur
        List<Arac> araclar = new ArrayList<>();
        araclar.add(new Arac("BMW", 39500, "X7 40d xDrive", 2023, "Dizel", "34HMZ35"));
        araclar.add(new Arac("BMW", 14999, "M5 Competition", 2023, "Benzin", "35HMZ35"));
        araclar.add(new Arac("BMW", 4760, "420d M Sport", 2013, "Dizel", "36HMZ35"));
        araclar.add(new Arac("Mercedes-Benz", 5999, "EQS 580", 2022, "Elektrik", "39HMZ35"));
        araclar.add(new Arac("Mercedes-Benz", 48000, "Maybach S580", 2023, "Benzin", "40HMZ35"));
        araclar.add(new Arac("Audi", 7899, "A4 Sedan 45 TFSI Quattro S Line", 2023, "Benzin", "45HMZ35"));
        araclar.add(new Arac("Audi", 13000, "R8 5.2 FSI Quattro", 2017, "Benzin", "56HMZ35"));
        araclar.add(new Arac("Volkswagen", 12500, "Golf 2.0 TSI R 4Motion", 2023, "Benzin", "47HMZ35"));
        araclar.add(new Arac("Volvo", 6499, "V90 Cross Country 2.0 D B5 Plus Bright", 2022, "Dizel", "51HMZ35"));

        System.out.println("HMZEMİR RENT A CAR'A HOŞ GELDİNİZ!\n");

        // Markaları listele
        System.out.println("Lütfen bir marka seçin:");
        List<String> markalar = new ArrayList<>();
        for (Arac arac : araclar) {
            if (!markalar.contains(arac.getMarka())) {
                markalar.add(arac.getMarka());
            }
        }

        for (int i = 0; i < markalar.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + markalar.get(i));
        }

        int markaSecim = scanner.nextInt();
        if (markaSecim < 1 || markaSecim > markalar.size()) {
            System.out.println("Geçersiz seçim!");
            return;
        }

        String seciliMarka = markalar.get(markaSecim - 1);

        // Seçilen markanın araçlarını listele
        System.out.println(seciliMarka + " markasına ait araçları seçin:");
        List<Arac> seciliMarkaAraclar = new ArrayList<>();
        for (Arac arac : araclar) {
            if (arac.getMarka().equals(seciliMarka)) {
                seciliMarkaAraclar.add(arac);
            }
        }

        for (int i = 0; i < seciliMarkaAraclar.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + seciliMarkaAraclar.get(i));
        }

        int aracSecim = scanner.nextInt();
        if (aracSecim < 1 || aracSecim > seciliMarkaAraclar.size()) {
            System.out.println("Geçersiz seçim!");
            return;
        }

        Arac seciliArac = seciliMarkaAraclar.get(aracSecim - 1);

        System.out.println("KİRALAMAK İSTEDİĞİNİZ GÜN SAYISI: ");
        int gün = scanner.nextInt();

        toplamFiyat = seciliArac.getGünlükFiyat() * gün;

        System.out.println("EK ÖZELLİKLER\n");
        System.out.println("Araç Sigortası = 2000TL (1)");
        System.out.println("Bebek Koltuğu = 250TL (2)");
        System.out.println("BU ADIMI GEÇ (0)");

        int secimEk = scanner.nextInt();
        toplamFiyat = ekOzellikEkle(secimEk, toplamFiyat);

        seciliArac.kiralamaBilgileriYazdır(toplamFiyat);

        System.out.println("HMZEMİR RENT A CAR İYİ YOLCULUKLAR DİLER...");
    }

    private static int ekOzellikEkle(int secimEk, int mevcutFiyat) {
        switch (secimEk) {
            case 1:
                return mevcutFiyat + 2000;
            case 2:
                return mevcutFiyat + 250;
            default:
                return mevcutFiyat;
        }
    }
}

class Arac {
    private String marka;
    private int günlükFiyat;
    private String model;
    private int yil;
    private String yakitTürü;
    private String plaka;

    public Arac(String marka, int günlükFiyat, String model, int yil, String yakitTürü, String plaka) {
        this.marka = marka;
        this.günlükFiyat = günlükFiyat;
        this.model = model;
        this.yil = yil;
        this.yakitTürü = yakitTürü;
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public int getGünlükFiyat() {
        return günlükFiyat;
    }

    @Override
    public String toString() {
        return "MODEL: " + model + " - FİYAT(Gün): " + günlükFiyat + "TL - YIL: " + yil + " - YAKIT TÜRÜ: " + yakitTürü + " - PLAKA: " + plaka;
    }

    public void kiralamaBilgileriYazdır(int toplamFiyat) {
        System.out.println("KİRALADIĞINIZ ARAÇ BİLGİLERİ:\n");
        System.out.println("MARKA: " + marka);
        System.out.println("MODEL: " + model);
        System.out.println("YIL: " + yil);
        System.out.println("YAKIT TÜRÜ: " + yakitTürü);
        System.out.println("PLAKA: " + plaka);
        System.out.println("TOPLAM TUTAR: " + toplamFiyat + "TL");
    }
}
