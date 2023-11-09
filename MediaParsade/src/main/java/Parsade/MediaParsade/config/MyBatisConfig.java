package Parsade.MediaParsade.config;


import Parsade.MediaParsade.repository.MemberRepository;
import Parsade.MediaParsade.repository.mybatis.MemberMapper;
import Parsade.MediaParsade.repository.mybatis.MyBatisMemberRepository;
import Parsade.MediaParsade.service.MemberService;
import Parsade.MediaParsade.service.MemberServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final MemberMapper memberMapper;

    @Bean
    public MemberService memberService(){
        return new MemberServiceV1(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MyBatisMemberRepository(memberMapper);
    }


}
