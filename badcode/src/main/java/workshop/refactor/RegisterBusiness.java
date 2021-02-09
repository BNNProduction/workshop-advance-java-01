package workshop.refactor;

import java.util.Arrays;
import java.util.List;

public class RegisterBusiness {

	public Integer register(SpeakerRepository repository, Speaker speaker) {
		Integer speakerId = null;
		
		if (validate(speaker)) {
			if(repository == null) {
				throw new SaveSpeakerException("Can't save a speaker.");
			}
			int exp = speaker.getExp();
			speaker.setRegistrationFee(getfee(exp));
			speakerId = repository.saveSpeaker(speaker);
		}

		return speakerId;
	}
	
	public boolean validate(Speaker speaker) {
		String[] domains = { "gmail.com", "live.com" };

		if (!(speaker.getFirstName() != null && !speaker.getFirstName().trim().equals(""))) {
			throw new ArgumentNullException("First name is required.");
		}

		if (!(speaker.getLastName() != null && !speaker.getLastName().trim().equals(""))) {
			throw new ArgumentNullException("Last name is required.");
		}

		if (!(speaker.getEmail() != null && !speaker.getEmail().trim().equals(""))) {
			throw new ArgumentNullException("Email is required.");
		}
		
		String emailDomain = getEmail(speaker.getEmail());

		if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != 1) {
			throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
		}
		return true;

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
