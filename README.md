# JClickAuto
This library helps to control the mouse, keyboard, clipborad and a lot of other things

# Quick launch

Add the jar file to your project or add the maven dependency to your pom file
```xml
<!-- https://mvnrepository.com/artifact/io.github.dikhim/jclickauto -->
<dependency>
    <groupId>io.github.dikhim</groupId>
    <artifactId>jclickauto</artifactId>
    <version>1.1</version>
</dependency>
```




## Using script interface 
```java
import org.dikhim.clickauto.ClickAuto;
public class Main {
    public static void main(String[] args) {
        ClickAuto clickAuto = new ClickAuto();
        String script =
                "for (i = 0; i < 100; i++) {" +
                "    mouse.move(1, 1);" +
                "}";
        clickAuto.put(script);
        clickAuto.start();
    }
}
```


## Using object interface 
```java
import org.dikhim.clickauto.jsengine.objects.MouseObject;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws AWTException {
        ClickAuto clickAuto = new ClickAuto();
        MouseObject mouse = (MouseObject) clickAuto.objectContainer().get("mouse");

        for (int i = 0; i < 100; i++) {
            mouse.move(1, 1);
        }
    }
}
```
Here two examples how to smoothly move your mouse 100 pixels right and down (diagonally)

Other examples you can wind in Wiki tab
