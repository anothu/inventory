package indi.me.inventory;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import indi.me.inventory.entity.User;
import indi.me.inventory.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
class InventoryApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        AutoGenerator generator = new AutoGenerator();

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setAuthor("xiaoyulin");
        globalConfig.setOpen(false);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://100.64.203.188:3306/inventory_control?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("mysql0123xylxyy");

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("indi.me");
        //父级包名称
        packageConfig.setModuleName("inventory");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");

        StrategyConfig strategyConfig = new StrategyConfig();
        //添加lombok
        strategyConfig.setEntityLombokModel(true);
        //下划线转驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //同上
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(new String[]{"inventory","orderItem","user"});

        generator.setGlobalConfig(globalConfig);
        generator.setDataSource(dataSourceConfig);
        generator.setPackageInfo(packageConfig);
        generator.setStrategy(strategyConfig);

        generator.execute();
    }

    @Test
    void testUserMapper(){
        User user = new User();
        user.setName("hello");
        user.setPassword("123456");
        System.err.println(userMapper.insert(user));
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("-123.34542352312312534563465635474567456745734756345"));
    }
}
