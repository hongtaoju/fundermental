/*
 * module: fundermental
 * file: ServiceJavaInfrastructureApplication.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure;

import com.xlab.service_java_infrastructure.spring.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class ServiceJavaInfrastructureApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ServiceJavaInfrastructureApplication.class, args);
		Person person = (Person) configurableApplicationContext.getBean("person");
		System.out.println(person.getName());
		SimpleAsyncTaskExecutor simpleAsyncTaskExecutor;
		ScheduledAnnotationBeanPostProcessor scheduledAnnotationBeanPostProcessor;
		AbstractApplicationContext abstractApplicationContex;
		//configurableApplicationContext.close();
	}
}
