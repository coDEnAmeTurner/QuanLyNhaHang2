import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CauHinh {
    public static final Scanner sc = new Scanner(System.in);
    public static final SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    public static final void hienTieuDeDichVu(){
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ","Thời gian thuê","Tên ca sĩ","Số lượng bài hát");
    }
    public static final void hienTieuDeDoAnUong(){
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Mã đồ ăn (uống)", "Tên đồ ăn (uống)", "Giá đồ ăn (uống)", "Chay","Hãng sản xuất");
    }
}
