package org.dikhim.clickauto;


import org.junit.Test;

public class ItAutoTest {
    @Test
    public void run() {
        ItAuto itAuto = new ItAuto();
        itAuto.run("mouse.moveTo(0,0);");
    }
}
