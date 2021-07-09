package cn.com.zz;

import cn.com.zz.entity.TDept;
import cn.com.zz.service.ITDeptService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class VehicleTechnicalFileApplicationTests {

    @Resource
    private ITDeptService deptService;

    @Test
    void contextLoads() {
        List<TDept> list = this.deptService.list();
        System.out.println(list);
    }
}
