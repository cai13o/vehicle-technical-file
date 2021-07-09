package cn.com.zz.service.impl;

import cn.com.zz.entity.VMaintainRepair;
import cn.com.zz.mapper.VMaintainRepairMapper;
import cn.com.zz.service.IVMaintainRepairService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆维护与维修登记表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VMaintainRepairServiceImpl extends ServiceImpl<VMaintainRepairMapper, VMaintainRepair> implements IVMaintainRepairService {

    @Override
    public boolean updateById(VMaintainRepair entity) {
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
