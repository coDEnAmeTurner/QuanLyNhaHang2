import java.text.ParseException;
import java.util.*;


public class Demo {
    public static void main(String[] args) throws ParseException {
        //thời điểm có sẵn
        var td1 = new ThoiDiemThue(CauHinh.f.parse("20/12/2023"), BuoiThue.CHIEU);
        var td2 = new ThoiDiemThue(CauHinh.f.parse("12/11/2023"), BuoiThue.SANG);
        var td3 = new ThoiDiemThue(CauHinh.f.parse("8/2/2023"), BuoiThue.SANG);
        var td4 = new ThoiDiemThue(CauHinh.f.parse("1/11/2022"), BuoiThue.TOI);

        //giá thuê sảnh có sẵn
        var gt1 = new GiaThueSanh(200, td1);
        var gt2 = new GiaThueSanh(100, td2);
        var gt3 = new GiaThueSanh(300, td3);
        var gt4 = new GiaThueSanh(500, td4);

        //sảnh cưới có sẵn
        SanhCuoi s1 = new SanhCuoi("Diamonds",ViTriSanh.TANG_1,50, gt1, gt2);
        SanhCuoi s2 = new SanhCuoi("Golden", ViTriSanh.TANG_1,40, gt1, gt3, gt4);
        SanhCuoi s3 = new SanhCuoi("Silver",ViTriSanh.TANG_2,30, gt2, gt4);

        //thức ăn , thức uống
        DoAnUong ta0 = new ThucAn("Súp cua",50,false);
        DoAnUong ta1 = new ThucAn("Thịt luộc", 30,false);
        DoAnUong ta2 = new ThucAn("Tôm luộc", 35,false);
        DoAnUong ta3 = new ThucAn("Rau muốn xào", 30,true);
        DoAnUong ta4 = new ThucAn("Mực hấp",45,false);
        DoAnUong ta5 = new ThucAn("Lẩu gà lá é", 50,false);
        DoAnUong tu1 = new ThucUong("Pesi",10,"PesiCo");
        DoAnUong tu2 = new ThucUong("Coca-cola",10,"CoCa-cola");
        DoAnUong tu3 = new ThucUong("Sài gòn bạc", 10, "Sabeco");

        //dịch vụ
        DichVu dv1 = new DvKaraoke("KaraGold",100,30);
        DichVu dv2 = new DvThueCaSi("Thuê Ca Si", 500,"Sơn Tùng MTP", 5);
        DichVu dv3 = new DvTrangTri("Trang trí bữa tiệc",200);

        //menu có sẵn
        MenuBuoiTiec menu1 = new MenuBuoiTiec(ta0,ta1,ta2,ta4,tu1,tu2);
        MenuBuoiTiec menu2 = new MenuBuoiTiec(ta0,ta2,ta4,ta5,tu2,tu3);

        //cho thuê sảnh obj có sẵn
        var ct1 = new ChoThueSanh("abc", s1, td1, new MenuBuoiTiec[]{menu1}, dv2);
        var ct2 = new ChoThueSanh("xyz", s2, td3, new MenuBuoiTiec[]{menu2}, dv3);

        QuanLySanhCuoi qlySanhCuoi = new QuanLySanhCuoi();
        QuanLyDichVu qlyDichVu = new QuanLyDichVu();
        QuanLyAnUong qlyAnUong = new QuanLyAnUong();
        QuanLyMenu qlyMenu = new QuanLyMenu();
        QuanLyChoThue qlyChoThue = new QuanLyChoThue();
        QuanLyGiaThue qlGiaThue = new QuanLyGiaThue();
        BaoCaoDoanhThu baoCao = new BaoCaoDoanhThu();

        qlySanhCuoi.themSanh(s1,s2,s3);
        qlyAnUong.themDoAnUong(ta0,ta1,ta2,ta3,ta4,ta5,tu1,tu2,tu3);
        qlyMenu.themMenu(menu1,menu2);
        qlyDichVu.themDVu(dv1,dv2,dv3);
        qlGiaThue.themGiaThue(gt1, gt2, gt3, gt4);
        qlyChoThue.themChoThue(ct1, ct2);

        int choose = 0;
        do{
            System.out.println("=============== CHỨC NĂNG ================");
            System.out.println("1. Quản lý thông tin sảnh cưới");
            System.out.println("2. Quản lý thông tin dịch vụ");
            System.out.println("3. Quản lý thông tin thức ăn, thức uống");
            System.out.println("4. Quản lý cho thuê sảnh");
            System.out.println("5. Quản lý giá thuê sảnh");
            System.out.println("6. Quản lý menu");
            System.out.println("7. Xuất hóa đơn");
            System.out.println("8. Báo cáo doanh thu");
            System.out.println("0. Thoát");
            System.out.println("==========================================");
            do {
                try{
                    System.out.print("\nNhập sự lựa chọn: ");
                    choose = Integer.parseInt(CauHinh.sc.nextLine());
                    break;
                }
                catch (NumberFormatException ex){
                    System.out.print("Lỗi nhập chữ");
                }
            }while (true);
            switch(choose){
                case 1:
                    int choose1;
                    do{
                        System.out.println("\n\n1. Thêm sảnh cưới");
                        System.out.println("2. Cập nhật thông tin sảnh cưới");
                        System.out.println("3. Xóa sảnh cưới");
                        System.out.println("4. Tra cứu theo tên sảnh");
                        System.out.println("5. Tra cứu theo sức chứa sảnh");
                        System.out.println("6. Tra cứu theo vị trí sảnh");
                        System.out.println("7. Hiển thị tất cả sảnh cưới");
                        System.out.println("8. Sắp xếp sảnh cưới theo tần số được thuê");
                        System.out.println("9. Hiển thị tên sảnh và tần số thuê tương ứng");
                        System.out.println("0. Thoát");
                        do {
                            try{
                                System.out.print("\nNhập sự lựa chọn: ");
                                choose1 = CauHinh.sc.nextInt();
                                break;
                            }
                            catch (NumberFormatException ex){
                                System.out.println("Lỗi nhập chữ!!!");
                            }
                        }while (true);
                        CauHinh.sc.nextLine();
                        switch(choose1) {
                            case 1: {
                                System.out.print("Nhập tên sảnh: ");
                                String ten = CauHinh.sc.nextLine();
                                do {
                                    try{
                                        System.out.print("Nhập vị trí sảnh(1/2): ");
                                        ViTriSanh tang = ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1];
                                        System.out.print("Nhập vào sức chứa: ");
                                        int sucChua = Integer.parseInt(CauHinh.sc.nextLine());
                                        qlGiaThue.hienThi();
                                        List<Integer> dsMaGia = new ArrayList<>();
                                        int maGia; boolean thoat = false;
                                        do {
                                            do {
                                                try {
                                                    System.out.print("\nNhập mã giá thuê của sảnh: ");
                                                    maGia = Integer.parseInt(CauHinh.sc.nextLine());
                                                    break;
                                                } catch (NumberFormatException ex) {
                                                    System.out.println("Lỗi nhập chữ");
                                                }
                                            } while (true);
                                            if (qlGiaThue.traCuuTheoMa(maGia) != null && !dsMaGia.contains(maGia)) {
                                                dsMaGia.add(maGia);
                                                do {
                                                    try {
                                                        System.out.print("Nhập thêm giá cho buổi tiệc? (0-Không / 1-Có): ");
                                                        thoat = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                                        break;
                                                    } catch (NumberFormatException ex) {
                                                        System.out.println("Lỗi nhập chữ");
                                                    }
                                                } while (true);
                                            }
                                            else {
                                                System.out.println("Lỗi nhập mã, kiểm tra lại");
                                            }
                                        }while(!thoat);
                                        qlySanhCuoi.themSanh(new SanhCuoi(ten, tang, sucChua, dsMaGia.stream().map(ma -> qlGiaThue.traCuuTheoMa(ma)).toList()));
                                        break;
                                    }
                                    catch (NumberFormatException ex){
                                        System.out.print("Lỗi nhập chữ");
                                    }
                                }while (true);
                                break;
                            }
                            case 2: {
                                qlySanhCuoi.hienThi();
                                System.out.print("\n\nNhập mã sảnh để cập nhật: ");
                                String ma = CauHinh.sc.nextLine();
                                var sanh = qlySanhCuoi.traCuuSanhTheoMa(ma);
                                if (sanh == null) break;
                                System.out.println("Chọn thuộc tính để cập nhật: ");
                                System.out.print("1. Tên Sảnh\n2. Vị trí\n3. Sức chứa\n4. Cả 3\n");
                                System.out.print("Chọn: ");
                                int chon = Integer.parseInt(CauHinh.sc.nextLine());
                                switch (chon) {
                                    case 1:
                                        System.out.print("Tên sảnh mới: ");
                                        sanh.capNhat(CauHinh.sc.nextLine());
                                        break;
                                    case 2:
                                        do {
                                            try{
                                                System.out.print("Vị trí sảnh mới (1-2): ");
                                                sanh.capNhat(ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1]);
                                                break;
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        }while (true);
                                        break;
                                    case 3:
                                        do {
                                            try{
                                                System.out.print("Sức chứa mới: ");
                                                sanh.capNhat(Integer.parseInt(CauHinh.sc.nextLine()));
                                                break;
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        }while (true);
                                        break;
                                    case 4:
                                        System.out.print("Tên sảnh mới: ");
                                        sanh.capNhat(CauHinh.sc.nextLine());
                                        do {
                                            try{
                                                System.out.print("Vị trí sảnh mới (1-2): ");
                                                sanh.capNhat(ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1]);
                                                System.out.print("Sức chứa mới: ");
                                                sanh.capNhat(Integer.parseInt(CauHinh.sc.nextLine()));
                                                break;
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        }while (true);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }
                            case 3: {
                                qlySanhCuoi.hienThi();
                                System.out.print("\n\nNhập mã sãnh cần xóa: ");
                                qlySanhCuoi.xoaSanh(CauHinh.sc.nextLine().toUpperCase().trim());
                                break;
                            }
                            case 4: {
                                System.out.print("Nhập tên sảnh cần tra cứu: ");
                                var dsSanh = qlySanhCuoi.traCuuSanh(CauHinh.sc.nextLine());
                                if(!dsSanh.isEmpty()){
                                    System.out.printf("%-20s%-20s%-20s%-20s", "Mã sảnh", "Tên sảnh", "Vị trí", "Sức chứa");
                                    dsSanh.forEach(SanhCuoi::hienThi);
                                }
                                else{
                                    System.out.print("Không tìm thấy sảnh cần tìm");
                                }
                                break;
                            }
                            case 5: {
                                do {
                                    try{
                                        System.out.print("Nhập sức chứa sảnh cần tra cứu: ");
                                        var dsSanh = qlySanhCuoi.traCuuSanh(Integer.parseInt(CauHinh.sc.nextLine()));
                                        if(!dsSanh.isEmpty()){
                                            System.out.printf("%-20s%-20s%-20s%-20s", "Mã sảnh", "Tên sảnh", "Vị trí", "Sức chứa");
                                            dsSanh.forEach(SanhCuoi::hienThi);
                                        }
                                        else{
                                            System.out.print("Không tìm thấy sảnh cần tìm");
                                        }
                                        break;
                                    }
                                    catch (NumberFormatException ex){
                                        System.out.print("Lỗi nhập chữ");
                                    }
                                }while (true);
                                break;
                            }
                            case 6: {
                                try{
                                    do{
                                        try {
                                            System.out.print("Nhập vị trí sảnh cần tra cứu (1-2): ");
                                            var dsSanh = qlySanhCuoi.traCuuSanh(ViTriSanh.values()[Integer.parseInt(CauHinh.sc.nextLine())-1]);
                                            if(!dsSanh.isEmpty()){
                                                System.out.printf("%-20s%-20s%-20s%-20s", "Mã sảnh", "Tên sảnh", "Vị trí", "Sức chứa");
                                                dsSanh.forEach(SanhCuoi::hienThi);
                                            }
                                            else{
                                                System.out.print("Không tìm thấy sảnh cần tìm");
                                            }
                                            break;
                                        }catch (NumberFormatException ex){
                                            System.out.print("Lỗi nhập chữ");
                                        }
                                    }while (true);
                                }
                                catch (ArrayIndexOutOfBoundsException ex){
                                    System.out.print("Không tìm thấy sảnh cần tìm");
                                }

                                break;
                            }
                            case 7:
                                qlySanhCuoi.hienThi();
                                break;
                            case 8:
                                qlySanhCuoi.setQuanLyChoThue(qlyChoThue);
                                qlySanhCuoi.sapXepTheoTanSoThue();
                                break;
                            case 9:
                                System.out.printf("%-40s%-20s","Danh sách tên sảnh","Tần số thuê");
                                qlySanhCuoi.hienThiTheoTanSo();
                                break;
                            case 0:
                                choose1 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose1 != 0);
                    break;
                case 2:
                    int choose2 = 0;
                    do{
                        System.out.println("\n\n1. Thêm dịch vụ");
                        System.out.println("2. Cập nhật dịch vụ");
                        System.out.println("3. Xóa dịch vụ");
                        System.out.println("4. Tra cứu theo tên dịch vụ");
                        System.out.println("5. Hiển thị tất cả dịch vụ");
                        System.out.println("0. Thoát");
                        do {
                            try{
                                System.out.print("\nNhập sự lựa chọn: ");
                                choose2 = Integer.parseInt(CauHinh.sc.nextLine());
                                break;
                            }
                            catch (NumberFormatException ex){
                                System.out.print("Lỗi nhập chữ");
                            }
                        }while (true);
                        switch(choose2) {
                            case 1: {
                                int option;
                                boolean flagExit = false;
                                do {
                                    System.out.println("\n\n=========== THÊM DỊCH VỤ MỚI ===========");
                                    System.out.print("Nhập tên dịch vụ: ");
                                    String ten = CauHinh.sc.nextLine();
                                    double gia = 0;
                                    do{
                                        try{
                                            System.out.print("Nhập giá dịch vụ: ");
                                            gia = Double.parseDouble(CauHinh.sc.nextLine());
                                            break;
                                        }
                                        catch (NumberFormatException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    }while (true);
                                    System.out.println("\nChọn loại dịch vụ: ");
                                    System.out.println("1. Dịch vụ Karaoke\n2. Dịch vụ thuê ca sĩ\n3. Dịch vụ trang trí");
                                    System.out.print("Chọn: ");
                                    option = Integer.parseInt(CauHinh.sc.nextLine());
                                    DichVu dv;
                                    switch (option) {
                                        case 1: {
                                            try{
                                                System.out.print("Thời gian thuê (phút): ");
                                                double tg = Double.parseDouble(CauHinh.sc.nextLine());
                                                dv = new DvKaraoke(ten, gia, tg);
                                                qlyDichVu.themDVu(dv);
                                            }
                                            catch(NumberFormatException ex){
                                                System.out.println("Lỗi nhập chữ");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            System.out.print("Tên ca sĩ: ");
                                            String name = CauHinh.sc.nextLine();
                                            try{
                                                System.out.print("Số bài hát: ");
                                                int soBH = Integer.parseInt(CauHinh.sc.nextLine());
                                                dv = new DvThueCaSi(ten, gia, name, soBH);
                                                qlyDichVu.themDVu(dv);
                                            }
                                            catch (NumberFormatException ex){
                                                System.out.println("Lỗi nhập chữ");
                                            }
                                            break;
                                        }
                                        case 3: {
                                            dv = new DvTrangTri(ten, gia);
                                            qlyDichVu.themDVu(dv);

                                            break;
                                        }
                                        case 0: {
                                            option = 0;
                                            break;
                                        }
                                        default:
                                            System.out.println("Không có lựa chọn này!");
                                            break;
                                    }
                                    System.out.print("Bạn có muốn thoát (0:Không - 1:Có):");
                                    flagExit = Boolean.parseBoolean((Integer.parseInt(CauHinh.sc.nextLine())) == 0 ? "False" : "True");
                                } while (!flagExit);
                                break;
                            }
                            case 2: {
                                CauHinh.hienTieuDeDichVu();
                                qlyDichVu.hienThi();
                                System.out.print("\n\nNhập mã dịch vụ để cập nhật: ");
                                String ma = CauHinh.sc.nextLine();
                                DichVu dv = qlyDichVu.traCuuTheoMa(ma);
                                if(dv != null){dv.capNhat();}
                                break;
                            }
                            case 3: {
                                CauHinh.hienTieuDeDichVu();
                                qlyDichVu.hienThi();
                                System.out.print("\n\nNhập mã dịch vụ cần xoá: ");
                                qlyDichVu.xoaDVu(CauHinh.sc.nextLine());
                                break;
                            }
                            case 4: {
                                System.out.print("Nhập tên dịch vụ cần tra cứu: ");
                                var dsSanh = qlyDichVu.traCuuDichVu(CauHinh.sc.nextLine());
                                if(!dsSanh.isEmpty()){
                                    CauHinh.hienTieuDeDichVu();
                                    dsSanh.forEach(DichVu::hienThi);
                                }
                                else{
                                    System.out.println("Không tìm thấy ");
                                }
                                break;
                            }
                            case 5: {
                                CauHinh.hienTieuDeDichVu();
                                qlyDichVu.hienThi();
                                break;
                            }
                            case 0:
                                choose2 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose2 != 0);
                    break;
                case 3:
                    int choose3;
                    do{
                        System.out.println("\n\n1. Thêm đồ ăn uống");
                        System.out.println("2. Cập nhật đồ ăn uống");
                        System.out.println("3. Xóa đồ ăn uống");
                        System.out.println("4. Tra cứu đồ ăn uống");
                        System.out.println("5. Hiển thị tất cả đồ ăn uống");
                        System.out.println("0. Thoát");
                        System.out.print("\nNhập sự lựa chọn: ");
                        choose3 = Integer.parseInt(CauHinh.sc.nextLine());
                        switch(choose3) {
                            case 1: {
                                int option;
                                boolean nhapTiep;
                                do {
                                    System.out.print("Nhập tên đồ ăn uống: ");
                                    //CauHinh.sc.nextLine();
                                    String ten = CauHinh.sc.nextLine();
                                    double gia = 0;
                                    do {
                                        try {
                                            System.out.print("Nhập giá đồ ăn uống: ");
                                            gia = Double.parseDouble(CauHinh.sc.nextLine());
                                            break;
                                        }catch(NumberFormatException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    }while(true);
                                    do {
                                        System.out.println("Chọn loại đồ ăn uống: ");
                                        System.out.print("1. Thức ăn\n2. Thức uống\n");
                                        do {
                                            try {
                                                System.out.print("Chọn: ");
                                                option = Integer.parseInt(CauHinh.sc.nextLine());
                                                break;
                                            } catch (NumberFormatException ex) {
                                                System.out.print("Lỗi nhập chữ");
                                            }
                                        } while (true);
                                        DoAnUong doAnUong;
                                        switch (option) {
                                            case 1: {
                                                boolean isAnChay;
                                                do{
                                                    try {
                                                        System.out.print("Ăn chay được không? (0-Không / 1-Có): ");
                                                        isAnChay = Boolean.parseBoolean((Integer.parseInt(CauHinh.sc.nextLine())) == 0 ? "False" : "True");
                                                        break;
                                                    }catch (NumberFormatException ex){
                                                        System.out.print("Lỗi nhập chữ\n");
                                                    }
                                                }while (true);
                                                doAnUong = new ThucAn(ten, gia, isAnChay);
                                                qlyAnUong.themDoAnUong(doAnUong);
                                                break;
                                            }
                                            case 2: {
                                                System.out.print("Hãng sản xuất: ");
                                                String name = CauHinh.sc.nextLine();
                                                doAnUong = new ThucUong(ten, gia, name);
                                                qlyAnUong.themDoAnUong(doAnUong);
                                                break;
                                            }
                                            default:
                                                System.out.println("Không có lựa chọn này!");
                                                break;
                                        }
                                    }while(option < 1 || option > 2);
                                    do{
                                        try {
                                            System.out.print("Bạn muốn nhập tiếp đồ ăn uống mới không (0-Không / 1-Có): ");
                                            nhapTiep = Boolean.parseBoolean((Integer.parseInt(CauHinh.sc.nextLine()) == 0) ? "False" : "True");
                                            break;
                                        }catch (NumberFormatException ex){
                                            System.out.print("Lỗi nhập chữ\n");
                                        }
                                    }while (true);
                                } while(nhapTiep);
                                break;
                            }
                            case 2: {
                                qlyAnUong.hienThi();
                                int ma;
                                do{
                                    try{
                                        System.out.print("\n\nNhập mã đồ ăn (uống) để cập nhật: ");
                                        ma = Integer.parseInt(CauHinh.sc.nextLine());
                                        break;
                                    }
                                    catch (NumberFormatException ex){
                                        System.out.println("Lỗi nhập chữ\n");
                                    }
                                }while(true);
                                DoAnUong dau = qlyAnUong.traCuuAnUong(ma);
                                if(dau != null){dau.capNhat();}
                                break;
                            }
                            case 3: {
                                qlyAnUong.hienThi();
                                do{
                                    try {
                                        System.out.print("\n\nNhập mã đồ ăn (uống) cần xoá: ");
                                        qlyAnUong.xoaDoAnUong(Integer.parseInt( CauHinh.sc.nextLine()));
                                        break;
                                    }
                                    catch(NumberFormatException ex){
                                        System.out.print("Lỗi nhâp chữ");
                                    }
                                }while(true);
                                break;
                            }
                            case 4: {
                                System.out.print("Nhập tên đồ ăn (uống) cần tra cứu: ");
                                var dsDAU = qlyAnUong.traCuuAnUong(CauHinh.sc.nextLine());
                                if(!dsDAU.isEmpty()){
                                    System.out.printf("%-20s%-20s%-20s", "Mã đồ ăn (uống): ", "Tên đồ ăn (uống): ", "Giá đồ ăn (uống): ");
                                    dsDAU.forEach(DoAnUong::hienThi);
                                }
                                else{
                                    System.out.println("Không tìm thấy");
                                }
                                break;
                            }
                            case 5: {
                                qlyAnUong.hienThi();
                                break;
                            }
                            case 0:
                                choose3 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose3 != 0);
                    break;
                case 4: //Sửa lại cái đống ở dưới
                    int choose4;
                    do{
                        System.out.println("\n\n1. Cho thuê sảnh");
                        System.out.println("2. Hiển thị danh sách cho thuê");
                        System.out.println("0. Thoát");
                        do{
                            try{
                                System.out.print("\nNhập sự lựa chọn: ");
                                choose4 = Integer.parseInt(CauHinh.sc.nextLine());
                                break;
                            }
                            catch (NumberFormatException ex){
                                System.out.println("Lỗi nhập chữ");
                            }
                        }while(true);
                        switch(choose4) {
                            case 1: {
                                Boolean thoat = false;
                                do {
                                    System.out.println("================= Nhập thông tin cho thuê =================");
                                    System.out.print("Nhập tên bữa tiệc: ");
                                    String tenTiec = CauHinh.sc.nextLine();
                                    qlySanhCuoi.hienThi();
                                    SanhCuoi sanh;
                                    do {
                                        System.out.print("\nNhập mã sảnh cần thuê: ");
                                        sanh = qlySanhCuoi.traCuuSanhTheoMa(CauHinh.sc.nextLine().toUpperCase().trim());
                                    }while(sanh == null);
                                    sanh.hienThiDSGiaThue();
                                    BuoiThue buoi;
                                    do{
                                        try{
                                            System.out.print("\nNhập buổi thuê (1-Sáng, 2-Chiều, 3-Tối): ");
                                            buoi = BuoiThue.values()[Integer.parseInt(CauHinh.sc.nextLine()) - 1];
                                            break;
                                        }
                                        catch(NumberFormatException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                        catch (ArrayIndexOutOfBoundsException ex) {
                                            System.out.println("Không có thời điểm này");
                                        }
                                    }while(true);
                                    Date ngayThue;
                                    do{
                                        try{
                                            System.out.print("\nNhập ngày thuê (dd/MM/yyyy): ");
                                            ngayThue = CauHinh.f.parse(CauHinh.sc.nextLine());
                                            break;
                                        }
                                        catch(ParseException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    }while(true);
                                    ThoiDiemThue thoiDiem = new ThoiDiemThue(ngayThue , buoi);
                                    qlyMenu.hienThi();
                                    List<Integer> maMenu = new ArrayList<>(); // để nhận nhiều menu
                                    Boolean thoatTrong = false;
                                    int tempMa;
                                    do {
                                        do{
                                            try{
                                                System.out.print("Nhập mã menu cần đặt chỉ nhập số: ");
                                                tempMa = Integer.parseInt(CauHinh.sc.nextLine());
                                                break;
                                            }catch(NumberFormatException ex){
                                                System.out.println("Lỗi nhập");
                                            }
                                        }while(true);
                                        var menu = qlyMenu.traCuuMenu(tempMa);
                                        if (menu != null && !maMenu.contains(tempMa)) { //nếu mã menu không tìm thấy trong danh sách menu đã chọn và có ds menu hệ thống
                                            maMenu.add(tempMa);
                                            do {
                                                try {
                                                    System.out.print("Đặt thêm menu cho buổi tiệc? (0-Không / 1-Có): ");
                                                    thoatTrong = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                                    break;
                                                } catch (NumberFormatException ex) {
                                                    System.out.println("Lỗi nhập chữ");
                                                }
                                            }while(true);
                                        }
                                        else {
                                            System.out.println("Lỗi! Vui lòng kiểm tra lại");
                                            thoatTrong = false;
                                        }
                                    } while (!thoatTrong);
                                    var dsMenu = maMenu.stream().map(qlyMenu::traCuuMenu).toList();
                                    CauHinh.hienTieuDeDichVu();
                                    qlyDichVu.hienThi();
                                    List<String> maDv = new ArrayList<>();
                                    do {
                                        System.out.print("Nhập mã dịch vụ cần đặt: ");
                                        var tempMaDv = CauHinh.sc.nextLine();
                                        var dv = qlyDichVu.traCuuTheoMa(tempMaDv);
                                        if (dv != null && !maDv.contains(tempMaDv)) {
                                            maDv.add(tempMaDv);
                                            do {
                                                try {
                                                    System.out.print("Đặt thêm dịch vụ cho buổi tiệc? (0-Không / 1-Có): ");
                                                    thoatTrong = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                                    break;
                                                } catch (NumberFormatException ex) {
                                                    System.out.println("Lỗi nhập chữ");
                                                }
                                            }while(true);
                                        }
                                        else {
                                            System.out.println("Lỗi!!!");
                                            thoatTrong = false;

                                        }
                                    } while (!thoatTrong);
                                    var dsDV = maDv.stream().map(qlyDichVu::traCuuTheoMa).toList();
                                    qlyChoThue.themChoThue(new ChoThueSanh(tenTiec, sanh, thoiDiem,dsMenu, dsDV));
                                    do{
                                        try{
                                            System.out.print("Nhập tiếp việc cho thuê? (0-Không / 1-Có): ");
                                            thoat = Boolean.parseBoolean(Integer.parseInt(CauHinh.sc.nextLine()) == 0 ? "True" : "False");
                                            break;
                                        }
                                        catch(NumberFormatException ex){
                                            System.out.println("Lỗi nhập chữ");
                                        }
                                    }while(true);
                                } while (!thoat);
                                break;
                            }
                            case 2: {
                                qlyChoThue.hienThi();
                                break;
                            }
                            case 0:
                                choose4 = 0;
                                break;
                            default:
                                System.out.println("Không có lựa chọn này!");
                                break;
                        }
                    }while(choose4 != 0);
                    break;
                case 5: {
                    // thiếu chức năng hiển thị menu, sửa menu, xóa menu
                    System.out.print("1. Thêm menu mới");
                    System.out.print("2. Sửa menu");
                    System.out.print("3. Xóa menu");
                    System.out.print("4. Hiển thị danh sách menu");
                    System.out.print("0. Thoát");

                    boolean thoat = false;
                    do {
                        System.out.println("Nhập menu mới: ");
                        boolean thoatTrong = false;
                        List<Integer> dsMaAnUong = new ArrayList<>();
                        qlyAnUong.hienThi();
                        do {
                            System.out.print("Nhập mã đồ ăn (uống) trong menu");
                            dsMaAnUong.add(Integer.parseInt(CauHinh.sc.nextLine()));
                            System.out.println("Nhập tiếp đồ ăn uống? (0-1): ");
                            thoatTrong = Boolean.parseBoolean(CauHinh.sc.nextLine());
                        } while (!thoatTrong);
                        MenuBuoiTiec menu = new MenuBuoiTiec(dsMaAnUong.stream().map(ma -> qlyAnUong.traCuuAnUong(ma)).toList());
                        qlyMenu.themMenu(menu);
                        System.out.println("Nhập tiếp menu? (0-1): ");
                        thoat = Boolean.parseBoolean(CauHinh.sc.nextLine());
                    } while (!thoat);
                    break;
                }
                case 6: {
                    qlyChoThue.hienThi();
                    System.out.print("Nhập mã buổi tiệc cần xuất hóa đơn: ");
                    String id = CauHinh.sc.nextLine();
                    HoaDon hd = new HoaDon(qlyChoThue.traCuuTiec(id));
                    baoCao.themHoaDon(hd);
                    hd.xuatHoaDon();
                    break;
                }
                case 7: {
                    int choose7;
                    System.out.println("Kiểm tra doanh thu theo: ");
                    System.out.println("1. Theo tháng.");
                    System.out.println("2. Theo quý.");
                    do {
                        System.out.print("\nChọn: ");
                        choose7 = Integer.parseInt(CauHinh.sc.nextLine());
                        switch (choose7){
                            case 1:
                            {
                                int month, year;
                                System.out.print("Nhập vào tháng: ");
                                do{
                                    month = Integer.parseInt(CauHinh.sc.nextLine());
                                    if(month < 1 || month > 12)
                                        System.out.print("Lỗi! Vui lòng nhập lại");
                                }while(month < 1 || month > 12);
                                System.out.print("Nhập vào năm: ");
                                year = Integer.parseInt(CauHinh.sc.nextLine());
                                System.out.printf("\nDoah thu theo tháng: %20f",baoCao.theoThang(month,year));
                                break;
                            }
                            case 2:
                            {
                                int quater, year;
                                System.out.print("Nhập vào tháng: ");
                                do{
                                    quater = Integer.parseInt(CauHinh.sc.nextLine());
                                    if(quater < 1 || quater > 12)
                                        System.out.print("Lỗi! Vui lòng nhập lại");
                                }while(quater < 1 || quater > 12);
                                System.out.print("Nhập vào năm: ");
                                year = Integer.parseInt(CauHinh.sc.nextLine());
                                System.out.printf("\nDoah thu theo quý: %20f",baoCao.theoThang(quater,year));
                                break;
                            }
                            default:
                                System.out.print("Lỗi.Vui lòng chọn lại!!!");
                                break;
                        }
                    }while(choose7 != 0);
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.print("Lỗi.Vui lòng chọn lại!!!");
                    break;
            }
        }while(choose != 0);
    }
}
