package Parsade.MediaParsade.domain;

import Parsade.MediaParsade.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    private MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void setUp() {
        memoryMemberRepository = new MemoryMemberRepository(); // MemberRepository를 적절히 생성하거나 주입하세요.
    }

    @Test
    public void testMemberRepository(){
        Member member = new Member();
        member.setName("hwang");
        member.setStudentId("20191511");
        memoryMemberRepository.save(member);
        List<Member> result = memoryMemberRepository.findAll();
        System.out.println(result);

        Assertions.assertThat(result).contains(member);
    }

}