package springCore.springCore;

import springCore.springCore.member.Grade;
import springCore.springCore.member.Member;
import springCore.springCore.member.MemberService;
import springCore.springCore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findM = memberService.findMember(1L);
        System.out.println("new Member : " + member.getName() );
        System.out.println("find Memeber : " + findM.getName());
    }
}
