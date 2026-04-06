import java.util.Scanner;

public class Moo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String namaSapi = "";
        int beratSapi = 0;
        String jenisLayanan = "";
        String kelasLayanan = "";

        while (true) {
            System.out.print("Nama Sapi: ");
            namaSapi = sc.nextLine();
            
            boolean valid = true;
            if (namaSapi.isEmpty()) {
                valid = false;
            } else {
                for (int i = 0; i < namaSapi.length(); i++) {
                    char c = namaSapi.charAt(i);
                    //melakukan pengecekan apakah karakter merupakan huruf atau spasi
                    if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                break;
            } else {
                System.out.println("Mooo! Nama sapi harus pakai huruf, bukan angka atau simbol!");
            }
        }
        while (true) {
            System.out.print("Berat: ");
            if (sc.hasNextInt()) {
                beratSapi = sc.nextInt();
                sc.nextLine();
                if (beratSapi >= 1 && beratSapi <= 80) {
                    break;
                } else {
                    System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
                }
            } else {
                System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
                sc.nextLine();
            }
        }
        while (true) {
            System.out.print("Jenis Layanan: ");
            jenisLayanan = sc.nextLine().toLowerCase();
            if (jenisLayanan.equals("spa") || jenisLayanan.equals("potong_kuku") || jenisLayanan.equals("grooming")) {
                break;
            } else {
                System.out.println("Pilih spa, potong_kuku, atau grooming! Sapi kamu mau dirawat apa, sih?");
            }
        }
        while (true) {
            System.out.print("Kelas: ");
            kelasLayanan = sc.nextLine().toLowerCase();
            if (kelasLayanan.equals("reguler") || kelasLayanan.equals("vip")) {
                break;
            } else {
                System.out.println("Pilih reguler atau vip! Sapi kamu mau treatment sultan atau biasa aja?");
            }
        }
        double hargaPerKg = 0;
        if (jenisLayanan.equals("spa")) {
            hargaPerKg = 8000;
        } else if (jenisLayanan.equals("potong_kuku")) {
            hargaPerKg = 6000;
        } else {
            hargaPerKg = 10000;
        }

        double biayaDasar = beratSapi * hargaPerKg;

        double diskon = 0;
        if (beratSapi > 30) {
            diskon = 0.10 * biayaDasar;
        }
        double biayaTambahanVIP = 0;
        if (kelasLayanan.equals("vip")) {
            biayaTambahanVIP = 0.20 * biayaDasar;
        }
        double subtotal = biayaDasar - diskon + biayaTambahanVIP;
        double pajak = 0.08 * subtotal;
        double totalBiaya = subtotal + pajak;
        
        if (namaSapi.equalsIgnoreCase("Moo") || namaSapi.equalsIgnoreCase("Mooo") || namaSapi.equalsIgnoreCase("Moooo")) {
            totalBiaya = 0.0;
        }

        //output nota
        System.out.println("\n------ NOTA KLINIK SAPI ------");
        System.out.println("Nama Sapi: " + namaSapi);
        System.out.println("Berat: " + beratSapi + " kg");
        System.out.println("Jenis Layanan: " + jenisLayanan);
        System.out.println("Kelas: " + kelasLayanan);
        System.out.println("Biaya Dasar: Rp " + biayaDasar);
        System.out.println("Diskon: Rp " + diskon);
        System.out.println("Biaya Tambahan VIP: Rp " + biayaTambahanVIP);
        System.out.println("Subtotal: Rp " + subtotal);
        System.out.println("Pajak: Rp " + pajak);
        System.out.println("Total Biaya: Rp " + totalBiaya);
        System.out.println("-----------------------------");

        if (totalBiaya == 0) {
            System.out.println("Terima kasih, " + namaSapi + " ! Sapi spesial memang beda perlakuan~");
        } else {
            System.out.println("Terima kasih, " + namaSapi + " ! Semoga sapinya makin glow up");
        }
    }
}
