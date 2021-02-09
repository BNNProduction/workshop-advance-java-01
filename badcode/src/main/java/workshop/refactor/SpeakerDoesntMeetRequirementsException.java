package workshop.refactor;

public class SpeakerDoesntMeetRequirementsException extends RuntimeException {
    public SpeakerDoesntMeetRequirementsException(String message) {
        super(message);
    }
}
