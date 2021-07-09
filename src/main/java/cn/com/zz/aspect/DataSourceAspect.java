package cn.com.zz.aspect;

import cn.com.zz.config.dataSource.DataSourceContextHolder;
import cn.com.zz.enums.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceAspect {

    @Pointcut("execution(* cn.com.zz.mapper..*.*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(* cn.com.zz.dao..*.*(..))")
    private void db2Aspect() {
    }

    @Before("db1Aspect()")
    public void db1() {
        log.info("切换到db1 数据源...");
        DataSourceContextHolder.setDbType(DBTypeEnum.db1);
    }

    @Before("db2Aspect()")
    public void db2() {
        log.info("切换到db2 数据源...");
        DataSourceContextHolder.setDbType(DBTypeEnum.db2);
    }
}
