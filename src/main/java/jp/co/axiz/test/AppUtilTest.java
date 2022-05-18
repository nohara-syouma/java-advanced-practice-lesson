package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.util.AppUtil;

class AppUtilTest {

	@Test
	void test1() {
		boolean result = AppUtil.isGameApp(new CardGameApp());
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	void test2() {
		boolean result = AppUtil.isGameApp(new DartsGameApp());
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	void test3() {
		boolean result = AppUtil.isGameApp(new ClockApp());
		boolean expected = false;
		assertEquals(expected, result);
	}
	@Test
	void test4() {
		boolean result = AppUtil.isCardGameApp(new CardGameApp());
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	void test5() {
		boolean result = AppUtil.isCardGameApp(new DartsGameApp());
		boolean expected = false;
		assertEquals(expected, result);
	}
	@Test
	void test6() {
		boolean result = AppUtil.isCardGameApp(new ClockApp());
		boolean expected = false;
		assertEquals(expected, result);
	}
	@Test
	void test7() {
		boolean result = AppUtil.isDartsGameApp(new CardGameApp());
		boolean expected = false;
		assertEquals(expected, result);
	}
	@Test
	void test8() {
		boolean result = AppUtil.isDartsGameApp(new DartsGameApp());
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	void test9() {
		boolean result = AppUtil.isDartsGameApp(new ClockApp());
		boolean expected = false;
		assertEquals(expected, result);
	}
	@Test
	void test10() {
		boolean result = AppUtil.isClockApp(new CardGameApp());
		boolean expected = false;
		assertEquals(expected, result);
	}
	@Test
	void test11() {
		boolean result = AppUtil.isClockApp(new DartsGameApp());
		boolean expected = false;
		assertEquals(expected, result);
	}
	@Test
	void test12() {
		boolean result = AppUtil.isClockApp(new ClockApp());
		boolean expected = true;
		assertEquals(expected, result);
	}
	@Test
	void test13() {
		String result = AppUtil.getAppName(new CardGameApp());
		String expected = "ゲーム:カード";
		assertEquals(expected, result);
	}
	@Test
	void test14() {
		String result = AppUtil.getAppName(new DartsGameApp());
		String expected = "ゲーム:ダーツ";
		assertEquals(expected, result);
	}
	@Test
	void test15() {
		String result = AppUtil.getAppName(new ClockApp());
		String expected = "時計";
		assertEquals(expected, result);
	}

}
