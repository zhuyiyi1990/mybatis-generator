package com.github.zhuyiyi1990.mybatisgenerator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱一一
 * <a href="http://mybatis.org/generator">MyBatis Generator</a>
 */
public class MybatisGenerator {

    public static void main(String[] args) {
        try {
            System.out.println("MybatisGenerator.main start");
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            InputStream configFile = MybatisGenerator.class.getResourceAsStream("/mybatis-generator-config.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("MybatisGenerator.main end");
        }
    }

}