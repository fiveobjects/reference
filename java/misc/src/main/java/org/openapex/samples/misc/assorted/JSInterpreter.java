package org.openapex.samples.misc.assorted;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JSInterpreter {
    public static void eval (String input) throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(input);
    }
    public static void main (String[ ] args) throws Exception{
        JSInterpreter Program = new JSInterpreter();
        Program.eval("print('hello');");
    }
}
