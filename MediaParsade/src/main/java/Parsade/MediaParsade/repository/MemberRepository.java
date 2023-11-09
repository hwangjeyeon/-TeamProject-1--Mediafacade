package Parsade.MediaParsade.repository;

import Parsade.MediaParsade.domain.Member;
import Parsade.MediaParsade.domain.ReturnMember;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    ReturnMember save(ReturnMember member);


    List<ReturnMember> findAll();




}
