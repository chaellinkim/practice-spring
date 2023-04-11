package practice.practicespring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice.practicespring.domain.Member;
import practice.practicespring.service.MemberService;

@Controller //컴포넌트 스캔 방식
public class MemberController {
    //@Autowired private final MemberService memberService; di - 필드주입

    private final MemberService memberService;
    /*
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    } //di - setter주입
    */
    @Autowired //스프링 컨테이너에서 가져옴, 연결시켜줌, 의존관계 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    } //di - 생성자 주입 best

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
