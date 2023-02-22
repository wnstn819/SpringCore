package springCore.springCore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springCore.springCore.discount.DiscountPolicy;
import springCore.springCore.discount.FixDiscountPolicy;
import springCore.springCore.discount.RateDiscountPolicy;
import springCore.springCore.member.MemberRepository;
import springCore.springCore.member.MemberService;
import springCore.springCore.member.MemberServiceImpl;
import springCore.springCore.member.MemoryMemberRepository;
import springCore.springCore.order.OrderService;
import springCore.springCore.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    //appconfig는 역할이 보이게 만드는 것이 중요함
    public MemberService memberService(){ //생성자 주입
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
 //Bean - SpringContainer에 등록

}
