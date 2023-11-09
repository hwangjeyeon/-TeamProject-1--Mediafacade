package Parsade.MediaParsade.repository.mybatis;

import Parsade.MediaParsade.domain.ReturnMember;
import Parsade.MediaParsade.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public ReturnMember save(ReturnMember member) {
        memberMapper.save(member);
        return member;
    }



    @Override
    public List<ReturnMember> findAll() {
        return memberMapper.findAll();
    }

}
