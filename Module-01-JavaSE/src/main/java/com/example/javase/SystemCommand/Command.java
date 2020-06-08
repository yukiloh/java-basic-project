package com.example.javase.SystemCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 执行系统命令，主要依赖Process类下的方法
 */
public class Command {

    public static void main(String[] args) {
        printTerminalMessage("/root/v2ray/traffic.sh");
        printTerminalMessage("/usr/bin/v2ray/v2ctl api --server=127.0.0.1:10085 StatsService.GetStats 'name: \"user>>>admin>>>traffic>>>downlink\"'");   /*查看*/

    }

    //打印终端信息
    private static String printTerminalMessage(String cmd) {
        StringBuilder result= new StringBuilder();
        try {
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("UTF-8")));
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
