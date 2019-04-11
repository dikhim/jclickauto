package org.dikhim.clickauto;

public class Test {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        ItAuto itAuto = new ItAuto();
        itAuto.run("    x0 = 300;\n" +
                "    y0 = 300;\n" +
                "    r=100;\n" +
                "    dL = 4;\n" +
                "    n=2;\n" +
                "    system.println('x0:'+x0+', y0:'+y0\n" +
                "        +\", r:\"+r+\", dL:\"+dL+\", n:\"+n);\n" +
                "    for(L=0;L<360*n;L+=dL){\n" +
                "        dx = Math.cos(radians(L))*r;\n" +
                "        dy = Math.sin(radians(L))*r;\n" +
                "        x1 = x0+dx;\n" +
                "        y1 = y0+dy;\n" +
                "        mouse.moveTo(x1,y1)\n" +
                "        system.sleep(10);\n" +
                "    }\n" +
                "\t\n" +
                "function radians(degrees){\n" +
                "    return degrees * Math.PI / 180;\n" +
                "}");
    }
}
