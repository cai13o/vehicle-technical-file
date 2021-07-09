package cn.com.zz.service.impl;

import cn.com.zz.entity.VChanges;
import cn.com.zz.mapper.VChangesMapper;
import cn.com.zz.service.IVChangesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆变更记录表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VChangesServiceImpl extends ServiceImpl<VChangesMapper, VChanges> implements IVChangesService {

    @Override
    public boolean updateById(VChanges entity) {
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
