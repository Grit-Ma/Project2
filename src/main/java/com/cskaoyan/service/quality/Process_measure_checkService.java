package com.cskaoyan.service.quality;

import com.cskaoyan.bean.Process_measure_check;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Process_measure_checkService {
    List<Process_measure_check> selectByPage(int page, int rows);
}
