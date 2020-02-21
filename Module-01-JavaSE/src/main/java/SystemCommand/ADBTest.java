package SystemCommand;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ADBTest {
    public static void main(String[] args) {
//        printTerminalMessage("ping www.google.com");
        callADB();
    }

    private static void callADB() {

        try {
            Thread.sleep(1000);
            Robot robot = new Robot();
            while (true) {
                robot.keyPress(KeyEvent.VK_UP);
                robot.keyRelease(KeyEvent.VK_UP);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(100);
            }

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    /*打印终端信息*/
    private static String printTerminalMessage(String cmd) {
        StringBuilder result= new StringBuilder();
        try {
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("GBK")));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                result.append(line).append("\n");
            }

            br.close();
            System.out.println("close ... ");
            ps.waitFor();
            System.out.println("wait over ...");

            return result.toString();
        } catch (IOException | InterruptedException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("child thread donn");
        return null;
    }
}
