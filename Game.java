public interface Game{
    public void gameOver();
    public void start();
    public boolean isLegal(int i, int j);
    public void play();
    // public void restart(); use with start
}