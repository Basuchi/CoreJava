package code.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {



        Student s1 = new Student(101, "Veeba Dapalapur", 57.0);
        Student s2= new Student(102, "Swetha B", 60.0);
        Student s3 = new Student(103, "Sachin Jai", 66.0);
        Student s4 = new Student(104, "Chetan D", 37.0);
        Student s5 = new Student(105, "Mariay Dev", 22.0);
        Student s6 = new Student(106, "Basu Dapalap", 34.0);
        Student s7 = new Student(107, "Kalpana Channamma", 80.0);

        List<Student> list = new ArrayList<>();
        list.add(s1);list.add(s2);list.add(s3);list.add(s4);list.add(s5);list.add(s6);list.add(s7);
        list.stream().forEach(System.out::println);
        //1. stream().map()
        System.out.println("After adding 10.0 grace marks to each student");
        System.out.println("===========================================================================");
        List<Student> map = list.stream().map(student -> { student.setMarks(student.getMarks()+10.0);
            return student;
        }).collect(Collectors.toList());

       map.stream().forEach(System.out::println);

       //2. Filter
        /**
         *  Filter -> get only passed studnet (passed-> 35>=?)
         */
        System.out.println("===========================================================================");
        System.out.println("Passed Students List");
        List<Student > filter = map.stream().filter(s-> s.getMarks()>=35).collect(Collectors.toList());
        filter.stream().forEach(System.out::println);

        System.out.println("===========================================================================");
        //3.Count
        long count =  map.stream().filter(s-> s.getMarks()>=35).count();
        System.out.println(count);


        //sort
        System.out.println("===========================Default Sorting technique================================================");
        //List<Student> defaultsSorted = map.stream().sorted().collect(Collectors.toList());
       // defaultsSorted.stream().forEach(System.out::println);
        System.out.println("===========================Custom Sorting marks descend order================================================");
        List<Student> sorted = map.stream().sorted((o1,o2)-> o1.getMarks() <o2.getMarks() ? -1: o1.getMarks()>o2.getMarks() ? 1 : 0).collect(Collectors.toList());
        sorted.stream().forEach(System.out::println);
        System.out.println("===========================Custom Sorting name length order================================================");
        List<Student> lengthSorted = map.stream().sorted((o1,o2)-> o1.getName().length() <o2.getName().length() ? -1: o1.getName().length()>o2.getName().length() ? 1 : 0).collect(Collectors.toList());
        lengthSorted.stream().forEach(System.out::println);

        System.out.println("===========================<Max marks student>================================================");

        Student s = map.stream().max((o1,o2)-> o1.getMarks() <o2.getMarks() ? -1: o1.getMarks()>o2.getMarks() ? 1 : 0).get();
        System.out.print(s);


        System.out.println("===========================<Student Name & marks >================================================");
         map.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getMarks)).collect(Collectors.toList()).forEach(ss->System.out.println(ss.getName()+"("+ss.getMarks()+")"));
    }
}
