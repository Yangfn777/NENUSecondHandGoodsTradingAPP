package com.join.GoodsTradingProgram.utils.readfile;

import java.io.*;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 7:36 2020/9/5
 */
public class ReadFileUtils {

    //// 使用文件流可设置编码格式
    private FileInputStream file;

    /**
     * 根据文件路径读取文件
     * @param path
     */
    public ReadFileUtils(String path){
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取流中的文件数据
     * @return
     */
    public String readTxtFile(){
        // 非线程安全类，建议多线程中用StringBuffer
        StringBuilder result = new StringBuilder();
        // 创建字符读取流
        BufferedReader br = null;
        InputStreamReader in = null;
        try {
            // 设置编码格式为GBK，防治中文乱码
            in = new InputStreamReader(file,"GBK");
            br = new BufferedReader(in);
            String s = null;
            boolean firstLine = true;
            while((s = br.readLine()) != null){
                if(firstLine){
                    firstLine = false;
                }else {
                    result.append("\n");
                }
                result.append(s);
            }
            return result.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "file FileNotFound error!";
        } catch (IOException e) {
            e.printStackTrace();
            return "file read error!";
        }finally{
            try {
                if(null != br){
                    // 关闭输入流
                    br.close();
                }
                if(null != in){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
