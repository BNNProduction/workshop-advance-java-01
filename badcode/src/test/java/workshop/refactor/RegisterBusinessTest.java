package workshop.refactor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

	// =============== Failure cases
	@Test
	public void register_with_empty_firstname_should_throw_ArgumentNullException() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("");

		// Act
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			registerBusiness.register(null, newSpeaker);
		});

		// Assert
		assertEquals("First name is required.", exception.getMessage());
	}

	@Test
	public void register_with_empty_lastname_should_throw_ArgumentNullException() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("");

		// Act
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			registerBusiness.register(null, newSpeaker);
		});

		// Assert
		assertEquals("Last name is required.", exception.getMessage());
	}

	@Test
	public void register_with_empty_email_should_throw_ArgumentNullException() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("");

		// Act
		Exception exception = assertThrows(ArgumentNullException.class, () -> {
			registerBusiness.register(null, newSpeaker);
		});

		// Assert
		assertEquals("Email is required.", exception.getMessage());
	}

	@Test
	public void register_with_invalid_domain_of_email_should_throw_SpeakerDoesntMeetRequirementsException() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@invalid.com");

		// Act
		Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
			registerBusiness.register(null, newSpeaker);
		});

		// Assert
		assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
	}

	@Test
	public void can_not_save_speaker_throw_SaveSpeakerException() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@gmail.com");

		// Act
		Exception exception = assertThrows(SaveSpeakerException.class, () -> {
			registerBusiness.register(null, newSpeaker);
		});

		// Assert
		assertEquals("Can't save a speaker.", exception.getMessage());
	}

	// =============== Success cases

	@Test
	public void register_success() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@gmail.com");

		// Stub dependency
		SpeakerRepository stub = new SpeakerRepository() {
			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return new Integer(100);
			}
		};

		// Act
		Integer speakerId = registerBusiness.register(stub, newSpeaker);

		// Assert
		assertNotNull(speakerId);
		assertEquals(100, speakerId);
	}

	@Test
	public void register_email_valid() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("gmail.com");

		// Act
		Exception exception = assertThrows(EmailInvalidException.class, () -> {
			registerBusiness.register(null, newSpeaker);
		});

		// Assert
		assertEquals("Email invalid.", exception.getMessage());
	}

	@Test
	public void register_exp_less_than_1() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@gmail.com");
		newSpeaker.setExp(0);

		// Stub dependency
		SpeakerRepository stub = new SpeakerRepository() {
			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return new Integer(100);
			}
		};

		// Act
		Integer speakerId = registerBusiness.register(stub, newSpeaker);
		// Assert
		assertNotNull(speakerId);
		assertEquals(100, speakerId);
		assertEquals(500, newSpeaker.getRegistrationFee());

	}
	@Test
	public void register_exp_between_2to3() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@gmail.com");
		newSpeaker.setExp(2);
		
		
		// Stub dependency
		SpeakerRepository stub = new SpeakerRepository() {
			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return new Integer(100);
			}
		};

		// Act
		Integer speakerId = registerBusiness.register(stub, newSpeaker);
		// Assert
		assertNotNull(speakerId);
		assertEquals(100, speakerId);
		assertEquals(250, newSpeaker.getRegistrationFee());

	}
	
	@Test
	public void register_exp_between_4to5() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@gmail.com");
		newSpeaker.setExp(4);
		
		
		// Stub dependency
		SpeakerRepository stub = new SpeakerRepository() {
			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return new Integer(100);
			}
		};

		// Act
		Integer speakerId = registerBusiness.register(stub, newSpeaker);
		// Assert
		assertNotNull(speakerId);
		assertEquals(100, speakerId);
		assertEquals(100, newSpeaker.getRegistrationFee());

	}
	@Test
	public void register_exp_between_6to9() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@gmail.com");
		newSpeaker.setExp(9);
		
		
		// Stub dependency
		SpeakerRepository stub = new SpeakerRepository() {
			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return new Integer(100);
			}
		};

		// Act
		Integer speakerId = registerBusiness.register(stub, newSpeaker);
		// Assert
		assertNotNull(speakerId);
		assertEquals(100, speakerId);
		assertEquals(50, newSpeaker.getRegistrationFee());

	}
	@Test
	public void register_exp_more_than_91() {
		// Arrange
		RegisterBusiness registerBusiness = new RegisterBusiness();
		Speaker newSpeaker = new Speaker();
		newSpeaker.setFirstName("Demo");
		newSpeaker.setLastName("Demo last");
		newSpeaker.setEmail("demo@gmail.com");
		newSpeaker.setExp(10);
		
		
		// Stub dependency
		SpeakerRepository stub = new SpeakerRepository() {
			@Override
			public Integer saveSpeaker(Speaker speaker) {
				return new Integer(100);
			}
		};

		// Act
		Integer speakerId = registerBusiness.register(stub, newSpeaker);
		// Assert
		assertNotNull(speakerId);
		assertEquals(100, speakerId);
		assertEquals(0, newSpeaker.getRegistrationFee());

	}
	
	@ParameterizedTest
	@CsvSource({"1,500", "2,250", "3,250","4,100","9,50","10,0"})
	public void testgetfee(int exp,int fee) {
		RegisterBusiness registerBusiness = new RegisterBusiness();
		assertEquals(fee,registerBusiness.getfee(exp));
		
	}

}