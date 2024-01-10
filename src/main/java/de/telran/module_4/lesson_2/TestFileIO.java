package de.telran.module_4.lesson_2;

import java.io.*;

public class TestFileIO {
    public static void main(String[] args) throws IOException {

        File testFile = new File("testFile.txt");
        if(!testFile.exists())
            testFile.createNewFile();

        // запись в файл
        FileOutputStream streamOut = new FileOutputStream(testFile);
        streamOut.write("This is my first experience when I myself work with IO API. \nI can do everything!".getBytes());
        streamOut.close();

        //чтение из файла reader
        FileInputStream streamIn = new FileInputStream(testFile);
        Reader reader = new InputStreamReader(streamIn);
        StringBuilder inStr = new StringBuilder();
        int data = reader.read();
        while (data != -1) {
            inStr.append((char) data);
//            System.out.print((char) data);
            data = reader.read();
        }
        reader.close();
        streamIn.close();
        System.out.println(inStr);

        //чтение из файла
        inStr.delete(0, inStr.length());
        InputStream streamInI = new FileInputStream(testFile);
        data = streamInI.read();
        while (data != -1) {
            inStr.append((char) data);
//            System.out.print((char) data);
            data = streamInI.read();
        }
        streamInI.close();
        System.out.println(inStr);

        //чтение файла с помощью буфера построчно
        InputStream streamInBuf = new FileInputStream(testFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(streamInBuf));
        String strIn = bufferedReader.readLine();
        while (strIn != null) {
            System.out.println(strIn);
            strIn = bufferedReader.readLine();
        }

    }
}
