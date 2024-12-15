package mju_umc.mju_umc.web.viewController;

import lombok.RequiredArgsConstructor;
import mju_umc.mju_umc.service.MemberCommandService;
import mju_umc.mju_umc.web.dto.member.MemberRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberCommandService memberCommandService;

    //회원가입 요청 실행 post 메소드
    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            //만약 데이터 바인딩이 실패하면, signup으로 반환
            return "signup";
        }
        try {
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e) {
            //회원 가입 중 에러가 발생하면, 메세지와 함가ㅖ signup 페이지로 보낸다.

            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }

    //회원가입 페이지 방문 요청이 들어오면
    @GetMapping("/signup")
    public String signupPage(Model model) {
        //requestDto를 model에 담아서 전달
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        //타임리프에서는 model에 담긴 dto에 회원가입 정보를 담아 다시 post 요청을 보낼 것이다.
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
