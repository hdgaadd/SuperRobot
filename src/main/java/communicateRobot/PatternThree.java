package communicateRobot;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * @authod Mr Chen
 */
public class PatternThree {
    private ArrayList<String> res = new ArrayList<String>();//把每段笔记存储在res
    public void record() throws IOException {
        System.out.println("请输入要回顾的笔记段数:");
        //创建复习资料的内存
        createTxt();
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        Random random=new Random();
        for (int i = 0; ; ) {
            int index=random.nextInt(res.size());
            System.out.println(res.get(index));//输出第一列
            //奇怪
            if(i==0){
                sc.nextLine();
            }//奇怪
            i++;
            if(i==count){
                System.out.println("主人复习完毕了嘻嘻！");
                break;
            }
            sc.nextLine();
        }
    }
    public void createTxt() throws IOException {
        StringBuilder sb = new StringBuilder();
        String temp = null;
        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\offer\\MyItem\\SuperRobot\\src\\main\\java\\res\\offer.txt")));
        int ch = 0;
        char ans='1';//保存前一个字符，用来判断什么时候笔记某一段结束了
        while ((ch = reader.read()) != -1) {
            temp = sb.toString();
            if ((char)ans=='\n'&&(char) ch == '\r') {//判断是否笔记段落结束
                if (!"".equals(temp)&&!"\n".equals(temp)) {//!"\n".equals(temp),几个空行会作为几个res，让res不添加空行
                    res.add(temp);
                }
                sb.delete(0, sb.length());//清空sb,空行也会清除
                temp=null;
            } else {
                sb.append((char) ch);
            }
            ans=(char)ch;
        }
        // 最后一段如果非空， 将最后一段加入，否则不处理
        if (!"".equals(temp)) {
            res.add(temp);
        }
    }

}
