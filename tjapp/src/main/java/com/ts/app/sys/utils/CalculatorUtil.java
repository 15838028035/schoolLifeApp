package com.ts.app.sys.utils;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

import com.ts.app.sys.exception.CustomException;

public class CalculatorUtil {

	final static int MAXLEN = 500;
	final static double PI = 3.141592657;

	/*
	 * 计算表达式 从左向右扫描，数字入number栈，运算符入operator栈 +-基本优先级为1， ×÷基本优先级为2， √^基本优先级为4
	 * 括号内层运算符比外层同级运算符优先级高4 当前运算符优先级高于栈顶压栈， 低于栈顶弹出一个运算符与两个数进行运算 重复直到当前运算符大于栈顶
	 * 扫描完后对剩下的运算符与数字依次计算
	 */
	public static String process(String str) throws CustomException {
		int weightPlus = 0, topOp = 0, topNum = 0, flag = 1, weightTemp = 0;
		// weightPlus为同一（）下的基本优先级，weightTemp临时记录优先级的变化
		// topOp为weight[]，operator[]的计数器；topNum为number[]的计数器
		// flag为正负数的计数器，1为正数，-1为负数
		int weight[]; // 保存operator栈中运算符的优先级，以topOp计数
		double number[]; // 保存数字，以topNum计数
		char ch, ch_gai, operator[];// operator[]保存运算符，以topOp计数
		String num;// 记录数字，str以+-*/() ! ^分段，+-*/() ^字符之间的字符串即为数字
		weight = new int[MAXLEN];
		number = new double[MAXLEN];
		operator = new char[MAXLEN];
		String expression = str.replace("π", String.valueOf(PI));// 将字符串中的π用PI
		// 建议用split代替字符串分割
		StringTokenizer expToken = new StringTokenizer(expression, "+-*/()^");
		int i = 0;
		while (i < expression.length()) {
			ch = expression.charAt(i);
			// 判断正负数
			if (i == 0) {
				if (ch == '-')
					flag = -1;
			} else if (expression.charAt(i - 1) == '(' && ch == '-')
				flag = -1;
			// 取得数字，并将正负符号转移给数字,E是科学计数
			if (ch <= '9' && ch >= '0' || ch == '.' || ch == 'E') {
				num = expToken.nextToken();// 分割后的StringTokenizer中的下一个索引数据
				ch_gai = ch;
				// 取得整个数字
				while (i < expression.length()
						&& (ch_gai <= '9' && ch_gai >= '0' || ch_gai == '.' || ch_gai == 'E')) {
					ch_gai = expression.charAt(i++);
				}
				// 将指针退回之前的位置，即每个数字的末尾位置
				if (i >= expression.length())
					i -= 1;
				else {
					i -= 2;
				}
				if (num.compareTo(".") == 0)
					number[topNum++] = 0;
				// 将正负符号转移给数字
				else {
					number[topNum++] = Double.parseDouble(num) * flag;
					flag = 1;
				}
			}
			// 计算运算符的优先级
			if (ch == '(')
				weightPlus += 4;
			if (ch == ')')
				weightPlus -= 4;
			if (ch == '-' && flag == 1 || ch == '+' || ch == '*' || ch == '/'
					|| ch == '^') {

				switch (ch) {
				// +-的优先级最低，为1
				case '+':
				case '-':
					weightTemp = 1 + weightPlus;
					break;
				// x/的优先级稍高，为2
				case '*':
				case '/':
					weightTemp = 2 + weightPlus;
					break;
				default:
					weightTemp = 4 + weightPlus;
					break;
				}
				// 如果当前优先级大于堆栈顶部元素，则直接入栈
				if (topOp == 0 || weight[topOp - 1] < weightTemp) {
					weight[topOp] = weightTemp;
					operator[topOp] = ch;
					topOp++;
					// 否则将堆栈中运算符逐个取出，直到当前堆栈顶部运算符的优先级小于当前运算符
				} else {
					while (topOp > 0 && weight[topOp - 1] >= weightTemp) {
						switch (operator[topOp - 1]) {
						// 取出数字数组的相应元素进行运算
						case '+':
							number[topNum - 2] += number[topNum - 1];
							break;
						case '-':
							number[topNum - 2] -= number[topNum - 1];
							break;
						case '*':
							number[topNum - 2] *= number[topNum - 1];
							break;
						// 判断除数为0的情况
						case '/':
							if (number[topNum - 1] == 0) {
								// showError(1, str_old);
								throw new CustomException("除数不能为0");
							}
							number[topNum - 2] /= number[topNum - 1];
							break;

						case '^':
							number[topNum - 2] = Math.pow(number[topNum - 2],
									number[topNum - 1]);
							break;
						// 计算时进行角度弧度的判断及转换
						}
						// 继续取堆栈的下一个元素进行判断
						topNum--;
						topOp--;
					}
					// 将运算符入堆栈
					weight[topOp] = weightTemp;
					operator[topOp] = ch;
					topOp++;
				}
			}
			i++;
		}
		// 依次取出堆栈的运算符进行运算
		while (topOp > 0) {
			// +-x直接将数组的后两位数取出运算
			switch (operator[topOp - 1]) {
			case '+':
				number[topNum - 2] += number[topNum - 1];
				break;
			case '-':
				number[topNum - 2] -= number[topNum - 1];
				break;
			case '*':
				number[topNum - 2] *= number[topNum - 1];
				break;
			// 涉及到除法时要考虑除数不能为零的情况
			case '/':
				if (number[topNum - 1] == 0) {
					// showError(1, str_old);
					throw new CustomException("除数不能为0");
				}
				number[topNum - 2] /= number[topNum - 1];
				break;

			case '^':
				number[topNum - 2] = Math.pow(number[topNum - 2],
						number[topNum - 1]);
				break;

			}
			// 取堆栈下一个元素计算
			topNum--;
			topOp--;
		}
		// 如果是数字太大，提示错误信息
		if (number[0] > 7.3E306) {
			// showError(3, str_old);
			throw new CustomException("除数过大");
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		// 输出最终结果
		return String.valueOf(df.format(number[0]));
	}

	public static boolean isNumber(String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) throws CustomException {
		
		 String a = "44.00*0.6*0.6-1239.00-55";
		 System.out.println(process(a));
		 
	}
}
