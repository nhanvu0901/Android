public class Email {

    private String from;
    private String subject;
    private String message;

    public Email(String from, String subject, String message) {
        this.from = from;
        this.subject = subject;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}