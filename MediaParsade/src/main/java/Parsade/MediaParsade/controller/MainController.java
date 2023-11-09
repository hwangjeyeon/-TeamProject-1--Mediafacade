package Parsade.MediaParsade.controller;


import Parsade.MediaParsade.domain.Member;
import Parsade.MediaParsade.domain.ReturnMember;
import Parsade.MediaParsade.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final MemberService memberService;




    // 로그인 사용자 정보 반환:

    @ResponseBody
    @GetMapping("/api/guest")
    public List<ReturnMember> login(){
        log.info("요청받음");
        return memberService.findAll();
    }


    @PostMapping("/api/common")
    public String commons(@RequestBody Member member){
        String redirectUrl = "http://textmediafacade.site:3000/display";
        ReturnMember returnMember = new ReturnMember();
        returnMember.setName(member.getName());
        returnMember.setType(member.getType());
        returnMember.setStudentId(member.getStudentId());
        returnMember.setText(member.getText());
        returnMember.setSelection(member.getSelection());

        String encoded="";
        try {
            encoded = URLEncoder.encode(member.getText(), StandardCharsets.UTF_8.toString());
            System.out.println("Encoded URL: " + encoded);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        log.info("name={}, studentId={}",returnMember.getName(), returnMember.getStudentId());
        memberService.save(returnMember);
        redirectUrl += "?text=" + encoded +"&selection=" + member.getSelection();
        log.info("redirectUrl = {}",redirectUrl);
        return "redirect:" + redirectUrl;
    }


    // 함수 사용자 저장 정보
    // 세션정보를 통해서 기존 로그인 정보를 가져와서 해당 열에 데이터베이스 정보를 업데이트 한다.
    @PostMapping("/api/function")
    public String functions(@RequestBody Member member){

        String redirectUrl = "http://textmediafacade.site:3000/display";
        ReturnMember returnMember = new ReturnMember();
        returnMember.setName(member.getName());
        returnMember.setType(member.getType());
        returnMember.setStudentId(member.getStudentId());
        returnMember.setText(member.getText());
        returnMember.setProperty(member.getProperty().toString());
        String encoded="";
        try {
            encoded = URLEncoder.encode(member.getText(), StandardCharsets.UTF_8.toString());
            System.out.println("Encoded URL: " + encoded);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        log.info("name={}, studentId={}",returnMember.getName(), returnMember.getStudentId());
        memberService.save(returnMember);
        // "text" 매개변수 추가
        redirectUrl += "?text=" + encoded;

        // "color" 매개변수 추가
        if (member.getProperty() != null && member.getProperty().getColor() != null) {
            redirectUrl += "&color=" + member.getProperty().getColor();
        }

        // "fontSize" 매개변수 추가
        if (member.getProperty() != null && member.getProperty().getFontSize() != null) {
            redirectUrl += "&fontSize=" + member.getProperty().getFontSize();
        }

        // "style" 매개변수 추가
        if (member.getProperty() != null && member.getProperty().getStyle() != null) {
            redirectUrl += "&style=" + member.getProperty().getStyle();
        }

        // 로깅
        log.info("redirectUrl = {}", redirectUrl);

        // 리다이렉션
        return "redirect:" + redirectUrl;
    }


}
