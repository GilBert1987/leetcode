package com.gilbert.basic;

public class ExceptionTest {
    private static class Excepation1 extends Exception {

    }
    private static class Excepation2 extends RuntimeException {

    }

    public static void test1() throws Excepation1 {
        throw new ExceptionTest.Excepation1();
        // InterruptedException
        // IOException
    }

    public static void test2() {
        throw new ExceptionTest.Excepation2();
        // IllegalArgumentException
    }

    public static void main(String[] argv) {
        try {
            test1();
        } catch (Excepation1 ex) {

        }
        test2();
    }
}
