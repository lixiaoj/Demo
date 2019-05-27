package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service.IDigitsDemo;

@Service("digitsDemo")
public class DigitsDemoImpl implements IDigitsDemo {

	// letterCombinations
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

	public void GetLetters(List<String> letterList, int index,
			char[][] lettersArr) {
		List<String> letters = new ArrayList<String>();
		List<String> temp = new ArrayList<String>(letterList);
		letterList.clear();
		for (int i = 0; i < lettersArr[index].length; i++) {
			letters.add(String.valueOf(lettersArr[index][i]));
		}
		if (temp.size() == 0) {
			for (int i = 0; i < letters.size(); i++) {
				letterList.add(letters.get(i));
			}
		} else {
			for (int i = 0; i < temp.size(); i++) {
				for (int j = 0; j < letters.size(); j++) {
					letterList.add(temp.get(i) + letters.get(j));
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
