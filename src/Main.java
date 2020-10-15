import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculation calculation = new Calculation();
        int cases = 0;
        do {
            System.out.println("chương trình quản lý danh bạ ");
            System.out.println("chọn chức năng");
            System.out.println("1 : thêm mới danh bạ");
            System.out.println("2 : xem danh bạ");
            System.out.println("3 : xóa");
            System.out.println("4 : tìm kiếm ");
            System.out.println("5 : cập nhật ");
            System.out.println("6 : exit ");
            try {
                calculation.readFile();
                calculation.writeToFile();
                cases = Integer.parseInt(sc.nextLine());
                switch (cases) {
                    case 1:
                        calculation.addInfos();
                        break;
                    case 2:
                        calculation.show();
                        break;
                    case 3:
                        calculation.delete();
                        break;
                    case 4:
                        calculation.search();
                        break;
                    case 5:
                        calculation.edit();
                }
            } catch (Exception e) {
                System.out.println("nhập lại ");
            }
        } while (cases != 6);
    }
}