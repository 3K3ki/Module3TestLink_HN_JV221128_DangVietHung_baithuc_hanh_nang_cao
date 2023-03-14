package luyenangcao;
import java.util.Scanner;
public class Navba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
            System.out.println("***************STUDENT MANAGE***************************");
            System.out.println("1. Show List Student.");
            System.out.println("2. Create Student.");
            System.out.println("0. Exit.");
            System.out.println("**********************************************************");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Phần showStudent()
                    System.out.println("**** List Student ****");
                    if (count == 0) {
                        System.out.println("Không có sinh viên trong mảng!");
                    }
                    for (int i = 0; i < count; i++) {
                        System.out.println("Student ID: " + students[i].getStudentId());
                        System.out.println("Student Name: " + students[i].getStudentName());
                        System.out.println("Age: " + students[i].getAge());
                        System.out.println("----------------------------");
                    }
                    break;

                case 2:
                    // Phần createStudent()
                    System.out.println("**** Create Student ****");
                    System.out.print("Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Student Name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(studentId, studentName, age);
                    students[count] = student;
                    count++;

                    System.out.println("Thêm mới thành công");
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chọn sai, mời chọn lại");
                    break;
            }
        }
    }
}
