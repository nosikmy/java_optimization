import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoryMonitor {

    public static class Arr {
        public int[] array = new int[1024*1024];
    }

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        List<Arr> list = new ArrayList<>();

        try (FileWriter writer = new FileWriter("memory_usage.txt")) {

            while (true){

                try {
                    // Выполняем аллокацию памяти
//                byte[] array = new byte[random.nextInt(1024 * 1024 - 1024) + 1024];
                    list.add(new Arr());

                    MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
                    long maxMemory = heapMemoryUsage.getMax();
                    long committedMemory = heapMemoryUsage.getCommitted();
                    long usedMemory = heapMemoryUsage.getUsed();
                    long freeMemory = committedMemory - usedMemory;

                    String measurement = String.format("%d %d %d %d",
                            maxMemory,committedMemory, usedMemory, freeMemory);

                    System.out.println(measurement); // Выводим измерение в консоль

                    writer.write(measurement + "\n"); // Записываем измерение в файл
                    writer.flush();
                }catch (OutOfMemoryError e) {
                    System.out.println("Out of memory");
                    break;
                }
            }
        }
    }
}
