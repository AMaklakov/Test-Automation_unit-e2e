package a.maklakov;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {

    private long id = (new Date()).getTime();
    private long groupId;

    private String firstName;
    private String lastName;

    private List<Integer> marks = new ArrayList<>();

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void addMark(int mark) {
        if (mark >= 0 && mark <= 10) {
            this.marks.add(mark);
        }
    }

    public void addMarks(int[] marks) {
        for (int mark :
                marks) {
            this.addMark(mark);
        }
    }

    public float getAverageMark() {
        if(this.marks.size() > 0) {
            float sum = 0;

            for (int mark :
                    this.marks) {
                sum += mark;
            }

            return sum / this.marks.size();
        }

        return -1;
    }

    public int[] getMarksAndCount() {
        if(this.marks.size() > 0) {
            int sum = 0;

            for (int mark :
                    this.marks) {
                sum += mark;
            }

            return new int[] {sum, this.marks.size()};
        }

        return new int[] {-1, -1};
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
