package com.websystique.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

@Configuration
public class FlowConfiguration extends AbstractFlowConfiguration {

	@Autowired
	private AppConfig webMvcConfig;
	
	@Autowired
	Validator validator;
	
	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry())
				.addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
				.build();
	}

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder()
				.setBasePath("/WEB-INF/flows")
				.addFlowLocationPattern("/checkout/checkout-flow.xml").build();
	}

	@Bean
	public FlowHandlerMapping flowHandlerMapping(){
		FlowHandlerMapping flow = new FlowHandlerMapping();
		flow.setFlowRegistry(flowRegistry());
		return flow;
	}
	
	@Bean
	public FlowHandlerAdapter flowHandlerAdapter(){
		FlowHandlerAdapter fh = new FlowHandlerAdapter();
		fh.setFlowExecutor(flowExecutor());
		return fh;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

}
