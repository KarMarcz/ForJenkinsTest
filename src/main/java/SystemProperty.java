import java.io.ObjectStreamClass;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class SystemProperty {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.arch"));
        System.out.println(Boolean.valueOf(System.getenv("FROM_LINUX")));
        System.out.println(System.getProperties());
        Properties p = System.getProperties();
        p.list(System.out);
        Map<String, String> envMap = System.getenv();

        Iterator<String> iterator = envMap.keySet().iterator();
        while (iterator.hasNext()) {
            String iteratorKey = iterator.next();
            System.out.println(iteratorKey + " : " + envMap.get(iteratorKey));
        }
    }
}
