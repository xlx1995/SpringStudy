package com.base.server.context;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.MapPropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/4/26
 */
public class NacosClientConfigApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(NacosClientConfigApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        try {
            Map<String, Object> nacosClientPropertySource = new HashMap<>();
            nacosClientPropertySource.put("spring.cloud.nacos.config.server-addr", "42.192.44.38:8848");
            nacosClientPropertySource.put("spring.cloud.nacos.discovery.server-addr", "42.192.44.38:8848");

            applicationContext.getEnvironment().getPropertySources()
                    .addLast(new MapPropertySource("xlxNacosDiscoverProperties", nacosClientPropertySource));

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }


}
