package com.test;

import com.wp.practise.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wangpeng on 2017/8/14.
 */
public class FilesTest {

    public static void main(String[] args) throws IOException {

        List<User> users = new ArrayList<>();
        users.add(new User("1","1"));
        users.add(new User("2","2"));
        users.add(new User("3","3"));
        users.add(new User("4","4"));
        users.add(new User("5","5"));
        users.add(new User("6","6"));
        users.add(new User("7","7"));
        users.add(new User("8","8"));

        StringBuilder stringBuilder = new StringBuilder();

        users.stream()
                .forEach(u -> {
                    stringBuilder.append("userName-->" + u.getUserName())
                                 .append("password-->" + u.getPassword())
                            .append(System.getProperty("line.separator"));
                });
        writeTxtFile(stringBuilder.toString(), "d:\\test.csv");

    }

    public static boolean writeTxtFile (String newStr , String filenameTemp) throws IOException {
        // 先读取原有文件内容，然后进行写入操作
        boolean flag = false;
        // String filein = newStr + "\r\n";
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            // 文件路径
            File file = new File(filenameTemp);
            // 将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该文件原有的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf = buf.append(temp);
                // System.getProperty("line.separator")
                // 行与行之间的分隔符 相当于“\n”
                buf = buf.append(System.getProperty("line.separator"));
            }
            buf.append(newStr);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            flag = true;
        } catch (IOException e1) {
            throw e1;
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return flag;
    }

}
