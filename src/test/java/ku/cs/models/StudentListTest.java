package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void init() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("Adding a new student should succeed if ID and name are valid")
    void testAddNewStudent() {
        studentList.addNewStudent("6610450001", "John");
        Student student = studentList.findStudentById("6610450001");
        assertNotNull(student);
        assertEquals("John", student.getName());
    }

    @Test
    @DisplayName("Adding a new student with score should succeed if ID, name, and score are valid")
    void testAddNewStudentWithScore() {
        studentList.addNewStudent("6610450002", "Jane", 85.0);
        Student student = studentList.findStudentById("6610450002");
        assertNotNull(student);
        assertEquals("Jane", student.getName());
        assertEquals(85.0, student.getScore());
    }

    @Test
    @DisplayName("Finding a student by ID should return the correct student")
    void testFindStudentById() {
        studentList.addNewStudent("6610450003", "Jone");
        Student student = studentList.findStudentById("6610450003");
        assertNotNull(student);
        assertEquals("Jone", student.getName());
    }

    @Test
    @DisplayName("Giving a score to a student should update the student's score")
    void testGiveScoreToId() {
        studentList.addNewStudent("6610450004", "Alice");
        studentList.giveScoreToId("6610450004", 90.0);
        Student student = studentList.findStudentById("6610450004");
        assertNotNull(student);
        assertEquals(90.0, student.getScore(), 0.01);
    }

    @Test
    @DisplayName("Viewing grade of a student should return the correct grade")
    void testViewGradeOfId() {
        studentList.addNewStudent("6610450005", "Bob", 75.0);
        String grade = studentList.viewGradeOfId("6610450005");
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("Getting all students should return the correct list of students")
    void testGetStudents() {
        studentList.addNewStudent("6610450006", "Charlie");
        studentList.addNewStudent("6610450007", "David", 88.0);
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());
        assertEquals("Charlie", students.get(0).getName());
        assertEquals("David", students.get(1).getName());
    }

    @Test
    @DisplayName("Adding a student with duplicate ID should not add the student")
    void testAddDuplicateStudent() {
        studentList.addNewStudent("6610450008", "Eve");
        studentList.addNewStudent("6610450008", "Eva");
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("Eve", students.get(0).getName());
    }

    @Test
    @DisplayName("Giving score to a non-existent student should not throw an error")
    void testGiveScoreToNonExistentStudent() {
        assertDoesNotThrow(() -> studentList.giveScoreToId("6610450009", 95.0));
        assertNull(studentList.findStudentById("6610450009"));
    }

    @Test
    @DisplayName("Viewing grade for a non-existent student should return null")
    void testViewGradeOfNonExistentStudent() {
        assertNull(studentList.viewGradeOfId("6610450010"));
    }
}