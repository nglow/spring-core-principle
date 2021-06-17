package study.springcoreprinciple.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.springcoreprinciple.member.Grade;
import study.springcoreprinciple.member.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // Given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // When
        int discount = discountPolicy.discount(member, 10000);

        // Then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용되지 않아야 한다.")
    void vip_x() {
        // Given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        // When
        int discount = discountPolicy.discount(member, 10000);

        // Then
        assertThat(discount).isEqualTo(0);
    }
}