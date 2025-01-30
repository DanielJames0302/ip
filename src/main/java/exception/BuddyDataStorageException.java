package exception;

public class BuddyDataStorageException extends BuddyException {
    private String messageString;

    public BuddyDataStorageException(String messageString) {
        this.messageString = messageString;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.messageString;
    }
}
