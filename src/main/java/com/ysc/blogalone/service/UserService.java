package com.ysc.blogalone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysc.blogalone.entity.user.User;
import com.ysc.blogalone.entity.user.dto.*;
import com.ysc.blogalone.util.R;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yc
 * @since 2023-12-14
 */
public interface UserService extends IService<User> {

    R register(RegisterDTO registerDTO);

    R login(LoginDTO loginDTO);

    R updateAvatar(AvatarDTO avatarDTO);

    R updatePassword(PasswordDTO passwordDTO);

    R updateNickname(NicknameDTO nicknameDTO);
}
