package cn.com.zz.service.impl;

import cn.com.zz.entity.VBasicInformation;
import cn.com.zz.mapper.VBasicInformationMapper;
import cn.com.zz.service.IVBasicInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆基本情况 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VBasicInformationServiceImpl extends ServiceImpl<VBasicInformationMapper, VBasicInformation> implements IVBasicInformationService {

    @Override
    public boolean updateById(VBasicInformation entity) {
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
