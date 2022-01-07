package fr.yncrea.cin3.minesweeper.domain;

public enum tab {
    EMPTY(""), X("X"), O("O");

    public final String string;

    private tab(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
