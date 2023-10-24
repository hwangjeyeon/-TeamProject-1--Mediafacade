package Parsade.MediaParsade.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    private MemberRepository memberRepository;

    @BeforeEach
    public void setUp() {
        memberRepository = new MemberRepository(); // MemberRepository를 적절히 생성하거나 주입하세요.
    }

    @Test
    public void testMemberRepository(){
        Member member = new Member();
        member.setName("hwang");
        member.setStudentId("20191511");
        memberRepository.save(member);
        List<Member> result = memberRepository.findAll();
        System.out.println(result);

        Assertions.assertThat(result).contains(member);
    }

}