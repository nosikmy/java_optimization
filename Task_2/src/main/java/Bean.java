import java.util.ArrayList;
import java.util.List;

public class Bean {
    private final byte[] bytes = new byte[10000];
    private final List<String> list = new ArrayList<>();
    private final int primitive = 200;
    private Bean link = this;

    public void setLink(Bean link){
        this.link = link;
    }

}