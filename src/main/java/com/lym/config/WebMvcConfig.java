package com.lym.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liyumin
 * @date 2022/08/08 16:27
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 解决前后端跨域问题
     * addMapping：表示对哪种格式的请求路径进行跨域处理。
     * allowedHeaders：表示允许的请求头，默认允许所有的请求头信息。
     * allowedMethods：表示允许的请求方法，默认是 GET、POST 和 HEAD。这里配置为 * 表示支持所有的请求方法。
     * maxAge：表示探测请求的有效期
     * allowedOriginPatterns：表示支持的域
     * allowCredentials：允许客户端携带验证信息
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOriginPatterns("*")
                .allowCredentials(true);
    }
}
