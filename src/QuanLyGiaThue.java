import java.util.Arrays;
import java.util.List;

public class QuanLyGiaThue {
    private List<GiaThueSanh> dsGiaThue;

    public void themGiaThue(GiaThueSanh... dsGiaThue) {
        this.dsGiaThue = Arrays.asList(dsGiaThue);
    }


    public List<GiaThueSanh> getDsGiaThue() {
        return dsGiaThue;
    }

    public void setDsGiaThue(List<GiaThueSanh> dsGiaThue) {
        this.dsGiaThue = dsGiaThue;
    }
}
