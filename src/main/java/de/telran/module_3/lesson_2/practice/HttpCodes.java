package de.telran.module_3.lesson_2.practice;

import java.util.function.BiConsumer;

public enum HttpCodes {
    INFORMATIONAL(100,199,
            ((code, codes) -> System.out.println(code + " принадлежит INFORMATIONAL группе в перечислении HttpCodes."+codes))), //100-199
    SUCCESS(200,299,
            ((code, codes) -> System.out.println(code + " принадлежит SUCCESS группе в перечислении HttpCodes."+codes))), //200-299
    REDIRECTION(300,399,
            ((code, codes) -> System.out.println(code + " принадлежит REDIRECTION группе в перечислении HttpCodes."+codes))), //300-399
    CLIENT_ERROR(400,499,
            ((code, codes) -> System.out.println(code + " принадлежит CLIENT_ERROR группе в перечислении HttpCodes."+codes))), //400-499
    SERVER_ERROR(500,599,
            ((code, codes) -> System.out.println(code + " принадлежит SERVER_ERROR группе в перечислении HttpCodes."+codes))); //500-599

    int minCode;
    int maxCode;
//    Action valAction;
    BiConsumer<Integer, HttpCodes> valAction;

//
//    HttpCodes(int minCode, int maxCode, Action action) {
//        this.minCode = minCode;
//        this.maxCode = maxCode;
//        this.valAction = action;
//    }
    HttpCodes(int minCode, int maxCode,  BiConsumer<Integer, HttpCodes>  action) {
        this.minCode = minCode;
        this.maxCode = maxCode;
        this.valAction = action;
    }



    public static void findValueByCode(int code) {
        for (HttpCodes v: HttpCodes.values()) {
            if(code >=v.minCode && code<=v.maxCode) {
                v.valAction.accept(code, v);
//                v.doRunAction(code, v);
//                v.valAction.action(code, v);
                break;
            }
        }
    }

//    public void doRunAction(int code, HttpCodes v) {
//        if(valAction != null)
//            valAction.action(code, v);
//    }
}
