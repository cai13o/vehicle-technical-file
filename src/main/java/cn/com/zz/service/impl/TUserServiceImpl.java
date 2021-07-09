package cn.com.zz.service.impl;

import cn.com.zz.entity.TUser;
import cn.com.zz.mapper.TUserMapper;
import cn.com.zz.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 13o
 * @since 2021-07-08
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
