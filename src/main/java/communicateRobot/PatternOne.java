package communicateRobot;


import java.util.Scanner;
import static communicateRobot.Brain.monkey;//引入Brain.java的monkey
/**
 * @authod Mr Chen
 */
//智能删除末尾疑问词
public class PatternOne {
    /*@Autowired
    private  Brain brain;*/

    public void deleteLast(){
        System.out.println("请给傻妞发个消息！");
        while(monkey>0){
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();
            int len=str.length();
            if(len>1){
                if(str.charAt(0)=='我'){
                    char[] ch = str.toCharArray();
                    ch[0]='也';
                    str='我'+new String(ch);
                }else if(str.charAt(len-1)=='吗'||str.charAt(len-1)=='啊'||str.charAt(len-1)=='呀'){
                    str=str.substring(0,len-1);
                }else if(str.charAt(len-2)=='吗'||str.charAt(len-2)=='啊'||str.charAt(len-2)=='呀'){
                    str=str.substring(0,len-2);
                }
            }
            System.out.println(str);
            monkey--;
        }
    }
}
