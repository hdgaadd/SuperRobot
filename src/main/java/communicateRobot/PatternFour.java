package communicateRobot;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;
import java.util.Scanner;
/**
 * @authod Mr Chen
 *播放歌曲一个线程，关闭歌曲一个线程，其中关闭歌曲线程包含换歌的method
 * 播放一首歌曲，会有一个关闭歌曲线程去监控播放该歌曲的线程：如果换歌会关闭上面两个线程，执行下一次循环；如果关闭歌曲则关闭上面两个线程，程序终止
 */
public class PatternFour {
    private playMusicThread mT;
    private  Player player = null;
    public void playMusic(){
        //获取歌曲播放对象
        try {
            //声明一个File对象
            File directory = new File("");// 参数为空
            String courseFile = directory.getCanonicalPath();
            File file = new File(courseFile+"\\src\\main\\java\\res\\music\\");
            File[] files = file.listFiles();
            Random random = new Random();
            int index=random.nextInt(files.length);
            System.out.println("music" + index);
            File mp3 = files[index];
            //创建一个输入流
            FileInputStream fileInputStream = new FileInputStream(mp3);
            //创建一个缓冲流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            //创建播放器对象，把文件的缓冲流传入进去
            player = new Player(bufferedInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取线程操作歌曲播放对象
        mT = new playMusicThread();
        mT.start();
        closeMusicThread cT = new closeMusicThread();
        cT.start();
    }
    private class playMusicThread extends Thread{//播放歌曲的线程
        @Override
        public void run() {
            try {
                //调用播放方法进行播放
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class closeMusicThread extends Thread{//关闭歌曲的线程
        @lombok.SneakyThrows
        @Override
        public void run() {
            boolean flag=true;
            boolean flag2=true;
            System.out.println(".............输入break关闭歌曲,回车换歌.............");
            Scanner scanner=new Scanner(System.in);
            String line=scanner.nextLine();
            if(line.equals("")){
                flag=false;
                replaceMusic();
            }
            //换歌后只可以执行关闭歌曲
            if(flag){
                while (!line.equals("break")){
                    System.out.println("你不乖，输入有误！");
                    line=scanner.nextLine();
                    if(line.equals("")){//当输入非回车符后，如果再输入回车可以实现换歌
                        flag2=false;
                        replaceMusic();
                        break;
                    }
                }
                if(flag2){//false关闭代码
                    closeMusic();//关闭歌曲
                    System.out.println(".............歌曲已关闭.............");
                }
            }

        }
        //换歌
        public void replaceMusic() throws InterruptedException {
            System.out.println("换歌");
            closeMusic();
            playMusic();
        }
        //关闭歌曲
        public void closeMusic() throws InterruptedException {
            mT.sleep(500);
            player.close();
        }

    }
}
