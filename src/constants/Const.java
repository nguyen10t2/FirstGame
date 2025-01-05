package constants;

public enum Const {
    height(600),
    width(1015);

    private final int value;

    Const(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
