import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation implements DisPlay {
    ArrayList<Phonebook> phonebooks = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public List<Phonebook> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("contacts.csv");
        ObjectInputStream ojb = new ObjectInputStream(fileInputStream);
        phonebooks = (ArrayList<Phonebook>) (ojb.readObject());
        ojb.close();
        fileInputStream.close();
        return phonebooks;
    }

    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("contacts.csv");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(phonebooks);
        objectOutputStream.close();
        fileOutputStream.close();
    }


    @Override
    public void addInfos() throws IOException, ClassNotFoundException {
        readFile();
        Phonebook phoneBook = new Phonebook();
        int input = 0;
        do {
            System.out.println("Nhập thông tin danh bạ");
            try {
                input = Integer.parseInt(sc.nextLine());
                switch (input) {
                    case 1:
                        phoneBook.addInfo();
                        phonebooks.add(phoneBook);
                        break;
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("mời nhập lại ");
            }
        } while (input != 2);
    }

    @Override
    public void show() throws IOException, ClassNotFoundException {
        writeToFile();
        readFile();
        int n = 0;
        do {
            System.out.println("mời chọn");
            System.out.println("hiện thị");
            System.out.println("thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    for (Phonebook phoneBook : phonebooks) {
                        System.out.println(phoneBook.toString());
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("mời nhập lại");
            }
        } while (n != 2);
    }

    @Override
    public void search() {
        int n = 0;
        do {
            System.out.println("Chọn Chức Năng");
            System.out.println("1 : Tìm");
            System.out.println("2 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập Thông Tin Cần Tìm :");
                    String regex = sc.nextLine();
                    int index = 0;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;
                    for (int i = 0; i < phonebooks.size(); i++) {
                        matcher = pattern.matcher(phonebooks.get(i).getName());
                        if (matcher.find()) {
                            System.out.println("STT " + i + " : " + phonebooks.get(i).toString());
                            index++;
                        }
                    }
                    if (index <= 0) {
                        System.out.println("Tên này không có trong danh sách\n ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhâp lại ");
            }
        } while (n != 2);
    }

    @Override
    public void edit() {
        int num = 0;
        do {
            System.out.println("Nhập Thông tin cần sửa ");
            System.out.println("Chọn Chỉnh Sửa Theo ");
            System.out.println("1 : theo tên");
        System.out.println("2 : theo số điện thoại ");
        try {
            num = Integer.parseInt(sc.nextLine());
            String edit;
            int n = 0;
            switch (num) {
                case 1:
                    System.out.println("Tên Cần Chỉnh :");
                    edit = sc.nextLine();
                    for (Phonebook name : phonebooks) {
                        if (edit.equals(name.getName())) {
                            System.out.println("Chỉnh tên : ");
                            String add = sc.nextLine();
                            name.setName(add);
                            System.out.println("Tên sau khi chỉnh sửa " + name.getName());
                            n++;
                            break;
                        }
                    }
                    if (n == 0) {
                        System.out.println("tên không co trong danh sách");
                        break;
                    }
                case 2:
                    System.out.println("nhập tên cần chỉnh lại số ");
                    edit = sc.nextLine();
                    for (Phonebook numberPhone : phonebooks) {
                        if (edit.equals(numberPhone.getName())) {
                            System.out.println("chỉnh lại ");
                            String add = sc.nextLine();
                            numberPhone.setPhonenumber(add);
                            n++;
                            break;
                        }
                    }
                    if (n == 0) {
                        System.out.println("tên ko có trong danh bạ");
                        break;
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("nhập lại");
        }
    } while (num != 3);
}

    @Override
    public void delete() {
        int n = 0;
        do {
            System.out.println("1: Xóa");
            System.out.println("2: Thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập tên cần xóa ");
                    String id = sc.nextLine();
                    Phonebook phoneBook = null;
                    int size = phonebooks.size();
                    for (int i = 0; i < size; i++) {
                        if (phonebooks.get(i).getName().equals(id)) {
                            phoneBook = phonebooks.get(i);
                            break;
                        }
                    }
                    if (phoneBook != null) {
                        System.out.println("Đã Xóa Tên Là : \n" + phoneBook.getName());
                        phonebooks.remove(phoneBook);
                    } else {
                        System.out.println("Không Có tên Trong Danh Sách");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhập sai rồi");
            }
        } while (n != 2);
    }
}