package utils;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//播放傻妞声音
public class Music {
    public Player player = null;
    public void music(){
        try {
            File directory = new File("");// 参数为空
            String courseFile = directory.getCanonicalPath();
            File mp3 = new File(courseFile+"\\src\\main\\java\\res\\niuMusic.mp3");

            //创建一个输入流
            FileInputStream fileInputStream = new FileInputStream(mp3);
            //创建一个缓冲流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            //创建播放器对象，把文件的缓冲流传入进去
            player = new Player(bufferedInputStream);
            //调用播放方法进行播放
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        new Music().music();
    }
}
