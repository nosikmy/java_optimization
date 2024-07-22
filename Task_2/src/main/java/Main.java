import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Bean> list = new ArrayList<>();
    static List<int[]> memList = new ArrayList<>();
    static int n = 5;

    public static void main(String[] args) {
        Runnable good = () -> {
            Singleton singleton = Singleton.getInstance();
            Bean bean  = new Bean();
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (Exception ignored) {
            }
        };
        Runnable bad = () -> {
            try {
                while (true){
                    memList.add(new int[1024]);
                }
            } catch (Exception ignored) {
            }
        };

        for (int i = 0; i < n; i++) {
            list.add(new Bean());
        }
        for (int i = 0; i < n; i++) {

            list.get(i).setLink(list.get((i + 1) % n));
        }

        for (int i = 0; i <  10; ++i) {
            Thread thread = new Thread(good);
            thread.start();
        }

        if(args.length > 0){
            Thread thread = new Thread(bad);
            thread.start();
        }
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}