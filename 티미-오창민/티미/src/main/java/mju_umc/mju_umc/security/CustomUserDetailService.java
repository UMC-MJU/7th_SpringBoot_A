package mju_umc.mju_umc.security;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService  implements UserDetailsService {
    private final MemberRepository memberRepository;

    //DB에서 이메일로 조회하는 거니까 Transaction 필요하지 않다. (DB에 변경을 주지 않음)
    //email은 name 이자 로그인 id 이다.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다. : " + email
                ));

        return User.withUsername(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().name())
                .build();

    }
}
