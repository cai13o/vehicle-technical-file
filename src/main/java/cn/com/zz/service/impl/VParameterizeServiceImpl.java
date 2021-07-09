package cn.com.zz.service.impl;

import cn.com.zz.entity.VParameterize;
import cn.com.zz.mapper.VParameterizeMapper;
import cn.com.zz.service.IVParameterizeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆参数与配置登记表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VParameterizeServiceImpl extends ServiceImpl<VParameterizeMapper, VParameterize> implements IVParameterizeService {

    @Override
    public boolean updateById(VParameterize entity) {
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
