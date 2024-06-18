
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
class StudentStack {
    private Stack<Student> stack;

    public StudentStack() {
        stack = new Stack<>();
    }

    public void push(Student student) {
        stack.push(student);
    }

    public Student pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.pop();
    }

    public Student peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void editStudent(int id, double newMarks) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!stack.isEmpty()) {
            Student student = stack.pop();
            if (student.getId() == id) {
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(int id) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!stack.isEmpty()) {
            Student student = stack.pop();
            if (student.getId() == id) {
                found = true;
            } else {
                tempStack.push(student);
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void sortStudents() {
        List<Student> studentList = new ArrayList<>(stack);
        studentList.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        stack.clear();
        for (Student student : studentList) {
            stack.push(student);
        }
    }

    public Student searchStudent(int id) {
        for (Student student : stack) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        if (stack.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : stack) {
                System.out.println(student);
            }
        }
    }
}
