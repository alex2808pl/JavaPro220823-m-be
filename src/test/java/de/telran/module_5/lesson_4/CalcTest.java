package de.telran.module_5.lesson_4;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    private int arg1Test;
    private int arg2Test;

    private int actualVal;

    private static Calc calc;

    @BeforeAll
    static void setUpAll() {  // один раз при создании класса
        System.out.println("--@BeforeAll--");
        calc = new Calc();
    }

    @AfterAll
    static void tearDownAll() {  //один раз при уничтожении класса
        System.out.println("--@AfterAll--");
        calc = null;
    }

    @BeforeEach
    void setUp() { // перед каждым тестом
        System.out.println("--@BeforeEach--");
        arg1Test = 4;
        arg2Test = 3;

    }

    @AfterEach
    void tearDown() { // после каждого теста
        System.out.println("--@AfterEach--");
        actualVal = 0;
    }

    @Test
    void addTest() {
        //expected
        int expVal = 7;
        //when

        actualVal =  calc.add(arg1Test, arg2Test);

        // Assert
        assertEquals(expVal, actualVal);
    }

    @Test
    //@Disabled
    void subTest() {
            //expected
            int expVal = 1;
            //when

            actualVal =  calc.sub(arg1Test, arg2Test);

            // Assert
            assertEquals(expVal, actualVal);
    }

    @Test
    void mulTest() {
        //expected
        int expVal = 12;
        //when

        actualVal =  calc.mul(arg1Test, arg2Test);

        // Assert
        assertEquals(expVal, actualVal);
    }

    @Test
    void divTest() throws InterruptedException {
        //expected
        int expVal = 1;
        //when

        actualVal =  calc.div(arg1Test, arg2Test);

        // Assert
        assertEquals(expVal, actualVal);
    }

    @Test
    void divThrowTest() { // обрабатываем исключения
        arg2Test = 0;
        assertThrows(IllegalArgumentException.class,
                () -> calc.div(arg1Test,arg2Test));
    }

    @Test
    void divTimeOutTest() { // обработка таймауту
        assertTimeout(Duration.ofMillis(2000),
                () -> calc.div(arg1Test,arg2Test));
    }
}