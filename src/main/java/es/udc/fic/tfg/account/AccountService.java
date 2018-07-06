package es.udc.fic.tfg.account;

import es.udc.fic.tfg.horse.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    protected void initialize() {
       // save(new Account("user@udc.es", "User", "User", "demo", "ROLE_USER", "666666666",horses));
        //save(new Account("admin@udc.es", "Admin", "Admin", "admin", "ROLE_ADMIN", "617617617",horses2));
    }

    @Transactional
    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findOneByEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return createUser(account);
    }

    public void signin(Account account) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(account));
    }

    private Authentication authenticate(Account account) {
        return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));
    }

    private User createUser(Account account) {
        return new User(account.getEmail(), account.getPassword(), Collections.singleton(createAuthority(account)));
    }

    private GrantedAuthority createAuthority(Account account) {
        return new SimpleGrantedAuthority(account.getRole());
    }

    public Account findByEmail(String email) {
        Account account = accountRepository.findOneByEmail(email);
        return account;
    }

    @Transactional
    public void update(Account account, String email){
        Account local = accountRepository.findOneByEmail(email);
        local.setEmail(account.getEmail());
        local.setFirstname(account.getFirstname());
        local.setLastname(account.getLastname());
        local.setPassword(account.getPassword());
        local.setPhonenumber(account.getPhonenumber());
        local.setRole(account.getRole());
        local.setHorsesOwned(account.getHorsesOwned());
        local.setHorsesRidden(account.getHorsesRidden());
        accountRepository.save(local);
    }

    @Transactional
    public Account addHorseToAccount(Account account, Horse horse) {
        List<Horse> horsesRidden = account.getHorsesRidden();
        horsesRidden.add(horse);
        account.setHorsesRidden(horsesRidden);
        accountRepository.save(account);
        return account;
    }

}