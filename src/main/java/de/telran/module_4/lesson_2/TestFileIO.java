package de.telran.module_4.lesson_2;

import java.io.*;

public class TestFileIO {
    public static void main(String[] args)  {

        File testFile = new File("testFile.txt");
        if(!testFile.exists()) {
            try {
                testFile.createNewFile();
                // запись в файл
                FileOutputStream streamOut = null;
                streamOut = new FileOutputStream(testFile);
                streamOut.write("This is my first experience when I myself work with IO API. \nI can do everything!".getBytes());
                streamOut.close();

                //чтение из файла reader
                FileInputStream streamIn = null;
                try {
                    streamIn = new FileInputStream(testFile);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
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
            } catch (FileNotFoundException | NullPointerException e) {
                System.out.println("Произошло исключение - " + e.getLocalizedMessage());
            } catch (IOException e) {
                System.out.println("Произошло исключение - " + e.getLocalizedMessage());
            }
            catch (Exception e) {
                System.out.println("Произошло исключение - " + e.getLocalizedMessage());
            }
            finally {
                System.out.println("Логика, которая отрабатывает всегда!!!");
            }

        }
    }
}
