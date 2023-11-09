package Parsade.MediaParsade.service;

import Parsade.MediaParsade.domain.ReturnMember;

import java.util.List;

public interface MemberService {

    ReturnMember save(ReturnMember member);

    List<ReturnMember> findAll();

}
