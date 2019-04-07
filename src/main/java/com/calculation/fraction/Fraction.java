package com.calculation.fraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fraction {
    public String calculateFraction(String strInput){
        int arrNum[] = new int[4];
        Calculator calc = new Calculator();
        String regex = "\\(?(\\(?-?\\d+\\/-?\\d+|-?\\d+)\\)?([+\\-*\\/])(\\(?-?\\d+\\/-?\\d+|-?\\d+)\\)?\\)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strInput);
        while (matcher.find()) {
            String strstatement =  strInput.substring(matcher.start(), matcher.end());
            char mathSymbol = matcher.group(2).charAt(0);
            if(mathSymbol=='/') {
                Pattern p = Pattern.compile("\\(?(\\(-?\\d+\\/-?\\d+\\)[\\/]\\(-?\\d+\\/-?\\d+\\)|-?\\d+[\\/]\\(?-?\\d+\\/-?\\d+\\)?|\\(-?\\d+\\/-?\\d+\\)[\\/]-?\\d+)\\)?");
                Matcher m = p.matcher(strstatement);
                if(!m.find()) continue;
            }

            int i=0;
            for(int j=1; j<=3; j=j+2) {
                String operand = matcher.group(j);
                String regexNum = "-?\\d+";
                Pattern patternNum = Pattern.compile(regexNum);
                Matcher matcherNum = patternNum.matcher(operand);

                while (matcherNum.find()) {
                    arrNum[i] = Integer.parseInt(operand.substring(matcherNum.start(), matcherNum.end()));
                    i++;
                }
                if (i % 2 == 1) {
                    arrNum[i] = 1;
                    i++;
                }
            }

            int [] arrAfterOperation = new int[2];
            switch(mathSymbol){
                case '+': arrAfterOperation = calc.add(arrNum); break;
                case '-': arrAfterOperation = calc.subtract(arrNum); break;
                case '*': arrAfterOperation = calc.multiply(arrNum); break;
                case '/': arrAfterOperation = calc.divide(arrNum); break;
            }

            String str1;
            switch(arrAfterOperation[1]){
                case 1:
                    str1 = Integer.toString(arrAfterOperation[0]);
                    break;
                default:
                    str1 = arrAfterOperation[0]+"/"+arrAfterOperation[1];
                    break;
            }

            strInput = strInput.replace(strstatement, str1);
            matcher = pattern.matcher(strInput);


        }
        return strInput;
    }

}

