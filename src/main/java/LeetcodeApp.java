import entity.QuestionAccept;
import lt.LeetcodeUtil;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: Xiaohei
 * @CreateTime: 2022/7/21 23:34
 */
public class LeetcodeApp {

    public static void main(String[] args) {
        System.out.println("--------Leetcode-more----------");
        System.out.println("starting");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户数据文件名,并确保文件与该软件处于同一目录：");
        String file = sc.nextLine();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            List<String> userIds = reader.lines().collect(Collectors.toList());
            List<QuestionAccept> list = LeetcodeUtil.getData(userIds);
            System.out.println("请输入数据结果文件名:");
            String outFileName = sc.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
            writer.write("用户名, 简单, 中等, 困难, 总解题数\n");
            for (QuestionAccept data : list) {
                String line = data.getUserId() + "," +  data.getEasy() + ", " + data.getMid() + ", " + data.getHard() + ", " + data.getTotal() + ", " + "\n";
                writer.write(line);
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");

        } catch (IOException e) {
            System.out.println("写入数据失败");
        } finally {
            System.out.println("exit");
            System.exit(0);
        }

    }
}
