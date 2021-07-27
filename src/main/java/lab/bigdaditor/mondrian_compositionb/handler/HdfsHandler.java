package lab.bigdaditor.mondrian_compositionb.handler;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class HdfsHandler {

    public void createDirectory() throws Exception{
        Configuration configuration = new Configuration();
        Path path = new Path("data");
        configuration.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://192.168.29.184:9000/"), configuration);
        fileSystem.mkdirs(path);
    }
}
