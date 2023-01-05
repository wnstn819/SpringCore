package springCore.springCore.member.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springCore.springCore.member.Grade;
import springCore.springCore.member.Member;
import springCore.springCore.member.MemberService;
import springCore.springCore.member.MemberServiceImpl;
import springCore.springCore.order.Order;
import springCore.springCore.order.OrderService;
import springCore.springCore.order.OrderServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
