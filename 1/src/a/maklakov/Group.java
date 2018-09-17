package a.maklakov;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group {
    private long id = (new Date()).getTime();
    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public long getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if(student.getGroupId() != this.id) {
            student.setGroupId(this.id);
            this.students.add(student);
        }
    }

    public void addStudents(List<Student> students) {
        for (Student student :
                students) {
            this.addStudent(student);
        }
    }

    public float getAverageMark() {
        if (this.students.size() > 0) {
            float sum = 0;
            int length = 0;

            System.out.println(this.toString());

            for (Student student :
                    this.students) {
                if(student.getMarksAndCount() == new int[]{-1,-1}) {
                    continue;
                }

                int[] sumAndCount = student.getMarksAndCount();
                sum += sumAndCount[0];
                length += sumAndCount[1];
            }

            return sum / length;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", students=" + students +
                '}';
    }
}
