/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tdd_or_nottdd_that_is_the_question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {
    @Test
    void appHasAGreeting() {
        assertNotNull(App.HELLO_WORLD, "app should have a constant");
    }
}
