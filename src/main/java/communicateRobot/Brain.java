package communicateRobot;

import utils.Music;

import java.io.IOException;
import java.util.Scanner;

/**
 * @authod Mr Chen
 */
public class Brain {
    public static int monkey=2;
    public static void main(String[] args) throws IOException {
        System.out.println("华人牌2060款手机傻妞为您服务!!!");
        //播放傻妞声音
        new Music().music();
        System.out.println("请选择傻妞模式");
        System.out.println("1：智能回复模式;  2: 单词复习模式  3: 笔记回顾模式  4: 歌曲模式");
        Scanner sc=new Scanner(System.in);


        String line=sc.nextLine();
        int index=line.charAt(0)-'0';
        if(index==1){
            new PatternOne().deleteLast();
        }else if(index==2){
            new PatternTwo().reviewWord();
        }else if(index==3){
            new PatternThree().record();
        }else if(index==4){
            //ListenMusic.music();
            new PatternFour().playMusic();
        }else if(line.length()>1||48>line.charAt(0)-'0'||line.charAt(0)-'0'>57){
            System.out.println("乖乖输入1或2或3或...,不要乱给傻妞乱七八糟的指令哦哦哦");
        }else if(index<1||index>3){
            System.out.println("其他功能还有待傻妞去升级，耐心等一下哈！");
        }



        if(monkey==0){
            System.out.println("余额不足，请充值！");
        }
        //System.out.println(monkey);
    }
}
