package ru.letnes;

import org.junit.*;

public class MainTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}