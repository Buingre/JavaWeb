package test.thread0424;

import java.util.concurrent.TimeUnit;

/**
 * 演示电影字幕展示效果
 */
public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        String content = "留声机在光影里飘来悠悠的乐声，夏日的午后，靠在藤椅上，让摇椅随乐声晃动，绿色的虎皮蕉在脚边肆意蔓延微醺着，半梦半醒。\n" +
                "耳边的音乐让我想起来那个画面，也是在一个阳光透过树叶的空隙显得有些阑珊的午后";
        for(char item:content.toCharArray()){
            System.out.print(item);
            //线程休眠方式1：
            Thread.sleep(300);//单位ms
            //线程休眠方式2：
            TimeUnit.SECONDS.sleep(1);//休眠1s
            TimeUnit.HOURS.sleep(1);//1h
            //线程休眠方式3：
            //todo: 1s-->1000ms
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        }
    }
}
