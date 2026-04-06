//digabung jadi satu class
public class SewaKendaraan {
    static class DataKendaraan {
        String kode, nama, tipe;
        int harga;
        boolean status;

        DataKendaraan(String k, String n, String t, int h) {
            this.kode = k;
            this.nama = n;
            this.tipe = t;
            this.harga = h;
            this.status = true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<DataKendaraan> list = new ArrayList<>();
        if (!in.hasNextInt()) return;
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String baris = in.nextLine();
            String[] split = baris.split(" ");
            String cmd = split[0];

            if (cmd.equals("ADD")) {
                String tipe = split[1];
                String kd = split[2];
                String nm = split[3];
                int hrg = Integer.parseInt(split[4]);

                boolean ada = false;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).kode.equals(kd)) {
                        ada = true;
                        break;
                    }
                }

                if (ada) {
                    System.out.println("Kendaraan sudah terdaftar");
                } else {
                    list.add(new DataKendaraan(kd, nm, tipe, hrg));
                    System.out.println(tipe + " " + kd + " berhasil ditambahkan");
                }

            } else if (cmd.equals("RENT")) {
                String kd = split[1];
                int durasi = Integer.parseInt(split[2]);
                
                int index = -1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).kode.equals(kd)) {
                        index = j;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Kendaraan tidak ditemukan");
                } else if (list.get(index).status == false) {
                    System.out.println("Kendaraan sedang disewa");
                } else {
                    DataKendaraan k = list.get(index);
                    int bayar = k.harga * durasi;
                    
                    if (split.length == 4 && split[3].equalsIgnoreCase("promo")) {
                        if (k.tipe.equals("CAR")) bayar -= 20000;
                        else bayar -= 10000;
                    }
                    if (bayar < 0) bayar = 0;

                    k.status = false;
                    System.out.println("Total sewa " + kd + ": " + bayar);
                }

            } else if (cmd.equals("RETURN")) {
                String kd = split[1];
                int index = -1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).kode.equals(kd)) {
                        index = j;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Kendaraan tidak ditemukan");
    
                } else if (list.get(index).status == true) {
                    System.out.println("Kendaraan belum disewa");

                } else {
                    list.get(index).status = true;
                    System.out.println(kd + " berhasil dikembalikan");
                }

            } else if (cmd.equals("DETAIL")) {
                String kd = split[1];
                boolean ketemu = false;
                for (DataKendaraan k : list) {
                    if (k.kode.equals(kd)) {
                        String s = k.status ? "TERSEDIA" : "DISEWA";
                        System.out.println(k.kode + " | " + k.tipe + " | " + k.nama + " | harga: " + k.harga + " | status: " + s);
                        ketemu= true;
                        break;
                    }
                }
                if(!ketemu){
                    System.out.println("Kendaraan tidak ditemukan");
                }

            } else if (cmd.equals("COUNT")) {
                System.out.println("Total kendaraan: " + list.size());
            }
        }
    }
}
