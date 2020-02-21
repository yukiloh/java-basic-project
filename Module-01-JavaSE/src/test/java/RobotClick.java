import java.awt.*;
import java.awt.event.InputEvent;

//辅助钓鱼
public class RobotClick {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();


       /* robot.delay(2000);
        System.out.println(robot.getPixelColor(987, 484));*/


       int x = 910;
       int y = 120;
       Boolean flag = true;
       while (flag){
//           910 970
//               160 180
           robot.mouseMove(x,y);

           PointerInfo pointerInfo = MouseInfo.getPointerInfo();
           Point p = pointerInfo.getLocation();
           double mx = p.getX();
           double my = p.getY();
//           System.out.println(mx+"   "+my);
           int r = robot.getPixelColor((int) mx, (int) my).getRed();
           int g = robot.getPixelColor((int) mx, (int) my).getGreen();
           int b = robot.getPixelColor((int) mx, (int) my).getBlue();
           System.out.println(r +"    "+g +"   "+b);
//           if ((r >180 && r<210 ) && (g >70 & g < 90) && (b >70 & b < 85)){
           if ((r >20 && r<100 ) && (g >50 & g < 160) && (b >50 & b < 200)){
               flag = false;
           }
           x += 10;
           if (x > 1000) {
               y += 10;
               x =910;
           }
           robot.delay(50);
       }

    }
}
