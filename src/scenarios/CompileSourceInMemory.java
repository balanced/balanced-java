import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.Arrays;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject.Kind;

public class CompileSourceInMemory {
    public static void runClassFromSource(String relativePathToClass, String scenarioName) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        JavaFileObject file = new JavaSourceFromString(relativePathToClass, null);
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        CompilationTask task = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);
        boolean success = task.call();
        System.out.println("Success: " + success);
//        if (success) {
//            try {
//                Class.forName(scenarioName + "." + scenarioName).getDeclaredMethod("main", new Class[] { String[].class })
//                        .invoke(null, new Object[] { null });
//            } catch (ClassNotFoundException e) {
//                System.err.println("Class not found: " + e);
//            } catch (NoSuchMethodException e) {
//                System.err.println("No such method: " + e);
//            } catch (IllegalAccessException e) {
//                System.err.println("Illegal access: " + e);
//            } catch (InvocationTargetException e) {
//                System.err.println("Invocation target: " + e);
//            }
//        }
    }
}

class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}