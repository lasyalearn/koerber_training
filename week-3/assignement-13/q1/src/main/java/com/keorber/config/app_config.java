package com.keorber.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.keorber")
// helps us to intergrate the aspect framework with spring framework
@EnableAspectJAutoProxy
public class app_config
{

}
