import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook  {
    private String phonenumber;
    private String contactgroup;
    private String name;
    private String sex;
    private String address;
    private String birthday;
    private String email;

    public Phonebook(String phonenumber, String phonebook, String name, String sex, String address, String birthday, String email) {
        this.phonenumber = phonenumber;
        this.contactgroup = phonebook;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public Phonebook() {
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonebook() {
        return contactgroup;
    }

    public void setPhonebook(String phonebook) {
        this.contactgroup = phonebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "phonenumber='" + phonenumber + '\'' +
                ", contactgroup='" + contactgroup + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void addInfo() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            System.out.println("nhập sdt");
            String regexName = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(regexName);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check = true;
                phonenumber = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check);

        System.out.println("nhập nhóm ");
        contactgroup = sc.nextLine();
        System.out.println("nhập tên");
        name = sc.nextLine();
        System.out.println("Nhập giới tính ");
        sex = sc.nextLine();
        System.out.println("nhập địa chỉ ");
        address = sc.nextLine();
        System.out.println("nhập ngày tháng năm sinh ");
        birthday = sc.nextLine();
        System.out.println("nhập địa chỉ email ");
        boolean check1 = false;
        do {
            System.out.println("nhập địa chỉ email ");
            String s = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check1 = true;
                email = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check1);
    }
}
