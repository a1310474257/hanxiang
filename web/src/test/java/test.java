import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class test {

        public static void main(String[] args) throws IOException {
//            String name = FilenameUtils.getExtension("001.txt");
//            System.out.println(name);// 文件的扩展名
//            String Filename = FilenameUtils.getName("001.txt");
//            System.out.println(Filename);//文件名
//            boolean b=FilenameUtils.isExtension("001.txt", "java");
//            System.out.println(b);

            FileUtils.copyFile(new File("E:\\网页设计\\1.jpg"),new File("E:\\网页\\1.jpg") );
        }

}
