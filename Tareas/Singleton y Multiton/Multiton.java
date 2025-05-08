import java.util.HashMap;
public class Multiton {
    private static HashMap<String, Multiton> instances = new HashMap<>();
    private Multiton() {
    }
    public static Multiton getInstance(String key) {
        if (!instances.containsKey(key)) {
            instances.put(key, new Multiton());
        }
        return instances.get(key);
    }
}