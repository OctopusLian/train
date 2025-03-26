package com.jiava.train.batch.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SchedulerConfig {

    @Resource
    private MyJobFactory myJobFactory;

    /**
     * 配置SchedulerFactoryBean
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        System.out.println(dataSource);
        factory.setDataSource(dataSource);
        factory.setJobFactory(myJobFactory);
        factory.setStartupDelay(2);
        return factory;
    }
}
