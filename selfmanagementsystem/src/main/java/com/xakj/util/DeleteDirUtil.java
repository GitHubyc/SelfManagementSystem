package com.xakj.util;

import java.io.File;

public class DeleteDirUtil {
    /**
     * 删除空目录
     * @param dir 将要删除的目录路径
     */

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
//递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
public static void main(String[] args) {
	deleteDir(new File(""));
}
}