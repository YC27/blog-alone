package com.ysc.blogalone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysc.blogalone.entity.board.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper extends BaseMapper<Board> {
}
