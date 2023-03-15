package luyennangcao2.navba;

import luyennangcao2.Model.Student;

import java.util.Scanner;

public class Navba {
    public static void main(String[] args) {
        Student[] studentsList = new Student[100];
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("***************STUDENT MANAGE***************************\n" +
                    "1. Show List Student. [20 điểm]\n" +
                    "2. Create Student [30 điểm]\n" +
                    "3. Update Student [20 điểm]\n" +
                    "4. Delete Student [10 điểm]\n" +
                    "5. Sort Student By Age ASC (Tăng Dần). [15 điểm]\n" +
                    "6. Exit [05 điểm]");
            System.out.println("Hãy nhập lựa chọn 1-6:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    showlist(studentsList);
                    break;
                case 2:
                    createStudent(studentsList, sc);
                    break;
                case 3:
                    System.out.println("Nhập id muốn sửa");
                    int idEdit = Integer.parseInt(sc.nextLine());
                    updateStudent(studentsList, idEdit, sc);
                    break;
                case 4:
                    System.out.println("nhập id cần xóa");
                    int idDel = Integer.parseInt(sc.nextLine());
                    deleteStudent(studentsList, idDel);
                    break;
                case 5:
                    sortByAge(studentsList);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không c lựa chọn này, mời chọn lại");
                    break;
            }
        }
    }
    public static void showlist(Student[] list){
        boolean checkNull = false;
        for (Student std : list){
            if(std != null){
                checkNull = true;
                System.out.println(std.toString());
            }
        }
        if (!checkNull){
            System.out.println("Không có sinh viên");
        }
    }

    public static void createStudent(Student[] list, Scanner sc) {
        Student newStudent = inputData(sc);
        boolean check = false;
        boolean checkNull = false;
        int idMax = 0;
        for (Student st: list){
            if(st != null){
                checkNull = true;
                if(idMax < st.getStudentId()){
                    idMax = st.getStudentId();
                }
            }
        }
        if(checkNull){
            newStudent.setStudentId(idMax+1);
        }else {
            newStudent.setStudentId(1);
        }
        for (int i=0; i< list.length;i++){
            if(list[i] == null){
                list[i] =  newStudent;
                check = true;
                break;
            }
        }
        if(check){
            System.out.println("thêm thành công");
        }else {
            System.out.println("danh sách đã đầy");
        }
    }

    //Sửa thông tin sinh viên theo id
    public static void updateStudent(Student[] list, int idEdit, Scanner sc){
        boolean check = false;
        for (int i=0; i< list.length;i++){
            if(list[i] != null){
                if (list[i].getStudentId() == idEdit){
                    System.out.println("Nhập tên mới:");
                    list[i].setStudentName(sc.nextLine());
                    System.out.println("Nhập tuổi:");
                    list[i].setAge(Integer.parseInt(sc.nextLine()));
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            System.out.println("thêm mới thành công");
        } else {
            System.err.println("Danh sách sinh viên đã đầy");
        }
    }

    // xoá sinh viên theo id
    public static void deleteStudent(Student[] list, int idDelete) {
        boolean check = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (list[i].getStudentId() == idDelete) {
                    check = true;
                    list[i] = null;
                }
            }
        }
        if (check) {
            System.out.println("xoá thành công");
        }else {
            System.err.println("Không tồn tại id cần xoá");
        }
    }

    // sắp xếp sinh viên theo tuổi
    public static void sortByAge(Student[] list) {
        for (int i = 0; i < list.length-1 ; i++) {
            for (int j = i+1; j < list.length ; j++) {
                if(list[i]!= null && list[j]!=null){
                    if(list[i].getAge()> list[j].getAge()){
                        Student temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    }
                }
            }

        }
        System.out.println("Mảng đã được sắp xếp");
    }
    public static Student inputData(Scanner sc){
        Student st = new Student();
        //Nhập các thông tin cho đô tượng vừa tạo
        System.out.println("Nập vào tên sinh viên");
        st.setStudentName(sc.nextLine());
        System.out.println("Nhập tuổi sinh viên");
        st.setAge(Integer.parseInt(sc.nextLine()));
        return st;
    }
}
