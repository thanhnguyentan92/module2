package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
abstract class BenhAn{
    private int soThuTu;
    private String maBenhAn;
    private String Ten;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String liDoNhapVien;
    public BenhAn(int soThuTu, String maBenhAn, String ten, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.soThuTu = soThuTu;
        this.maBenhAn = maBenhAn;
        this.Ten = ten;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.liDoNhapVien = lyDoNhapVien;
    }
    abstract public void Display_Information();
    abstract public String toString();
    public String getMaBenhAn() {
        return maBenhAn;
    }

    public String getTen() {
        return Ten;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public String getLiDoNhapVien() {
        return liDoNhapVien;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public void setLiDoNhapVien(String liDoNhapVien) {
        this.liDoNhapVien = liDoNhapVien;
    }


    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }
}

 class BenhAnThuong extends BenhAn{
     private double phiNamVien;
     BenhAnThuong(int soThuTu, String maBenhAn, String Ten, String ngayNhapVien, String ngayRavien, String lido, double phiNamVien){
         super(soThuTu,maBenhAn,Ten,ngayRavien,ngayRavien,lido);
         this.phiNamVien = phiNamVien;
     }
    public double getPhiNamVien() {
         return phiNamVien;
     }

     public void setPhiNamVien(double phiNamVien) {
         this.phiNamVien = phiNamVien;
     }


    @Override
    public void Display_Information() {
        System.out.println("So thu tu "+ getSoThuTu()+", "+ " Ma benh an "+ getMaBenhAn() + "Ten Benh An "+ getTen()+ "Ngay Nhap Vien  "+ getNgayNhapVien()
            +"Ngay Ra Vien "+ getNgayRaVien() + " Ly do nhap vien "+getLiDoNhapVien()+ " Phi nam vien"+ getPhiNamVien()
        );
    }
    public String toString(){
         return getSoThuTu() + "," + getMaBenhAn() + "," + getTen() + "," + getNgayNhapVien() + "," +getNgayRaVien() + "," + getLiDoNhapVien()+ ","+ getPhiNamVien();
    }
}
class QuanLyBenhAn{
    private ArrayList<BenhAn> danhsachBenhAn;
    private String fileName = "medical_record.csv";
    public  QuanLyBenhAn(){
        danhsachBenhAn = new ArrayList<>();

    }
    public void themBenhAn(BenhAn benhAn) {
        danhsachBenhAn.add(benhAn);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(benhAn.toString());
            bw.newLine();
            System.out.println("them vao file.");
        } catch (IOException e) {
            System.out.println("loi ghi: " + e.getMessage());
        }
    }

}
public class Main {
    public static void main(String[] args) throws ParseException {
        QuanLyBenhAn quanLy = new QuanLyBenhAn();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.println("1. Them Benh An");
            System.out.println("2. Xoa ");
            System.out.println("3. Hien Thi");
            System.out.println("4. Thoat");
            System.out.print("Chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("so thu tu: ");
                    int soThuTu = scanner.nextInt();
                    System.out.print("Ma benh an: ");
                    String maBenhAn = scanner.nextLine();
                    System.out.print("Ten Benh Nhan: ");
                    String tenBenhNhan = scanner.nextLine();
                    System.out.print("Ngay Nhap: ");
                    String ngayNhap = scanner.nextLine();
                    System.out.print("Ngay Xuat: ");
                    String ngayRavien = scanner.nextLine();
                    System.out.print("Li Do: ");
                    String liDo = scanner.nextLine();
                    double phiNamVien = scanner.nextDouble();
                    System.out.print("Loai benh an (1: Thuong, 2: VIP): ");
                    int loai = scanner.nextInt();
                    scanner.nextLine();

                    if (loai == 1) {
                        BenhAn benhAnThuong = new BenhAnThuong(soThuTu, maBenhAn, tenBenhNhan, ngayNhap, ngayRavien, liDo, phiNamVien);

                        quanLy.themBenhAn(benhAnThuong);
                    } else if (loai == 2) {
                        System.out.print("Nhập gói VIP: ");
                        String goiVIP = scanner.nextLine();
                        //   BenhAn benhAnVIP = new BenhAnVIP(maBenhAn, tenBenhNhan, ngayNhap, goiVIP);
                        //   quanLy.themBenhAn(benhAnVIP);
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã bệnh án cần xóa: ");
                    String maBenhAnXoa = scanner.nextLine();
                    //  quanLy.xoaBenhAn(maBenhAnXoa);
                    break;
            }
        }
    }}