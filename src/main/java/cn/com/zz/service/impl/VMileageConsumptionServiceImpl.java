package cn.com.zz.service.impl;

import cn.com.zz.entity.VMileageConsumption;
import cn.com.zz.mapper.VMileageConsumptionMapper;
import cn.com.zz.service.IVMileageConsumptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆行驶里程与燃油消耗登记表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VMileageConsumptionServiceImpl extends ServiceImpl<VMileageConsumptionMapper, VMileageConsumption> implements IVMileageConsumptionService {

    @Override
    public boolean updateById(VMileageConsumption entity) {
        if(null != entity){
            if(1==baseMapper.updateById(entity))
                return true;
            return false;
        }else {
            if(1==baseMapper.insert(entity))
                return true;
            return false;
        }
    }
}
