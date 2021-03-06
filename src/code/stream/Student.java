package code.stream;

import java.util.Comparator;
import java.util.Objects;

public class Student  {
    private int id;
    private String name;
    private double marks;


    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.marks, marks) == 0 && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, marks);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student s =(Student) super.clone();
        return s;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }


}
