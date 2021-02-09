package workshop.refactor;

import java.util.List;

import lombok.Data;

@Data
public class Speaker {
    private String firstName;
    private String lastName;
    private String email;
    private int exp;
    private int registrationFee;
    private boolean hasBlog;
    private String blogUrl;
    private List<String> certifications;
}
