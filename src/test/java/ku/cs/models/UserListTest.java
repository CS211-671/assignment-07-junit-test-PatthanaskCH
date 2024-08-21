package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        UserList.addUser("John", "password123");
        UserList.addUser("Jane", "password456");
        UserList.addUser("Jone", "password789");
        // TODO: find one of them
        User user = userList.findUserByUsername("Jane");
        // TODO: assert that UserList found User
        String expected = "Jane";
        String actual = user.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        UserList.addUser("John", "password123");
        UserList.addUser("Jane", "password456");
        UserList.addUser("Jone", "password789");
        // TODO: change password of one user
        boolean actual = userList.changePassword("Jane", "password456", "newpassword456");
        // TODO: assert that user can change password
        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        UserList.addUser("John", "password123");
        UserList.addUser("Jane", "password456");
        UserList.addUser("Jone", "password789");
        // TODO: call login() with correct username and password
        User user = userList.login("Jane", "password456");
        // TODO: assert that User object is found
        assertNotNull(user);
        assertEquals("Jane", user.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        UserList.addUser("John", "password123");
        UserList.addUser("Jane", "password456");
        UserList.addUser("Jone", "password789");
        // TODO: call login() with incorrect username or incorrect password
        User user = userList.login("Jane", "wrongpassword");
        // TODO: assert that the method return null
        assertNull(user);
    }

}