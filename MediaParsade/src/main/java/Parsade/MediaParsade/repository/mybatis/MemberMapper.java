package Parsade.MediaParsade.repository.mybatis;


import Parsade.MediaParsade.domain.ReturnMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void save(ReturnMember member);


    List<ReturnMember> findAll();

}
