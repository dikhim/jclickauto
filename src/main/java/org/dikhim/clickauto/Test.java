package org.dikhim.clickauto;

public class Test {
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.testQuickStartStop();
        test.testStartStopDelay(100, 50);
        test.testMouseMove();
        test.testInfLoop();
        test.testMultiplePut();
//        test.testStartStopDelay(50, 100);
//        test.testStartStopDelay(100, 100);


//        test.testStartStopDelay(100,200);
//        test.testStartStopDelay(200,100);
//        test.testStartStopDelay(200,200);
//        test.testStartStopDelay(200,300);
//       test.testStartStopDelay(300,300);
       // test.testStartStopDelay(1000, 1000);
//        test.testStartStop();
    }

    private ItAuto itAuto = new ItAuto();


    private void testInfLoop() throws InterruptedException {
        itAuto.reset();
        itAuto.put("for(;;){" +
                "mouse.move(1,0);" +
                "};");
        itAuto.start();

        Thread.sleep(1000);
        itAuto.stop();
        System.out.println("testInfLoop done");
    }

    private void testMouseMove() throws InterruptedException {
        itAuto.reset();
        itAuto.put("for(i=0;i<40;i++){" +
                "mouse.move(0,1);" +
                "};");
        itAuto.start();
        Thread.sleep(1000);
        itAuto.stop();
        System.out.println("testMouseMove done");
    }

    private void testMultiplePut() throws InterruptedException {
        itAuto.reset();
        itAuto.put("for(i=0;i<40;i++){" +
                "mouse.move(0,1);" +
                "};");
        itAuto.put("for(i=0;i<40;i++){" +
                "mouse.move(1,0);" +
                "};");
        itAuto.put("for(i=0;i<40;i++){" +
                "mouse.move(1,1);" +
                "};");
        itAuto.start();
        Thread.sleep(3000);
        itAuto.stop();
        System.out.println("testMouseMove done");
    }

    private void testQuickStartStop() throws InterruptedException {
        System.out.println("testQuickStartStop 1");

        // inf loop
        itAuto.reset();
        itAuto.put("for(;;){" +
                "mouse.move(1,0);" +
                "};");

        itAuto.start();
        Thread.sleep(50);
        itAuto.stop();
        Thread.sleep(50);

        System.out.println("testQuickStartStop 2");

        itAuto.start();
        Thread.sleep(50);
        itAuto.stop();
        Thread.sleep(50);
    }

    private void testStartStopDelay(int runMs, int stopMs) throws InterruptedException {
        System.out.println(String.format("testStartStop runMs=%s, stopMs=%s", runMs, stopMs));
        // inf loop
        itAuto.reset();
        itAuto.put("for(;;){" +
                "mouse.move(1,0);" +
                "};");


        int count = 0;
        for (int i = 0; i < 5; i++) {
            itAuto.start();
            Thread.sleep(runMs);
            itAuto.stop();
            Thread.sleep(stopMs);
            System.out.println(++count + " stop" + " out of " + 5);
        }
    }
}
