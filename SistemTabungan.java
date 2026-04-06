import java.util.*;

class Student {
    String nama;
    int saldo;

    public Student(String nama) {
        this.nama = nama;
        this.saldo = 0;
    }
    public void tambahSaldo(int nominal) {
        this.saldo += nominal;
    }
    public boolean tarikSaldo(int nominal) {
        if (this.saldo >= nominal) {
            this.saldo -= nominal;
            return true;
        }
        return false;
    }
    public String jenis() {
        return "Student";
    }
}

class Reguler extends Student {
    public Reguler(String nama) {
        super(nama);
    }
    public String jenis() {
        return "REGULER";
    }
}

class Beasiswa extends Student {
    public Beasiswa(String nama) {
        super(nama);
    }
    public boolean tarikSaldo(int nominal) {
        int yangDipotong = nominal - 1000;
        if (yangDipotong < 0) yangDipotong = 0;

        if (this.saldo >= yangDipotong) {
            this.saldo -= yangDipotong;
            return true;
        }
        return false;
    }
    public String jenis() {
        return "BEASISWA";
    }
}

public class SistemTabungan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();//biar outputnya tidak berantakan
        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 

        HashMap<String, Student> listSiswa = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String inputan = sc.nextLine();
            String[] p = inputan.split(" ");
            String perintah = p[0];

            if (perintah.equals("CREATE")) {
                String tipe = p[1];
                String nm = p[2];

            if (listSiswa.containsKey(nm)) {
                 System.out.println("Akun sudah terdaftar");
             } else {
                if (tipe.equals("REGULER")) {
                    listSiswa.put(nm, new Reguler(nm));
                } else {
                    listSiswa.put(nm, new Beasiswa(nm));
                }
                System.out.println(tipe + " " + nm + " berhasil dibuat");
                }

        } else if (perintah.equals("SAVE")) {
            String nm = p[1];
            int duit = Integer.parseInt(p[2]);

            if (listSiswa.get(nm) == null) {
                 System.out.println("Akun tidak ditemukan");
                } else {
                    listSiswa.get(nm).tambahSaldo(duit);
                    System.out.println("Saldo " + nm + ": " + listSiswa.get(nm).saldo);
                }

         } else if (perintah.equals("TAKE")) {
            String nm = p[1];
            int duit = Integer.parseInt(p[2]);

            if (listSiswa.get(nm) == null) {
                 System.out.println("Akun tidak ditemukan");
                } else {
                    Student mhs = listSiswa.get(nm);
                    if (mhs.tarikSaldo(duit)) {
                        System.out.println("Saldo " + nm + ": " + mhs.saldo);
                    } else {
                         System.out.println("Saldo " + nm + " tidak cukup");
                    }
                }

        } else if (perintah.equals("CHECK")) {
            String nm = p[1];
            if (listSiswa.get(nm) == null) {
                System.out.println("Akun tidak ditemukan");
                } else {
                    Student mhs = listSiswa.get(nm);
                    System.out.println(mhs.nama + " | " + mhs.jenis() + " | saldo: " + mhs.saldo);
                }
            }
        }
        sc.close();
    }
}

//Saya masi kurang paham kak, yang bagian easy sama medium, karna melihat outputnya sangat berantakan
