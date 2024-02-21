package org.example.springAop.ComponentScanConfig;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy  // TODO 1.별도 컴포넌트 스캔 적용시 프록시 애노테이션 적용필요, 왜?
@Configuration
@ComponentScan(basePackages = "org.example.springAop")
public class ComponentScanConfig {


}
