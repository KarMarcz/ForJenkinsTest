import java.io.ObjectStreamClass;

public class SystemProperty {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name").toLowerCase());
    }
}
