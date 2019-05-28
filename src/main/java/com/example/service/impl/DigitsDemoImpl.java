package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service.IDigitsDemo;

/**
 * @author Sandy
 * @date 2019-05-27
 */
@Service("digitsDemo")
public class DigitsDemoImpl implements IDigitsDemo {

	/*
	 * letterCombinations:convert the digits from 0 to 9 into letters
	 * @see com.example.service.IDigitsDemo#letterCombinations(int[])
	 */
	@Override
	public List<String> letterCombinations(int[] digits) {
		// 0 to 9 into letter,0 and 1 do not map to any letters
		char[][] letters = new char[][] { {}, {}, { 'a', 'b', 'c' },
				{ 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
				{ 'w', 'x', 'y', 'z' } };

		List<String> letterList = new ArrayList<String>();
		for (int i = 0; i < digits.length; i++) {
			GetLetters(letterList, digits[i], letters);
		}
		return letterList;
	}
	

	/*
	 * letterCombinationsStageTwo:converting the digits from 0 to 99 into letters
	 * @see com.example.service.IDigitsDemo#letterCombinationsStageTwo(int[])
	 */
	@Override
	public List<String> letterCombinationsStageTwo(int[] digits){
		List<String> letterList = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < digits.length; i++) {
			int intArray[] = null;
			if(digits[i] > 9){
				String str = String.valueOf(digits[i]);
				intArray = new int[str.length()];
				for (int j = 0; j < str.length(); j++) {
					intArray[j] = Integer.parseInt(String.valueOf(str.charAt(i)));
				}
			}else{
				intArray = new int[1];
				intArray[0] = digits[i];
			}
			list = letterCombinations(intArray);
			GetLetters(letterList, list);
		}
		return letterList;
	}
	
	
	private void GetLetters(List<String> letterList, int index,
			char[][] lettersArr) {
		List<String> letters = new ArrayList<String>();
		for (int i = 0; i < lettersArr[index].length; i++) {
			letters.add(String.valueOf(lettersArr[index][i]));
		}
		GetLetters(letterList,letters);
	}
	
	
	private void GetLetters(List<String> letterList, List<String> list) {
		List<String> temp = new ArrayList<String>(letterList);
		letterList.clear();
		if (temp.size() == 0) {
			for (int i = 0; i < list.size(); i++) {
				letterList.add(list.get(i));
			}
		} else {
			for (int i = 0; i < temp.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					letterList.add(temp.get(i) + list.get(j));
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] digits = { 2, 3 };
		System.out.print("Output:");
		DigitsDemoImpl demo = new DigitsDemoImpl();
		List<String> list = demo.letterCombinations(digits);
		for (String al : list) {
			System.out.print(al + " ");
		}
	}
}
