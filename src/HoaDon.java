import java.util.GregorianCalendar;

public class HoaDon {
    private String maHoaDon;
    private double tongTien;
    private ChoThueSanh buaTiec;
    {
        maHoaDon = String.format("HD%03d",++dem);
    }
    private static int dem = 0;
    public HoaDon(ChoThueSanh buaTiec){
        this.setBuaTiec(buaTiec);
    }
    public double tinhTongTien(){
        return this.buaTiec.getGiaThueSanh().getGia() + this.buaTiec.tinhGiaDVu() + this.buaTiec.tinhGiaMenu();
    }
    public void xuatHoaDon(){
        System.out.printf("+%-60s+");
        System.out.printf("|%s:%s|","Mã hóa đơn:",this.maHoaDon);
        System.out.printf("|%s:%s|","Mã sãnh thuê",this.buaTiec.getSanhThue().getMaSanh());
        System.out.printf("|%s:%s|","Tên sãnh thuê",this.buaTiec.getSanhThue().getTenSanh());
        System.out.printf("|Ngày thuê:%s|",CauHinh.f.format(this.buaTiec.getThoiDiemThue().getNgayThue()));
        System.out.printf("%-20s%-20s%-20s","Loại","Tên loại","Đơn giá");
        this.buaTiec.getListMenu().forEach(item ->{
            System.out.printf("%-20s%-20s%-20s",item.getMaMenu(),"Menu" + item.getMaMenu(),item.tinhGia());
        });
        this.buaTiec.getListDV().forEach(item -> {
            System.out.printf("%-20s%-20s%-20s",item.getMaDV(),item.getTenDV(),item.getGiaDV());
        });
        System.out.printf("Thành tiền: %f", this.tinhTongTien());
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public ChoThueSanh getBuaTiec() {
        return buaTiec;
    }

    public void setBuaTiec(ChoThueSanh buaTiec) {
        this.buaTiec = buaTiec;
    }

}
