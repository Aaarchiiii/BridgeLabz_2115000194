package D_24_02_25.Reflextion;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();
    public void register(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            instances.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register class: " + clazz.getSimpleName(), e);
        }
    }
    public void injectDependencies(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> dependencyType = field.getType();
                    Object dependency = instances.get(dependencyType);
                    if (dependency == null) {
                        dependency = dependencyType.getDeclaredConstructor().newInstance();
                        instances.put(dependencyType, dependency);
                    }
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to inject dependencies", e);
        }
    }
}
class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}
class Client {
    @Inject
    private Service service;
    public void run() {
        service.serve();
    }
}
public class DependencyInjectionExample {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        container.register(Service.class);
        Client client = new Client();
        container.injectDependencies(client);
        client.run();
    }
}
