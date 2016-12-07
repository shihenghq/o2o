package com.o2o.iteam.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * 配置文件加载工具类
 * 所有配置参数都可以通过该类中conf获取
 */
public class ConfUtil {
    //启用调试模式
    private static final Logger log = LoggerFactory.getLogger(ConfUtil.class);
    private static JSONObject conf = new JSONObject();
    private static JSONArray confArray = new JSONArray();

    private ConfUtil() {
    }


    /**
     * 获取配置对象
     *
     * @return
     */
    public static JSONObject getConf() {
        return conf;
    }

    public static JSONArray getConfArray() {
        return confArray;
    }

    public static void loadJsonConf(String fileName) {
        try {
            InputStream inputStream = ConfUtil.class.getClassLoader().getResourceAsStream(fileName);
            String str = IOUtils.toString(inputStream, "UTF-8");
            JSONObject jsonConfig = JSON.parseObject(str);
            log.debug("----------加载配置文件成功[" + fileName + "]----------");
            log.debug("配置文件配置类型:{}", jsonConfig.getString("CONFIG_TYPE"));
            conf = jsonConfig.getJSONObject(jsonConfig.getString("CONFIG_TYPE"));
            log.debug(conf.toJSONString());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            log.debug("----------加载配置文件失败[" + fileName + "]----------");
        }
    }

  public static void loadJsonArrayConf(String fileName) {
        try {
            InputStream inputStream = ConfUtil.class.getClassLoader().getResourceAsStream(fileName);
            String str = IOUtils.toString(inputStream, "UTF-8");
            confArray = JSON.parseArray(str);
            log.debug("----------加载配置文件成功[" + fileName + "]----------");
            log.debug(conf.toJSONString());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            log.debug("----------加载配置文件失败[" + fileName + "]----------");
        }
    }

    /**
     * @param key 键 支持...... 列：system.host
     * @return
     */
    public static String getString(String key) {
        return getString(key, null);
    }

    public static String getString(String key, String defaultValue) {
        return get(key, String.class, defaultValue);
    }


    public static BigDecimal getBigDecimal(String key) {
        return getBigDecimal(key, null);
    }

    public static BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
        return get(key, BigDecimal.class, defaultValue);
    }


    public static Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }

    public static Boolean getBoolean(String key, Boolean defaultValue) {
        return get(key, Boolean.class, defaultValue);
    }

    public static Integer getInteger(String key) {
        return getInteger(key, null);
    }

    public static Integer getInteger(String key, Integer defaultValue) {
        return get(key, Integer.class, defaultValue);
    }

    private static <T> T get(String key, Class<?> classOfT, T defaultValue) {
        if (StringUtils.isNotBlank(key)) {
            String ks[] = key.split("\\.");
            JSONObject row = ConfUtil.getConf();
            for (int i = 0; i < ks.length; i++) {
                if (i == ks.length - 1) {
                    if (classOfT == String.class) {
                        return (T) row.getString(ks[i]);
                    } else if (classOfT == BigDecimal.class) {
                        return (T) row.getBigDecimal(ks[i]);
                    } else if (classOfT == Boolean.class) {
                        return (T) row.getBoolean(ks[i]);
                    } else if (classOfT == Integer.class) {
                        return (T) row.getInteger(ks[i]);
                    }
                } else {
                    row = row.getJSONObject(ks[i]);
                    if (row == null) return defaultValue;
                }
            }
        }
        return defaultValue;
    }

    public static void main(String[] args) {
        loadJsonConf("conf.json");
    }
}
