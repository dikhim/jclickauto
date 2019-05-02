package org.dikhim.clickauto;

import org.dikhim.clickauto.jsengine.objects.MouseObject;

import java.awt.*;

public class Test {
    public Test() throws AWTException {
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
//        test.testQuickStartStop();
//        test.testStartStopDelay(100, 50);
//        test.testMouseMove();
//        test.testInfLoop();
//        test.testMultiplePut();
//        test.testStartStopDelay(50, 100);
//        test.testStartStopDelay(100, 100);


//        test.testStartStopDelay(100,200);
//        test.testStartStopDelay(200,100);
//        test.testStartStopDelay(200,200);
//        test.testStartStopDelay(200,300);
//       test.testStartStopDelay(300,300);
       // test.testStartStopDelay(1000, 1000);
//        test.testStartStop();
        test.testMultipleRuns();
    }

    private ClickAuto clickAuto = new ClickAuto();


    private void testInfLoop() throws InterruptedException {
        clickAuto.reset();
        clickAuto.putScript("for(;;){" +
                "mouse.move(1,0);" +
                "};");
        clickAuto.start();

        Thread.sleep(5000);
        clickAuto.stop();
        System.out.println("testInfLoop done");
    }

    private void testMouseMove() throws InterruptedException {
        clickAuto.reset();
        clickAuto.putScript("for(i=0;i<40;i++){" +
                "mouse.move(0,1);" +
                "};");
        clickAuto.start();
        Thread.sleep(1000);
        clickAuto.stop();
        System.out.println("testMouseMove done");
    }

    private void testMultiplePut() throws InterruptedException {
        clickAuto.reset();
        clickAuto.putScript("for(i=0;i<40;i++){" +
                "mouse.move(0,1);" +
                "};");
        clickAuto.putScript("for(i=0;i<40;i++){" +
                "mouse.move(1,0);" +
                "};");
        clickAuto.putScript("for(i=0;i<40;i++){" +
                "mouse.move(1,1);" +
                "};");
        clickAuto.start();
        Thread.sleep(3000);
        clickAuto.stop();
        System.out.println("testMouseMove done");
    }

    private void testQuickStartStop() throws InterruptedException {
        System.out.println("testQuickStartStop 1");

        // inf loop
        clickAuto.reset();
        clickAuto.putScript("for(;;){" +
                "mouse.move(1,0);" +
                "};");

        clickAuto.start();
        Thread.sleep(50);
        clickAuto.stop();
        Thread.sleep(50);

        System.out.println("testQuickStartStop 2");

        clickAuto.start();
        Thread.sleep(50);
        clickAuto.stop();
        Thread.sleep(50);
    }

    private void testStartStopDelay(int runMs, int stopMs) throws InterruptedException {
        System.out.println(String.format("testStartStop runMs=%s, stopMs=%s", runMs, stopMs));
        // inf loop
        clickAuto.reset();
        clickAuto.putScript("for(;;){" +
                "mouse.move(1,0);" +
                "};");


        int count = 0;
        for (int i = 0; i < 5; i++) {
            clickAuto.start();
            Thread.sleep(runMs);
            clickAuto.stop();
            Thread.sleep(stopMs);
            System.out.println(++count + " stop" + " out of " + 5);
        }
    }
    
    private void testInterruption() throws InterruptedException {
        System.out.println("testInterruption");
        // inf loop
        clickAuto.reset();
        clickAuto.putScript("for(;;){" +
                "mouse.move(1,0);" +
                "if(thread.interrupted()){" +
                "mouse.moveTo(0,0);" +
                "break;" +
                "}};");
        clickAuto.start();
        
        Thread.sleep(1000);
        clickAuto.stop();
    }
    
    private void testOverriding() {
        System.out.println("testOverriding");
        clickAuto.reset();
        MySystemObject mySystemObject = new MySystemObject(clickAuto.getEngine());
        clickAuto.objectContainer().put("system", mySystemObject);
        clickAuto.putScript("system.println('hello world');");
        MouseObject mouse = (MouseObject)clickAuto.objectContainer().get("mouse");
        mouse.moveTo(0,0);
        clickAuto.start();      
        Thread.currentThread().destroy();
    }
    
    private void testMultipleRuns() throws InterruptedException {
        System.out.println("testMultipleRuns");
        clickAuto.putScript("function foo(){for(i=0;i<150;i++){" +
                "mouse.move(1,0);" +
                "}};" +
                "function bar(){for(i=0;i<150;i++){" +
                "mouse.move(0,1);" +
                "}};" );
        clickAuto.start();
        clickAuto.waitEvaluationComplete();
        clickAuto.callFunction("foo");
        clickAuto.waitAllThreadsEnd();
        clickAuto.callFunction("bar");
    }
    
}
