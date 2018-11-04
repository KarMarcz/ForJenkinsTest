import java.io.ObjectStreamClass;
import java.util.Properties;

public class SystemProperty {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.arch"));
        System.out.println(Boolean.valueOf(System.getenv("FROM_LINUX")));
        System.out.println(System.getProperties());
        Properties p = System.getProperties();
        p.list(System.out);
    }
}
