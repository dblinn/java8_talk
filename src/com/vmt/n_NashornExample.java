package com.vmt;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

public class n_NashornExample {
    @Test
    public void testNashorn() throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(
            "var x = 4 + 3;" +
            "print('4 + 3 = ' + x);"
        );
    }
}
