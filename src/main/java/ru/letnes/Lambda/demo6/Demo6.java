package ru.letnes.Lambda.demo6;


import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo6 {
    private static final Logger logger = Logger.getLogger("demo6");

    public static void main(String[] args) {
        JSExecutor jsExecutor = new JSExecutor();
        Object result = jsExecutor.executeFunction("validate", 10);
        System.out.println(null != result ? result.toString() : "error");
    }

    public static class JSExecutor {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Invocable invoker = (Invocable) engine;

        JSExecutor() {
            try {
                File script = new File("script.js");
                String scriptString = new String(Files.readAllBytes(script.toPath()));
                engine.eval(scriptString);
            } catch (final ScriptException | IOException se) {
                se.printStackTrace();
            }
        }

        Object executeFunction(String name, Object... args) {
            Object result = null;
            try {
                result = invoker.invokeFunction(name, args);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Can't run JS!", e);
            }
            return result;
        }
    }

}
