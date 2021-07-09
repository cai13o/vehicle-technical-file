package cn.com.zz.service.impl;

import cn.com.zz.entity.VAnnualInspection;
import cn.com.zz.mapper.VAnnualInspectionMapper;
import cn.com.zz.service.IVAnnualInspectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆年度审验登记表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VAnnualInspectionServiceImpl extends ServiceImpl<VAnnualInspectionMapper, VAnnualInspection> implements IVAnnualInspectionService {

    @Override
    public boolean updateById(VAnnualInspection entity) {
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
