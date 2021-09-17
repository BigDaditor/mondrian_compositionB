package lab.bigdaditor.mondrian_compositionb.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class SparkService {

    @Autowired
    JavaSparkContext sparkContext;

    public Map<String, Long> getCount() {
        String words = "abc|abc|ab";
        List<String> wordList = Arrays.asList(words.split("\\|"));
        JavaRDD<String> wordstr = sparkContext.parallelize(wordList);
        Map<String, Long> wordsCounts = wordstr.countByValue();
        System.out.println(wordsCounts);
        return wordsCounts;

    }
}
