package utils;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//播放傻妞声音
public class ListenMusic {
    public static void main(String[] args) throws IOException {
        System.out.println(args.toString());
        music();
    }
    public static void music() throws IOException {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        try {
            new Player(new BufferedInputStream
                    (new FileInputStream(
                            new File(courseFile+"\\src\\main\\java\\res\\music\\有何不可.mp3"))))
                    .play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
