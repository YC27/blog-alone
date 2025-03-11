package com.ysc.blogalone.service.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysc.blogalone.constant.UserConstant;
import com.ysc.blogalone.entity.user.User;
import com.ysc.blogalone.entity.user.dto.*;
import com.ysc.blogalone.entity.user.vo.UserVO;
import com.ysc.blogalone.exception.YscException;
import com.ysc.blogalone.mapper.UserMapper;
import com.ysc.blogalone.service.UserService;
import com.ysc.blogalone.util.JwtTool;
import com.ysc.blogalone.util.R;
import com.ysc.blogalone.util.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public synchronized R register(RegisterDTO registerDTO) {
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();
        String confirmPassword = registerDTO.getConfirmPassword();

        if (StrUtil.isBlank(username) ) {
            throw new YscException(UserConstant.USERNAME_MUST_HAVE);
        }
        if ( StrUtil.isBlank(password) ) {
            throw new YscException(UserConstant.PASSWORD_MUST_HAVE);
        }
        if ( StrUtil.isBlank(confirmPassword) ) {
            throw new YscException(UserConstant.CONFIRM_PASSWORD_MUST_HAVE);
        }
        if ( !StrUtil.equals(password, confirmPassword) ) {
            throw new YscException(UserConstant.PASSWORD_NOT_EQUAL);
        }
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username);
        User conflict = userMapper.selectOne(lqw);
        if ( !ObjUtil.isEmpty(conflict) ) {
            throw new YscException(UserConstant.USERNAME_IS_EXIST);
        }
        if ( username.length() < 6 ) {
            throw new YscException(UserConstant.USERNAME_TO_SHORT);
        }
        if ( username.length() > 16 ) {
            throw new YscException(UserConstant.USERNAME_TO_LONG);
        }
        if ( password.length() < 6 ) {
            throw new YscException(UserConstant.PASSWORD_TO_SHORT);
        }
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user, User.class);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setNickname("ysc" + UUID.randomUUID().toString().replaceAll("-", "").substring(0,12));
        int i = userMapper.insert(user);
        if ( i < 1 ) {
            throw new YscException(UserConstant.NETWORK_ERROR);
        }
        return R.ok();
    }

    @Override
    public R login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        if (StrUtil.isBlank(username) ) {
            throw new YscException(UserConstant.USERNAME_MUST_HAVE);
        }
        if ( StrUtil.isBlank(password) ) {
            throw new YscException(UserConstant.PASSWORD_MUST_HAVE);
        }
        User loginUser = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        if ( ObjUtil.isEmpty(loginUser) ) {
            throw new YscException(UserConstant.USERNAME_NOT_FOUND);
        }
        boolean matches = new BCryptPasswordEncoder().matches(password, loginUser.getPassword());
        if ( !matches ) {
            throw new YscException(UserConstant.PASSWORD_ERROR);
        }

        if ( loginUser.getBan() == 1 ) {
            throw new YscException(UserConstant.USER_IS_BAN);
        }
        String token = JwtTool.createJWT(loginUser.getUserId().toString());
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(loginUser, userVO, UserVO.class);
        userVO.setToken(token);
        return R.ok().data("user", userVO);
    }

    @Override
    public R updateAvatar(AvatarDTO avatarDTO) {
        Long userId = UserContext.getUser();
        String avatar = avatarDTO.getAvatar();
        User user = new User();
        user.setAvatar(avatar);
        user.setUserId(userId);
        int i = userMapper.updateById(user);
        if ( i <= 0 ) {
            throw new YscException(UserConstant.NETWORK_ERROR);
        }
        return R.ok();
    }

    @Override
    public R updatePassword(PasswordDTO passwordDTO) {
        Long userId = UserContext.getUser();
        String rawPassword = passwordDTO.getRawPassword();
        String newPassword = passwordDTO.getNewPassword();
        User user = userMapper.selectById(userId);
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        if ( !bc.matches(rawPassword, user.getPassword()) ) {
            throw new YscException(UserConstant.RWA_PASSWORD_ERROR);
        }
        if ( StrUtil.isBlank(newPassword) ) {
            throw new YscException(UserConstant.PASSWORD_MUST_HAVE);
        }
        if ( newPassword.length() < 6 ) {
            throw new YscException(UserConstant.PASSWORD_TO_SHORT);
        }
        user.setPassword(bc.encode(newPassword));
        int i = userMapper.updateById(user);
        if ( i <= 0 ) {
            throw new YscException(UserConstant.NETWORK_ERROR);
        }
        return R.ok();
    }

    @Override
    public synchronized R updateNickname(NicknameDTO nicknameDTO) {
        Long userId = UserContext.getUser();
        String nickname = nicknameDTO.getNickname();
        if ( StrUtil.isBlank(nickname) ) {
            throw new YscException(UserConstant.NICK_NAME_MUST_HAVE);
        }
        if ( nickname.length() <= 1 ) {
            throw new YscException(UserConstant.NICK_NAME_TO_SHORT);
        }
        if ( nickname.length() > 16 ) {
            throw new YscException(UserConstant.NICK_NAME_TO_LONG);
        }
        User one = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getNickname, nickname));
        if ( !ObjUtil.isEmpty(one) ) {
            throw new YscException(UserConstant.NICK_NAME_IS_EXIST);
        }
        User user = new User();
        user.setUserId(userId);
        user.setNickname(nickname);
        int i = userMapper.updateById(user);
        if ( i <= 0 ) {
            throw new YscException(UserConstant.NETWORK_ERROR);
        }
        return R.ok();
    }
}
