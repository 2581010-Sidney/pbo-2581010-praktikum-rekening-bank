import java.util.Scanner;

public class BankMini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rekening rekening = new Rekening("001","Ani", 100000);

        //bukti encapsulation: baris bawah tidak bisa di compile
        //rekening.saldo=100000;
        //pesan error: java: saldo has private access in Rekening;

        System.out.println("============ BANK MINI ============");
        System.out.println("Rekening " + rekening.getNomor() + " a.n " + rekening.getPemilik());


        int pilihan;
        do {
            System.out.print("Menu (1 Setor, 2 Tarik, 3 Info, 0 Keluar): ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Jumlah setor: ");
                    int setor = input.nextInt();
                    if (rekening.setor(setor)) {
                        System.out.println("Setor berhasil.");
                    } else {
                        System.out.println("Setor ditolak: jumlah harus lebih dari 0.");
                    }
                    break;
                case 2:
                    System.out.print("Jumlah ditarik: ");
                    int tarik = input.nextInt();
                    if (rekening.tarik(tarik)) {
                        System.out.println("Tarik berhasil.");
                    } else {
                        System.out.println("Tarik ditolak: jumlah tidak valid atau saldo tidak cukup.");
                    }
                    break;
                case 3:
                    rekening.cetakInfo();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Menu tidak dikenal");
            }
        }  while (pilihan != 0);

        System.out.println();
        System.out.println("============ Saldo akhir ============");
        rekening.cetakInfo();
    }
}