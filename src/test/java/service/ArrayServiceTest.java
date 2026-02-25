package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {

    private ArrayService service;

    @BeforeEach
    public void setUp() {
        service = new ArrayService();
    }

     /*
        Тест кейсы:
        1. Передаём положительное число. Например, 5.
           Проверяем, корректно ли заполнены ячейки массива. Правильные ли там значения.
        2. Передаём отрицательное число. Например, -1.
           Проверяем, действительно ли метод выбрасывает ожидаемый эксепшен.
        3. Передаём положительное число. Например, 5.
           Проверяем, что нам вместо массива не возвращается null.
        4. Передаём положительное число. Например, 5.
           Проверяем, что нам вернулся массив именно размером 5.
         */

    /*
    Как написать тестовый метод?
    1. Тестовые методы всегда public void.
    2. Метод должен быть помечен аннотацией @Test.
    3. Метод должен иметь информативное название.
    4. Тело тестового метода должно вызывать исходный метод
       и проверять, правильные ли результаты даёт исходный метод.
    5. В случае провала теста он должен выводить информативное сообщение
       о причинах провала на консоль.
     */

    /*
     3. Передаём положительное число. Например, 5.
           Проверяем, что нам вместо массива не возвращается null.
     */
    @Test
    public void checkIfArrayIsNotNull() {
        int[] result = service.generateArrayBySize(5);
        assertNotNull(result, "Method returned a null instead of expected array");
    }

    /*
     4. Передаём положительное число. Например, 5.
     Проверяем, что нам вернулся массив именно размером 5.
     */
    @Test
    public void checkIfArraySizeIsCorrect() {
        int expectedSize = 5;
        int[] result = service.generateArrayBySize(expectedSize);
        int actualSize = result.length;
        assertEquals(expectedSize, actualSize, "Method returned an incorrect array size");
    }

    /*  2. Передаём отрицательное число. Например, -1.
        Проверяем, действительно ли метод выбрасывает ожидаемый эксепшен.
     */
    @Test
    public void expectExceptionIfArraySizeIsNegative() {
        assertThrows(
                IncorrectArraySizeException.class,
                () -> service.generateArrayBySize(-1),
                "The method did not throw the expected exception when the array size was negative."
        );
    }
}