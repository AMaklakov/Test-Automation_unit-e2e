package a.maklakov;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int[] getMarksSet(int index) {
        switch (index) {
            case 0:
                return new int[]{1, 2, 3, 4};
            case 1:
                return new int[]{3, 5, 3};
            case 2:
            default:
                return new int[]{-18, 8, 9, 10};

        }
    }

    public static void main(String[] args) {
        System.out.println("Студент");
        Student student = new Student("Маклаков", "Артем");
        student.addMark(5);
        student.addMark(3);
        student.addMark(1);

        System.out.println("Средняя оценка студента "
                + student.getFirstName() + " " + student.getLastName()
                + " = " + student.getAverageMark());


        System.out.println("====================================");

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Student s = new Student("fisrt-" + i, "last-" + i);
            s.addMarks(Main.getMarksSet(i));
            students.add(s);
        }

        Group group = new Group();
        group.addStudents(students);

        System.out.println("Group average = " + group.getAverageMark());
    }
}
