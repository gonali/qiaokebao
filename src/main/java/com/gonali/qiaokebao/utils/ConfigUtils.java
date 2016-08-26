package com.gonali.qiaokebao.utils;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/8/26.
 */
public class ConfigUtils {


    private static ResourceBundle rb;

    ConfigUtils() {

    }

    public static ConfigUtils getConfigUtils(String resource) {

        ResourceBundle rb;

        ConfigUtils configUtils = new ConfigUtils();

        rb = PropertyResourceBundle.getBundle(resource);


        return configUtils;
    }


    public static ResourceBundle getResourceBundle(String configName) {


        rb = PropertyResourceBundle.getBundle(configName);

        return rb;
    }

}
