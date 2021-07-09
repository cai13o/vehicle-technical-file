package cn.com.zz.service.impl;

import cn.com.zz.entity.VAssemblyReplaced;
import cn.com.zz.mapper.VAssemblyReplacedMapper;
import cn.com.zz.service.IVAssemblyReplacedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆主要总成部件更换登记表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VAssemblyReplacedServiceImpl extends ServiceImpl<VAssemblyReplacedMapper, VAssemblyReplaced> implements IVAssemblyReplacedService {

    @Override
    public boolean updateById(VAssemblyReplaced entity) {
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
