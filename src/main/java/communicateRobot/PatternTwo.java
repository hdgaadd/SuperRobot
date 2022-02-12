package communicateRobot;

import utils.ExcelData;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/**
 * @authod Mr Chen
 */
public class PatternTwo {
    public void reviewWord() throws IOException {
        System.out.println("请输入您要复习的单词个数");

        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();

        ExcelData sheet1 = new ExcelData(courseFile + "\\src\\main\\java\\res\\englishWord.xlsx", "Sheet1");
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        Random random=new Random();
        for (int i = 0; ; ) {
            int index=random.nextInt(3000);
            System.out.println(sheet1.getExcelDateByIndex(index, 0));//输出第一列
            //奇怪
            if(i==0){
                sc.nextLine();
            }//奇怪
            sc.nextLine();//读取回车符
            System.out.println(sheet1.getExcelDateByIndex(index, 1));//第二列
            i++;
            if(i==count){
                System.out.println("主人复习完毕了嘻嘻！");
                break;
            }
            sc.nextLine();
        }
    }

}
