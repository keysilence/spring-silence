package com.silence;

import com.silence.profile.config.ProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.sql.DataSource;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    @Test
    public void testProfile01() {
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileConfig.class);
        context.refresh();
        String[] names = context.getBeanNamesForType(DataSource.class);
        Stream.of(names).forEach(System.out::println);
    }
}
