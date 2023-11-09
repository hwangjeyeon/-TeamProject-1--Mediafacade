package Parsade.MediaParsade.repository;


import Parsade.MediaParsade.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MemoryMemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    public Member save(Member member){
        sequence++;
        member.setId(sequence);
        store.put(member.getId(), member);
        return member;
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
