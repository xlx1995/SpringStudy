package com.base.server.context;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/4/26
 */
public class MetadataApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getBeanFactory().addBeanPostProcessor(new InstantiationAwareBeanPostProcessorAdapter() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof NacosDiscoveryProperties) {
                    NacosDiscoveryProperties nacosDiscoveryProperties = (NacosDiscoveryProperties) bean;
                    Map<String, String> metadata = nacosDiscoveryProperties.getMetadata();

                    persistMetaInfo(metadata);
                }

                return bean;
            }
        });
        String property = applicationContext.getEnvironment().getProperty("spring.cloud.service-registry.auto-registration.enabled");
        System.out.println(property);
    }

    private void persistMetaInfo(Map<String, String> metadata) {
        metadata.put("author", "xlx");

        metadata.put("version","1.0.0");
    }

}
