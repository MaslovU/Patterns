package command2;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    private int position;

    public Frog() {
        position = 5;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        int currentPosition = position + steps;
        return currentPosition >= MIN_POSITION && currentPosition <= MAX_POSITION;
    }
}