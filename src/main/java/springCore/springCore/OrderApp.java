package springCore.springCore;

import springCore.springCore.member.Grade;
import springCore.springCore.member.Member;
import springCore.springCore.member.MemberService;
import springCore.springCore.member.MemberServiceImpl;
import springCore.springCore.order.Order;
import springCore.springCore.order.OrderService;
import springCore.springCore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.caclculatePrice());
    }
}
