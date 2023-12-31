package org.buaa.config;

import com.central.oauth2.common.config.DefaultResourceServerConf;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * security资源服务器配置
 *
 * @author buaa
 * @version 1.0
 * @date 2022/6/25
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
@Configuration
@EnableResourceServer
public class MyResourceConfig extends DefaultResourceServerConf {
}
