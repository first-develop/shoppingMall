import org.apache.tools.ant.BuildException;
import org.mybatis.generator.ant.GeneratorAntTask;

/**
 * @author chigs
 * @time 2019年3月20日
 * 启动mybatis生成器自动生成实体类、Dao、*Map.xml。
 */
public class Copy {

    private static final String CONFIG_FILE_PATH = "src/main/resources/generatorConfig.xml";

    public static void main(String[] args) {
        try {
            GeneratorAntTask task = new GeneratorAntTask();
            task.setConfigfile(CONFIG_FILE_PATH);
            task.setOverwrite(true);
            task.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}