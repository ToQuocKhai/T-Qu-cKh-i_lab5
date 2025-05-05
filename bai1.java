package lab5;

import java.util.*;

abstract class nhanvien {
    protected String manhanvien;
    protected String tennhanvien;
    protected String trinhdo;
    protected double luongcoban;

    public nhanvien() {
        this.manhanvien = "";
        this.tennhanvien = "";
        this.trinhdo = "";
        this.luongcoban = 0.0;
    }

    public nhanvien(String manhanvien, String tennhanvien, String trinhdo) {
        this.manhanvien = manhanvien;
        this.tennhanvien = tennhanvien;
        this.trinhdo = trinhdo;
        this.luongcoban = 0.0;
    }

    public String getmanhanvien() {
        return manhanvien;
    }

    public String gettennhanvien() {
        return tennhanvien;
    }

    public String gettrinhdo() {
        return trinhdo;
    }

    public double getluongcoban() {
        return luongcoban;
    }

    public void setluongcoban(double luongcoban) {
        this.luongcoban = luongcoban;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        manhanvien = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        tennhanvien = sc.nextLine();
        System.out.print("Nhap trinh do: ");
        trinhdo = sc.nextLine();
        System.out.print("Nhap luong co ban: ");
        luongcoban = sc.nextDouble();
        sc.nextLine();
    }

    public void xuat() {
        System.out.println("Ma nhan vien: " + manhanvien + ", Ten nhan vien: " + tennhanvien + ", Trinh do: " + trinhdo + ", Luong co ban: " + luongcoban);
    }

    public abstract double tinhluong();
}

class quanly extends nhanvien {
    private String chuyenmon;
    private double phucapchucvu;

    public quanly() {
        super();
        this.chuyenmon = "";
        this.phucapchucvu = 0.0;
    }

    public quanly(String manhanvien, String tennhanvien, String trinhdo, String chuyenmon, double phucapchucvu) {
        super(manhanvien, tennhanvien, trinhdo);
        this.chuyenmon = chuyenmon;
        this.phucapchucvu = phucapchucvu;
    }

    public String getchuyenmon() {
        return chuyenmon;
    }

    public double getphucapchucvu() {
        return phucapchucvu;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        chuyenmon = sc.nextLine();
        System.out.print("Nhap phu cap chuc vu: ");
        phucapchucvu = sc.nextDouble();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chuyen mon: " + chuyenmon + ", Phu cap chuc vu: " + phucapchucvu);
    }

    @Override
    public double tinhluong() {
        return luongcoban + phucapchucvu;
    }
}

class nghiencuu extends nhanvien {
    private String chuyenmon;
    private double phucapdochai;

    public nghiencuu() {
        super();
        this.chuyenmon = "";
        this.phucapdochai = 0.0;
    }

    public nghiencuu(String manhanvien, String tennhanvien, String trinhdo, String chuyenmon, double phucapdochai) {
        super(manhanvien, tennhanvien, trinhdo);
        this.chuyenmon = chuyenmon;
        this.phucapdochai = phucapdochai;
    }

    public String getchuyenmon() {
        return chuyenmon;
    }

    public double getphucapdochai() {
        return phucapdochai;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        chuyenmon = sc.nextLine();
        System.out.print("Nhap phu cap doc hai: ");
        phucapdochai = sc.nextDouble();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chuyen mon: " + chuyenmon + ", Phu cap doc hai: " + phucapdochai);
    }

    @Override
    public double tinhluong() {
        return luongcoban + phucapdochai;
    }
}

class phucvu extends nhanvien {
    public phucvu() {
        super();
    }

    public phucvu(String manhanvien, String tennhanvien, String trinhdo) {
        super(manhanvien, tennhanvien, trinhdo);
    }

    @Override
    public double tinhluong() {
        return luongcoban;
    }
}

public class bai1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<nhanvien> danhsachnhanvien = new ArrayList<>();

        System.out.println("Nhap thong tin cho quan ly");
        quanly ql = new quanly();
        ql.nhap();

        System.out.println("Nhap thong tin cho nghien cuu");
        nghiencuu nc = new nghiencuu();
        nc.nhap();

        System.out.println("Nhap thong tin cho phuc vu");
        phucvu pv = new phucvu();
        pv.nhap();

        danhsachnhanvien.add(ql);
        danhsachnhanvien.add(nc);
        danhsachnhanvien.add(pv);

        System.out.println("Danh sach nhan vien:");
        for (nhanvien nv : danhsachnhanvien) {
            nv.xuat();
            System.out.println("Luong: " + nv.tinhluong());
        }
    }
}
