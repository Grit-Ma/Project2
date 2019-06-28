package com.cskaoyan.mapper;

import com.cskaoyan.bean.Process_measure_check;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Process_measure_checkMapper {

    List<Process_measure_check> selectByPage(@Param("limit") int limit, @Param("offset") int offset);
}
