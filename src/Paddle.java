import java.util.Set;

public class Paddle {
    private final int upKey;
    private final int downKey;

    public Paddle(int upKey, int downKey) {
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public void handleActiveKeys(Set<Integer> activeKeys) {
        if (activeKeys.contains(upKey)) {

        }
    }
}
