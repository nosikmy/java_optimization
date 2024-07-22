import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Methods {
    public static int getLength(String string) {
        return string.length();
    }

    public static Object callMethod(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            return method.invoke(obj);
        } catch (Exception e) {
            System.err.println("Can't invoke method");
            return null;
        }
    }

    public static void changeField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
