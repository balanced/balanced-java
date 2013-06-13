
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.asfun.jangod.template.TemplateEngine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class RenderScenarios {

    final static TemplateEngine engine;
    static {
        engine = new TemplateEngine();
        engine.getConfiguration().setWorkspace("/Users/pc/Code/balanced-java/src/scenarios");
    }

    public static Map<String, Object> loadScenarioCache() throws IOException, JsonMappingException {
        String projectRoot = System.getProperty("user.dir");
        String cacheJson = readFile(projectRoot.concat("/src/scenarios/scenario.cache"));
        HashMap result =
                new ObjectMapper().readValue(cacheJson, HashMap.class);
        return result;
    }

    public static String render(String templateFile, Map<String,Object> data)
            throws IOException {
        return engine.process(templateFile, data);
    }

    public static void writeFile(String pathToFile, String content) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(pathToFile);
        out.println(content);
        out.close();
    }

    public static String readFile(String pathToFile) throws FileNotFoundException {
        String content = new Scanner(new File(pathToFile)).useDelimiter("\\Z").next();
        return content;
    }

    public static void renderScenario(String scenario, String scenarioPath) throws IOException {

        Map<String,Object> data = new HashMap<String, Object>();
        Map<String, Object> result =  loadScenarioCache();
        HashMap requestData;
        requestData = null;
        String apiKey = null;
        try {
            apiKey = (String) result.get("api_key");
            requestData = ((HashMap)((HashMap)result.get(scenario)).get("request"));
        } catch (Exception e) {
            System.out.println("Scenario not found in scenario.cache");
        }
        data.put("request", requestData);

        String scenarioDefinition = render(scenarioPath.concat("/definition.tmpl"), null);
        String scenarioRequest = render(scenarioPath.concat("/request.tmpl"), data);

        // Output java scenario
        Map<String, Object> javaData = new HashMap<String, Object>();
        javaData.put("snippet", scenarioRequest);
        javaData.put("api_key", apiKey);
        javaData.put("scenario", scenario);
        String javaScenario = render(scenarioPath.concat("/../Scenario.java.tmpl"), javaData);
        String javaFileName = scenarioPath + "/" + scenario + ".java";
        writeFile(javaFileName, javaScenario);
        CompileSourceInMemory.runClassFromSource(javaFileName, scenario);

        // Output mako template
        Map<String,Object> makoData = new HashMap<String, Object>();
        makoData.put("definition", scenarioDefinition);
        makoData.put("request", scenarioRequest);
        String renderedMakoFile = render(scenarioPath.concat("/../java.mako.tmpl"), makoData);
        writeFile(scenarioPath.concat("/java.mako"), renderedMakoFile);
    }

    public static List<String> getScenarioPaths() {
        List<String> scenarioPaths = new ArrayList<String>();
        String projectRoot = System.getProperty("user.dir");
        File currentDirectory = new File(projectRoot.concat("/src/scenarios"));
        File[] scenarios = currentDirectory.listFiles();
        for (File file : scenarios) {
            if (file.isDirectory()) {
                scenarioPaths.add(file.toString());
            }
        }
        return scenarioPaths;
    }

    public static void main(String[] args) throws IOException, JsonMappingException {
        for (String scenarioPath : getScenarioPaths()) {
            String scenario = new File(scenarioPath).getName();
            System.out.println(scenario);
            renderScenario(scenario, scenarioPath);
        }


    }

}
