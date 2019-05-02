package org.dikhim.clickauto;

import org.dikhim.clickauto.jsengine.ClickAutoScriptEngine;
import org.dikhim.clickauto.jsengine.objects.ScriptSystemObject;

public class MySystemObject extends ScriptSystemObject {

    public MySystemObject(ClickAutoScriptEngine engine) {
        super(engine);
    }

    @Override
    public void println(String string) {
        System.out.println(string);
    }
}
