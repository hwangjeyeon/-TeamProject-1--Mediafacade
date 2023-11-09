package Parsade.MediaParsade.service;

import Parsade.MediaParsade.domain.ReturnMember;
import Parsade.MediaParsade.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceV1 implements MemberService{


    private final MemberRepository memberRepository;

    @Override
    public ReturnMember save(ReturnMember member) {
        return memberRepository.save(member);
    }


    @Override
    public List<ReturnMember> findAll() {
        return memberRepository.findAll();
    }
}
