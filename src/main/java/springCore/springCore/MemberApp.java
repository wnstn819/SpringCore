package springCore.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springCore.springCore.member.Grade;
import springCore.springCore.member.Member;
import springCore.springCore.member.MemberService;
import springCore.springCore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig  = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findM = memberService.findMember(1L);
        System.out.println("new Member : " + member.getName() );
        System.out.println("find Memeber : " + findM.getName());



    }
}
