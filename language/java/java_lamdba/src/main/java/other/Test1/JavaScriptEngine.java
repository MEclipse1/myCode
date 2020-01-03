package other.Test1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptEngine {
	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		Bindings bindings = engine.createBindings();
		bindings.put("factor", 1);
		engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
		engine.eval(new FileReader("C:/Users/drx/Desktop/mode.js"));
		if (engine instanceof Invocable) {
			Invocable invocable = (Invocable) engine;
			Double result = (Double) invocable.invokeFunction("formual", 1, 2);
			System.out.println(result.intValue());
		}
	}

	private JavaScriptEngine() {
	};

	static ScriptEngine engine = null;

	public static ScriptEngine getScriptEngin() {
		if (engine == null) {

		}
		return engine;
	}

}
