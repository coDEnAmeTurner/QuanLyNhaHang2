public class GiaThueSanh {
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

    public void setThoiDiem(ThoiDiemThue thoiDiem) {
        this.thoiDiem = thoiDiem;
    }
}
