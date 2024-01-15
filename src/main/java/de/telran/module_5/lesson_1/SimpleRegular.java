package de.telran.module_5.lesson_1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SimpleRegular {
    public static void main(String[] args) {
        String regex = ".*www.*";
        String actualString = "www.telran.detel";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(actualString);
        boolean matches = matcher.matches();
        System.out.println(matches);

        System.out.println(Pattern.matches(regex, actualString));


        Pattern pattern2 = Pattern.compile("tel");
        Matcher matcher2 = pattern2.matcher(actualString);
        while (matcher2.find()) {
            System.out.println("Паттерн срабатывает с - "+matcher2.start()+" по - "+matcher2.end());
        }

        // PatternSyntaxException
//        String regexError = "([a-z)";
//        Pattern patternError = Pattern.compile(regexError);

        // Без учета регистра (работает на латинице)
        System.out.println();
        Pattern patternInsens = Pattern.compile("t", Pattern.CASE_INSENSITIVE);
        Matcher matcherInsens = patternInsens.matcher("To be or not to be");
        while (matcherInsens.find()) {
            System.out.println("Паттерн срабатывает с - "+matcherInsens.start()+" по - "+matcherInsens.end());
        }

        // split
        String text = "I1learned2about3Telran4College5and6now7I'm8studying9Java";
        String delimeter = "\\d";
        Pattern patternSplit = Pattern.compile(delimeter);
        String[] arrStr = patternSplit.split(text);
        System.out.println(Arrays.toString(arrStr));

        // разбираем текст по словам
        text = "I learned about Telran College and now.I'm studying Java!";
        arrStr = text.split("[\\W&&[^']]");
        System.out.println(Arrays.toString(arrStr));

        //Патерн email из интернета
        //Pattern email_pattern = pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")

        System.out.println();
        // Ip адрес  123.34.255.0   (0...255)
        // 255.255.255.255
        String zeroTo255  = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String IPAdressRegex = zeroTo255+"\\."+zeroTo255+"\\."+zeroTo255+"\\."+zeroTo255;
        System.out.println(Pattern.matches(IPAdressRegex, "123.34.255.0"));

        // Жадный режим квантификатора
//        "А.+а" // жадный режим
//        "А.++а" // сверхжадный режим
//        "А.+?а" // ленивый режим
        System.out.println( " --- жадный режим");
        text = "Егор Алла Александр";
        pattern = Pattern.compile("А.+а");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }

        System.out.println( " --- сверхжадный режим");
        pattern = Pattern.compile("А.++а");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }

        System.out.println( " --- ленивый режим");
        pattern = Pattern.compile("А.+?а");
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }


    }
}
