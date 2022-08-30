package com.example.demo1.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：Puyb
 * @date ：Created in 2021/12/13 17:40
 * @description：
 */

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .forCodeGeneration(true)
                .select()
                // 指定要生成api接口的包路径com.example.controller
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                //使用了 @ApiOperation 注解的方法生成api接口文档
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build().groupName("全部").pathMapping("/");
    }

    /**
     * 设置api文档的详细信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("Spring Boot集成Swagger2")
                // 接口描述
                .description("swagger")
                // 版本信息
                .version("1.0")
                // 构建
                .build();
    }
}
