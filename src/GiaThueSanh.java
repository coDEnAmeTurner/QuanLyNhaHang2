public class GiaThueSanh {

    private static int dem = 0;

    private int ma = ++dem;
    private double gia;
    private ThoiDiemThue thoiDiem;

    public GiaThueSanh(double gia, ThoiDiemThue thoiDiem) {
        this.gia = gia;
        this.thoiDiem = thoiDiem;
    }


    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public ThoiDiemThue getThoiDiem() {
        return thoiDiem;
    }

    public void hienThi(){
        this.thoiDiem.hienThi();
        System.out.printf("%-20s%-20s",this.ma, this.gia);
    }

    public void setThoiDiem(ThoiDiemThue thoiDiem) {
        this.thoiDiem = thoiDiem;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }
}
