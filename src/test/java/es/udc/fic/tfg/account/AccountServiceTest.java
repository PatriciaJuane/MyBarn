package es.udc.fic.tfg.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import es.udc.fic.tfg.activity.Activity;
import es.udc.fic.tfg.horse.Horse;
import es.udc.fic.tfg.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(MockitoJUnitRunner.class)
@Transactional
public class AccountServiceTest {

	@Autowired
	private AccountService accountService = new AccountService();

	@Autowired
	private AccountRepository accountRepositoryMock;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*@Rule
	public ExpectedException thrown = ExpectedException.none();*/

	/*
	 * @Test public void shouldInitializeWithTwoDemoUsers() { // act
	 * accountService.initialize(); // assert verify(accountRepositoryMock,
	 * times(2)).save(any(Account.class)); }
	 */

	/*
	 * @Test public void shouldThrowExceptionWhenUserNotFound() { // arrange
	 * thrown.expect(UsernameNotFoundException.class);
	 * thrown.expectMessage("user not found");
	 * 
	 * when(accountRepositoryMock.findOneByEmail("user@example.com")).thenReturn(
	 * null); // act accountService.loadUserByUsername("user@example.com"); }
	 */

	/*
	 * @Test public void shouldReturnUserDetails() { // arrange Account demoUser =
	 * new Account("user@example.com", "demo", "ROLE_USER");
	 * when(accountRepositoryMock.findOneByEmail("user@example.com")).thenReturn(
	 * demoUser);
	 * 
	 * // act UserDetails userDetails =
	 * accountService.loadUserByUsername("user@example.com");
	 * 
	 * // assert
	 * assertThat(demoUser.getEmail()).isEqualTo(userDetails.getUsername());
	 * assertThat(demoUser.getPassword()).isEqualTo(userDetails.getPassword());
	 * assertThat(hasAuthority(userDetails, demoUser.getRole())).isTrue(); }
	 */
	/*
	 * private boolean hasAuthority(UserDetails userDetails, String role) { return
	 * userDetails.getAuthorities().stream() .map(GrantedAuthority::getAuthority)
	 * .anyMatch(isEqual(role)); }
	 */

	@Test
	public void testfindByEmail() {
		List<Horse> h = new ArrayList();
		List<Activity> a = new ArrayList();
		List<Training> t = new ArrayList();
		Account demoUser = new Account("user@example.com", "user", "apellido", "demo", "ROLE_USER", "123",
				true, h, h, " ", a, t);

		System.out.println("\n\n\n HOLAAAAAA \n"+accountService.save(demoUser));

		Account ac = accountService.findByEmail("user@example.com");
		System.out.println("\n\n\n HOLAAAAAA \n"+ac.getEmail());
		assertThat(demoUser.getEmail().equals(ac.getEmail()));

	}

}
