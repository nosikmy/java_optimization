import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("methods")) {
                ClassForMethods justClass = new ClassForMethods(10, "Hello");
                int len = Methods.getLength(justClass.getStringField());
                System.out.println(len);

                Object res = Methods.callMethod(justClass, "getIntField");
                if (res != null) {
                    System.out.println("Res: " + (int) res);
                }

                Methods.changeField(justClass, "intField", 20);
                res = Methods.callMethod(justClass, "getIntField");
                if (res != null) {
                    System.out.println("Res: " + (int) res);
                }
            } else if (args[0].equals("sortValue")) {
                List<ClassValue> classValueList = new ArrayList<>();
                Random random = new Random();
                for (int i = 0; i < 20; i++) {
                    classValueList.add(new ClassValue(random.nextInt()));
                }
                ClassValue.sort(classValueList);
                for (int i = 0; i < 20; i++) {
                    System.out.println("i: " + i + " " + classValueList.get(i));
                }
            }
        }
    }
}
