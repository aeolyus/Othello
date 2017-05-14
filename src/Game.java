/**
 * Interface for a game
 */
public interface Game{
	/**
	 * Returns true if it is game over
	 */
    public boolean gameOver();
    /**
     * Starts the game
     */
    public void start();
    /**
     * Plays the game
     */
    public void play();
    // public void restart(); use with start
}