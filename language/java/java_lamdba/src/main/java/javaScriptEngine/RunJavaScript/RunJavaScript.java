package javaScriptEngine.RunJavaScript;
import javaScriptEngine.Exception.NoScriptFileAddress;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class RunJavaScript {

	private static ScriptEngine engine;

	private static Bindings bindings;

	private static String scriptFilleAddress;

	private static String scriptFileFunctionName;

	private static RunJavaScript runJavaScript;

	private RunJavaScript() {
		init();
	}

	public static RunJavaScript GetInstance() {
		if (runJavaScript == null) {
			runJavaScript = new RunJavaScript();
		}
		return runJavaScript;
	}

	private void init() {
		engine = new ScriptEngineManager().getEngineByName("javascript");
		bindings = engine.createBindings();
		engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
	}

	public Object runFunction(Object... args)
			throws FileNotFoundException, ScriptException, NoSuchMethodException, NoScriptFileAddress {
		Object result;
		if (scriptFilleAddress == null) {
			throw new NoScriptFileAddress("没有输入脚本文件地址");
		}
		if (scriptFileFunctionName == null) {
			throw new NoScriptFileAddress("没有输入脚本文件函数名");
		}
		engine.eval(new FileReader(scriptFilleAddress));
		if (engine instanceof Invocable) {
			Invocable invocable = (Invocable) engine;
			if (args.length == 1) {
				result = invocable.invokeFunction(scriptFileFunctionName, args[0]);
			} else if (args.length == 2) {
				result = invocable.invokeFunction(scriptFileFunctionName, args[0], args[1]);
			} else {
				result = invocable.invokeFunction(scriptFileFunctionName, args[0], args[1], args[2]);
			}
			return result;
		} else {
			return null;
		}
	}

	public void setScriptFilleAddress(String scriptFilleAddress) {
		this.scriptFilleAddress = scriptFilleAddress;
	}

	public void setScriptFileFunctionName(String scriptFileFunctionName) {
		this.scriptFileFunctionName = scriptFileFunctionName;
	}
}
