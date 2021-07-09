package cn.com.zz.service.impl;

import cn.com.zz.entity.VInspectionReview;
import cn.com.zz.mapper.VInspectionReviewMapper;
import cn.com.zz.service.IVInspectionReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆检测与评审登记表 服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-05
 */
@Service
public class VInspectionReviewServiceImpl extends ServiceImpl<VInspectionReviewMapper, VInspectionReview> implements IVInspectionReviewService {

    @Override
    public boolean updateById(VInspectionReview entity) {
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
