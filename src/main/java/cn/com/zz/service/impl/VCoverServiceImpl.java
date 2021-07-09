package cn.com.zz.service.impl;

import cn.com.zz.entity.VCover;
import cn.com.zz.mapper.VCoverMapper;
import cn.com.zz.service.IVCoverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 陕西省道路运输车辆技术档案 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VCoverServiceImpl extends ServiceImpl<VCoverMapper, VCover> implements IVCoverService {

    @Override
    public boolean updateById(VCover entity) {
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
