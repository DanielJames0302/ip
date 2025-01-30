package buddy.exception;

public class BuddyDataStorageException extends BuddyException {

    public BuddyDataStorageException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.message;
    }
}
