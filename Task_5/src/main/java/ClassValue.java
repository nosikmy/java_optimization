import java.util.List;

public class ClassValue {
    public int value;

    public ClassValue(int value) {
        this.value = value;
    }

    public static void sort(List<ClassValue> values) {
        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (values.get(i).value > values.get(j).value) {
                    int tmp = values.get(i).value;
                    values.get(i).value = values.get(j).value;
                    values.get(j).value = tmp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "value=" + value + ';';
    }
}
