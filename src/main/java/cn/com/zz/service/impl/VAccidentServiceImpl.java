package cn.com.zz.service.impl;

import cn.com.zz.entity.VAccident;
import cn.com.zz.mapper.VAccidentMapper;
import cn.com.zz.service.IVAccidentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆交通事故登记表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VAccidentServiceImpl extends ServiceImpl<VAccidentMapper, VAccident> implements IVAccidentService {

    @Override
    public boolean updateById(VAccident entity) {
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
