package com.crashtech.trendspisrv;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrendspiSrvApplicationTests {

	private Calculator c = new Calculator();
	
	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void TestdoAdd() {
		
		//expectedResult
		int expectedResult = 5;
		
		//actualResult
		int actualResult = c.doAdd(2, 3);
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}
	
	@Test
	void TestdoMul() {
		
		//expectedResult
		int expectedResult = 6;
		
		//actualResult 
		int actualResult = c.doMul(2, 3);
		
		assertThat(actualResult).isEqualTo(expectedResult);
		
	}
	
	@Test
	void TestcompareTwoNums() {
		
		//actualResult
		Boolean actualResult = c.compareTwoNums(3, 3);
		assertThat(actualResult).isTrue();
	}
	
}
