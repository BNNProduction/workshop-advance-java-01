package workshop.refactor;

import java.util.Arrays;
import java.util.List;

import org.junit.platform.commons.util.StringUtils;

public class RegisterBusiness {

	public Integer register(SpeakerRepository repository, Speaker speaker) {
		Integer speakerId = null;
		validate(speaker);
		if (repository == null) {
			throw new SaveSpeakerException("Can't save a speaker.");
		}
		int exp = speaker.getExp();
		speaker.setRegistrationFee(getfee(exp));
		speakerId = repository.saveSpeaker(speaker);

		return speakerId;
	}

	public void validate(Speaker speaker) {
		String[] domains = { "gmail.com", "live.com" };
		if (validateStr(speaker.getFirstName())) {
			throw new ArgumentNullException("First name is required.");
		}

		if (validateStr(speaker.getLastName())) {
			throw new ArgumentNullException("Last name is required.");
		}

		if (validateStr(speaker.getEmail())) {
			throw new ArgumentNullException("Email is required.");
		}

		String emailDomain = getEmail(speaker.getEmail());

		if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != 1) {
			throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
		}

	}

	public boolean validateStr(String val) {

		return !(val != null && !val.trim().isEmpty());

	}

	public int getfee(int exp) {
		int fee = 0;
		if (exp <= 1) {
			return 500;
		} else if (exp <= 3) {
			return 250;
		} else if (exp <= 5) {
			return 100;
		} else if (exp <= 9) {
			return 50;
		}

		return fee;
	}

	private String getEmail(String input) {
		String[] email = input.split("@");
		if (email.length == 2) {
			return email[1];
		}
		throw new EmailInvalidException("Email invalid.");
	}

}
