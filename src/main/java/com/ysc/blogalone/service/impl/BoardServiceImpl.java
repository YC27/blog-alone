package com.ysc.blogalone.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysc.blogalone.entity.board.Board;
import com.ysc.blogalone.mapper.BoardMapper;
import com.ysc.blogalone.service.BoardService;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl extends ServiceImpl<BoardMapper, Board> implements BoardService {
}
