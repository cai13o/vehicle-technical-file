package cn.com.zz.service.impl;

import cn.com.zz.entity.VhMaintenancePlan;
import cn.com.zz.mapper.VhMaintenancePlanMapper;
import cn.com.zz.service.IVhMaintenancePlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 维护计划 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VhMaintenancePlanServiceImpl extends ServiceImpl<VhMaintenancePlanMapper, VhMaintenancePlan> implements IVhMaintenancePlanService {

    @Override
    public boolean updateById(VhMaintenancePlan entity) {
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
