import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("WeakerAccess")
public class FirstTest {
    @Test
    public void itShouldShowMeThatJUnitIsWorking() {
        boolean assertingWorksFine = true;
        assertTrue(assertingWorksFine);
    }

    @Test
    public void itShouldCreateClasses() {
        //Arrange
        MyClass testClass;

        //Act
        testClass = new MyClass();

        //Assert
        boolean testClassIsAMyClass = testClass instanceof MyClass;
        assertTrue(testClassIsAMyClass);
    }
}
