
package lab5;
import java.util.*;

interface hinh {
    float PI= 3.14f;
    void nhap();
    void xuat();
    float dientich();
}

class Hinhvuong implements hinh {
    private float canh;

    public Hinhvuong() {
        this.canh = 0;
    }

    public Hinhvuong(float canh) {
        this.canh = canh;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap canh hinh vuong: ");
        canh = sc.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh vuong - Canh: " + canh + ", Dien tich: " + dientich());
    }

    @Override
    public float dientich() {
        return canh * canh;
    }
}

class hinhchunhat implements hinh {
    private float dai;
    private float rong;

    public hinhchunhat() {
        this.dai = 0;
        this.rong = 0;
    }

    public hinhchunhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }

    @Override
    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        dai = nhap.nextFloat();
        System.out.print("Nhap chieu rong: ");
        rong = nhap.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh chu nhat - Dai: " + dai + ", Rong: " + rong + ", Dien tich: " + dientich());
    }

    @Override
    public float dientich() {
        return dai * rong;
    }
}

class hinhtron implements hinh {
    private float bankinh;

    public hinhtron() {
        this.bankinh = 0;
    }

    public hinhtron(float bankinh) {
        this.bankinh = bankinh;
    }

    @Override
    public void nhap() {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap ban kinh hinh tron: ");
        bankinh = nhap.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh tron - Ban kinh: " + bankinh + ", Dien tich: " + dientich());
    }

    @Override
    public float dientich() {
        return PI * bankinh * bankinh;
    }
}

public class bai2{
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhap so luong hinh: ");
        int n = nhap.nextInt();
        nhap.nextLine(); 
        hinh ds[] = new hinh[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Chon loai hinh se nhap: ");
            System.out.println("1: hinh vuong");
            System.out.println("2: hinh chu nhat");
            System.out.println("3: hinh tron");
            int chon = 0;
            switch (chon) {
                case 1:
                    ds[i] = new Hinhvuong();
                    ds[i].nhap();
                    break;
                case 2:
                    ds[i] = new hinhchunhat();
                    ds[i].nhap();
                    break;
                case 3:
                    ds[i] = new hinhtron();
                    ds[i].nhap();
                    break;
                default:
                    System.out.println("Ban phai chon 1 trong 3 loai tren");
                    i--;
            }
        }

        System.out.println("Danh sach cac hinh:");
        for (hinh h : ds) {
            h.xuat();
        }

        hinh hinhDienTichLonNhat = ds[0];
        for (hinh h : ds) {
            if (h.dientich() > hinhDienTichLonNhat.dientich()) {
                hinhDienTichLonNhat = h;
            }
        }

        System.out.println("Hinh co dien tich lon nhat:");
        hinhDienTichLonNhat.xuat();
    }
}
