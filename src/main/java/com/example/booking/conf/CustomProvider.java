package com.example.booking.conf;


import com.example.booking.entity.User;
import com.example.booking.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
@Transactional
public class CustomProvider implements AuthenticationProvider {

    private static Logger logger = Logger.getLogger(CustomProvider.class.getName());

    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    IUserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String account = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        System.out.println(account);
        System.out.println(password);

        User user = null;
        Optional<User> userOptional = userRepository.findByAccount(account);

        if (account != "") {
            if (userOptional.isPresent()) {
                user = userOptional.get();
                if (!encoder.matches(password, user.getPassword())) {
                    throw new AuthenticationServiceException(String.format("please check account or password"));
                }
            } else {
                throw new BadCredentialsException("please check account or password");

            }
        }
//        String passwordAuth = "123456";
//        String encodePwd = encoder.encode(passwordAuth);
//        if(password == null || !encoder.matches(password,encodePwd)){
//            logger.info(String.format("user %s Not found ", password));
//            throw new AuthenticationServiceException(String.format("login fail account = %s ", password));
//        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        System.out.println("authenticate password：" + password);
        return new UsernamePasswordAuthenticationToken(account, password, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        System.out.println("supports");
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
