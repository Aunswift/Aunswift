import java.util.Scanner;

public class SatinAlma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kaç tane ürün almak istediğinizi girin: ");
        int urunSayisi = scanner.nextInt();
        scanner.nextLine();

        String[] urunAdlari = new String[urunSayisi];
        double[] urunFiyatlari = new double[urunSayisi];

        for (int i = 0; i < urunSayisi; i++) {
            System.out.print("Almak istediğiniz " + (i + 1) + ". ürünün adını giriniz: ");
            urunAdlari[i] = scanner.nextLine();
            System.out.print("Lütfen " + urunAdlari[i] + " ürününün fiyatını giriniz: ");
            urunFiyatlari[i] = scanner.nextDouble();
            scanner.nextLine();
        }

        //ürün fiyatları toplamı
        double ihtiyacPara = 0d;
        for (int j = 0; j < urunSayisi; j++) {
            ihtiyacPara += urunFiyatlari[j];
        }
        System.out.println("Toplamda " + urunSayisi + " tane ürün için toplamda " + ihtiyacPara +
                " TL'ye ihtiyacınız var");

        System.out.print("Bu ödemeyi kaç kartınızla yapacaksınız: ");
        int kartSayisi = scanner.nextInt();
        scanner.nextLine();

        String[] kartAdlari = new String[kartSayisi];
        double kartBakiyesi[] = new double[kartSayisi];

        double toplamPara = 0d;
        for (int k = 0; k < kartSayisi; k++) {
            if (k >= 1) {
                System.out.println("Eğer isterseniz \"bakiye\" yazarak şu ana kadar girdiğiniz " +
                        "bakiyeyi kontrol edebilirsiniz.");
            }
            System.out.print((k + 1) + ". kartınızın adı nedir: ");
            String girdi = scanner.nextLine();
            if (girdi.equalsIgnoreCase("bakiye")) {
                System.out.print("Şimdiye kadar girdiğiniz bütün miktar: " + toplamPara + "\n İşleminize devam etmek istiyor musunuz?(evet-hayır): ");
                String girdi2 = scanner.nextLine();
                if (girdi2.equalsIgnoreCase("evet")) {
                    System.out.print((k + 1) + ". kartınızın adını giriniz: ");
                    girdi = scanner.nextLine();
                } else {
                    System.out.print("İşleminiz sonlanmıştır...");
                    break;
                }
            }
            kartAdlari[k] = girdi;
            System.out.print(kartAdlari[k] + " kartınızda ne kadar bakiye var: ");
            kartBakiyesi[k] = scanner.nextDouble();
            scanner.nextLine();
            toplamPara += kartBakiyesi[k];
        }


        System.out.print("Toplamda " + toplamPara + " TL'niz var. ");

        if (ihtiyacPara - toplamPara > 0) {
            System.out.println(" Maalesef ki bu almak istediğiniz ürünler için yeterli değil. Toplamda " +
                    (ihtiyacPara - toplamPara) + " TL'ye daha ihtiyacınız var.");
        } else {
            System.out.println(" İstediklerinizi alabiliyorsunuz. Geriye " + (toplamPara - ihtiyacPara) +
                    " TL'niz kalıyor.");
        }
    }
}
