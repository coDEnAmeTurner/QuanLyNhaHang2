import java.util.Date;

public class ThoiDiemThue {
    private Date ngayThue;
    private BuoiThue buoiThue;

    public ThoiDiemThue(Date ngayThue, BuoiThue buoiThue) {
        this.ngayThue = ngayThue;
        this.buoiThue = buoiThue;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public BuoiThue getBuoiThue() {
        return buoiThue;
    }

    public void setBuoiThue(BuoiThue buoiThue) {
        this.buoiThue = buoiThue;
    }
}
