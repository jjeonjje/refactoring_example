package me.jjh.refactoring.chapter06.InlineTemp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 임시변수 내용 직접 삽입
 * 
 * - 간단한 수식을 대입받는 임시변수로 인해 다른 리팩토링 기법 적용이 힘들 땐
 * 그 임시변수를 참조하는 부분을 전부 수식으로 치환하자
 * 
 * @author jjh
 *
 */
public class InlineTemp {

	class Order {
		
		private double basePrice = 1000;

		public double getBasePrice() {
			return basePrice;
		}
	}
	
	Order order = new Order();
	
	/**
	 * 리팩토링 전
	 * @return
	 */
	public boolean priceCheck() {
		double basePrice = order.getBasePrice();
		return (basePrice > 1000);
	}
	
	/**
	 * 리팩토링 후
	 * - 임시변수 basePrice 삭제
	 * @return
	 */
	public boolean priceCheck_refactoring() {
		return (order.getBasePrice() > 1000);
	}	

	@Test
	public void 임시변수_내용_직접_삽입() {
		InlineTemp inlineTemp = new InlineTemp();
		
		boolean check = inlineTemp.priceCheck();
		boolean check_re = inlineTemp.priceCheck_refactoring();
		
		assertThat(check, is(check_re));
	}
	
}
