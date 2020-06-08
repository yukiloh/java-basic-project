package com.example.javase.SystemCommand;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ADBTest {
    public static void main(String[] args) {
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
}
