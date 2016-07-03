package luismoramedina;

/**
 * Wraps current thread data
 *
 * @author luismoramedina
 *
 */
public class MyHolder {

    private static ThreadLocal<String> data = new InheritableThreadLocal<>();
//    private ThreadLocal<String> data = new ThreadLocal<>();

    /**
     * Get current data
     *
     * @return current data
     */
    public String get() {
        return data.get();
    }

    /**
     * Sets current data
     *
     * @param token current data
     */
    public void put(String token) {
        data.set(token);
    }

    /**
     * Removes current data
     */
    public void clear() {
        data.remove();
    }

}
