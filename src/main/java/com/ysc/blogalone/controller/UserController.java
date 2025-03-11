package com.ysc.blogalone.controller;

import com.ysc.blogalone.entity.board.Board;
import com.ysc.blogalone.entity.user.User;
import com.ysc.blogalone.entity.user.dto.*;
import com.ysc.blogalone.service.BoardService;
import com.ysc.blogalone.service.UserService;
import com.ysc.blogalone.util.R;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yc
 * @since 2023-12-14
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BoardService boardService;

    @PostMapping("/login")
    public R login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @PostMapping("/register")
    public R register(@RequestBody RegisterDTO registerDTO) {
        return userService.register(registerDTO);
    }

    @PutMapping("/updateAvatar")
    public R updateAvatar(@RequestBody AvatarDTO avatarDTO) {
        return userService.updateAvatar(avatarDTO);
    }

    @PutMapping("updatePassword")
    public R updatePassword(@RequestBody PasswordDTO passwordDTO) {
        return userService.updatePassword(passwordDTO);
    }

    @PutMapping("updateNickname")
    public R updateNickname(@RequestBody NicknameDTO nicknameDTO) {
        return userService.updateNickname(nicknameDTO);
    }

    @GetMapping("/getUser/{id}")
    public R getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        user.setPassword(null);
        return R.ok().data("user", user);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        User user = userService.getById(id);
        user.setPassword(null);
        return user;
    }

    @PostMapping("/sendMsg")
    public R sendMsg(@RequestBody Board board) {
        boardService.save(board);
        return R.ok();
    }

    @GetMapping("/getBoardList")
    public R getBoardList() {
        List<Board> list = boardService.list();
        return R.ok().data("list", list);
    }
}
