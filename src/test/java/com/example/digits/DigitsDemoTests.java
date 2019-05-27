package com.example.digits;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.DemoApplication;
import com.example.service.IDigitsDemo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class DigitsDemoTests {
	
	@Autowired	
    private IDigitsDemo digitsDemo;
	
	@Test
	public void test() {
		int[] digits = {2,3};
		System.out.print("Output:");
		List<String> list = digitsDemo.letterCombinations(digits);
		for (String al : list) {
			System.out.print(al+" ");
		}
	}

	@Test
	public void testLetterCombinations() {
		int[] digits = {9};
		System.out.print("Output:");
		List<String> list = digitsDemo.letterCombinations(digits);
		for (String al : list) {
			System.out.print(al+" ");
		}
	}
	

	@Test
	public void testMuti() {
		int[] digits = {2,3,4};
		System.out.print("Output:");
		List<String> list = digitsDemo.letterCombinations(digits);
		for (String al : list) {
			System.out.print(al+" ");
		}
	}
	
	
	@Test
	public void testOneToNi() {
		int[] digits = {2,99};
		System.out.print("Output:");
		List<String> list = digitsDemo.letterCombinations(digits);
		for (String al : list) {
			System.out.print(al+" ");
		}
	}
    @Before
    public void testBefore(){
        //System.out.println("before");
    }

    @After
    public void testAfter(){
        //System.out.println("after");
    }

}
