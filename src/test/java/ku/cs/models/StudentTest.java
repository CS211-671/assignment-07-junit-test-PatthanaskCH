package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s1;

    @BeforeEach
    void init() {
        s1 = new Student("61xxxxxx", "kong");
    }

    @Test
    @DisplayName("ทดสอบ AddScore")
    void testAddScore(){
//      Student s1 = new Student("61xxxxxx", "kong");
        assertEquals(0, s1.getScore());
        s1.addScore(40.5);
        assertEquals(40.5, s1.getScore());
        s1.addScore(10);
        assertEquals(50.5, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบ CalculateGarde")
    void testCalculateGarde(){
//      Student s1 = new Student("61xxxxxx", "kong");
        s1.addScore(60.8);
        assertEquals("C", s1.grade());
    }

    @Test
    @DisplayName("ทดสอบ ChangeName")
    void testChangeName() {

        Student student = new Student("6610450001", "John");

        student.changeName("Jane");
        assertEquals("Jane", student.getName());
    }
}