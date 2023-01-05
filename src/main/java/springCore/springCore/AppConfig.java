package springCore.springCore;

import springCore.springCore.discount.FixDiscountPolicy;
import springCore.springCore.discount.RateDiscountPolicy;
import springCore.springCore.member.MemberService;
import springCore.springCore.member.MemberServiceImpl;
import springCore.springCore.member.MemoryMemberRepository;
import springCore.springCore.order.OrderService;
import springCore.springCore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){ //생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }


}
