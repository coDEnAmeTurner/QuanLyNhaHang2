import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class BaoCaoDoanhThu {
    private List<HoaDon> dsHoaDon = new ArrayList<>();
    public void themHoaDon(HoaDon...hoaDons){
        this.dsHoaDon.addAll(Arrays.asList(hoaDons));
    }
    public double theoThang(int thang, int nam) {
        List<HoaDon> listFilter = this.dsHoaDon.stream().filter(hoaDon ->
                hoaDon.getBuaTiec().getThoiDiemThue().getNgayThue().getMonth() == thang && hoaDon.getBuaTiec().getThoiDiemThue().getNgayThue().getYear() == nam
        ).collect(Collectors.toList());
        return listFilter.stream().mapToDouble(HoaDon::tinhTongTien).sum();
    }
    public double theoQuy(int quy, int nam){
        Calendar calendar = Calendar.getInstance();
        List<HoaDon> listFilter = this.dsHoaDon.stream().filter(hoaDon -> {
            calendar.setTime(hoaDon.getBuaTiec().getThoiDiemThue().getNgayThue());
            int quater = (calendar.get(Calendar.MONTH)/3)+1;
            return ((quater == quy) && calendar.get(Calendar.YEAR) == nam);
        }).collect(Collectors.toList());
        return listFilter.stream().mapToDouble(HoaDon::tinhTongTien).sum();
    }

    public List<HoaDon> getDsHoaDon() {
        return dsHoaDon;
    }

    public void setDsHoaDon(List<HoaDon> dsHoaDon) {
        this.dsHoaDon = dsHoaDon;
    }
}
