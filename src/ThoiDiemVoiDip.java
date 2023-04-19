public class ThoiDiemVoiDip extends ThoiDiemThue{
    private Dip dip;

    public ThoiDiemVoiDip(NgayThue ngayThue, BuoiThue buoiThue, Dip dip) {
        super(ngayThue, buoiThue);
        this.dip = dip;
    }

    public Dip getDip() {
        return dip;
    }

    public void setDip(Dip dip) {
        this.dip = dip;
    }
}
