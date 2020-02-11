package com.xzy.controller;

import org.mybatis.generator.ant.GeneratorAntTask;

public class test {
    private static final String CONFIG_FILE_PATH = "D:\\bianchen\\IntelliJ IDEA 2019.3.1\\ideaprojects\\shoppingMall\\src/main/resources/generatorConfig.xml";

    public static void main(String[] args) {
        try {
            GeneratorAntTask task = new GeneratorAntTask();
            task.setConfigfile(CONFIG_FILE_PATH);
            task.setOverwrite(true);
            task.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
