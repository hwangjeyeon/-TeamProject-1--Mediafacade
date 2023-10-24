package Parsade.MediaParsade;


import Parsade.MediaParsade.login.LoginForm;
import Parsade.MediaParsade.member.Member;
import Parsade.MediaParsade.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    MemberRepository memberRepository;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("") LoginForm form){
        return "";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setStudentId(form.getStudentId());
        memberRepository.save(member);

        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main(){
        return "";
    }

    @GetMapping("/common")
    public String common(){
        return "";
    }

    @GetMapping("/dev")
    public String dev(){
        return "";
    }

    @GetMapping("/guest")
    public String guest(){
        return "";
    }


}
