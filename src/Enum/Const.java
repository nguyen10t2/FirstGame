package Enum;

public enum Const {
    height(1015),
    width(600);

    private final int value;

    Const(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
