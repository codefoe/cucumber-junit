package hooks;

import io.cucumber.java.Before;

import javax.script.ScriptException;
import java.io.IOException;


public class BeforeHook {
    @Before
    public void callConfigJS() throws ScriptException, IOException, NoSuchMethodException {
//        ScriptEngineManager factory = new ScriptEngineManager();
//        ScriptEngine engine = factory.getEngineByName("JavaScript");
//        File file = new File("src/config.js");
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String config_js = "";
//        String st;
//        while ((st = br.readLine()) != null) {
//            System.out.println(st);
//            config_js += st;
//        }
//        engine.eval(config_js);
//        String str = "";
//        str = (String)((Invocable)engine).invokeFunction("fn");
//
//        System.out.println(str);
    }
}



