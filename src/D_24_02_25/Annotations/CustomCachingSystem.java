package D_24_02_25.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}
class ExpensiveComputation {
    private static final Map<String, Object> cache = new HashMap<>();
    @CacheResult
    public int computeFactorial(int n) {
        if (cache.containsKey(String.valueOf(n))) {
            return (int) cache.get(String.valueOf(n));
        }
        int result = (n <= 1) ? 1 : n * computeFactorial(n - 1);
        cache.put(String.valueOf(n), result);
        return result;
    }
}
public class CustomCachingSystem {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();
        System.out.println(computeWithCache(computation, "computeFactorial", 5));
        System.out.println(computeWithCache(computation, "computeFactorial", 5));
        System.out.println(computeWithCache(computation, "computeFactorial", 6));
    }
    private static Object computeWithCache(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, int.class);
        if (method.isAnnotationPresent(CacheResult.class)) {
            return method.invoke(obj, args);
        }
        return method.invoke(obj, args);
    }
}
