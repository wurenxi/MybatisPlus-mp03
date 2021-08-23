package com.atguigu.mp.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author gxl
 * @date 2021年08月22日 12:29
 */
public class TestMP {

    /**
     * 代码生成示例代码
     */
    @Test
    public void testGenerator(){

        //1.全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //是否支持AR模式
              .setAuthor("gxl") //作者
              .setOutputDir("D:\\ProfessionalCourses\\MyBatisPlus\\IdealProject\\mp03\\src\\main\\java") //生成路径
              .setFileOverride(true) //文件覆盖
              .setIdType(IdType.AUTO) //主键策略
              .setServiceName("%sService") //设置生成的service接口名的首字母是否为I
              .setBaseResultMap(true)
              .setBaseColumnList(true);


        //2.数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL) //设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql:///mp")
                .setUsername("root")
                .setPassword("root");

        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setColumnNaming(NamingStrategy.underline_to_camel) //指定表名 字段名是否使用下划线
                .setTablePrefix("tbl_")
                .setInclude("tbl_employee"); //生成的表

        //4.包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.atguigu.mp")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");

        //5.整合配置
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6.执行
        mpg.execute();
    }
}
