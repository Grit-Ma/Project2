package com.cskaoyan.service;

import com.cskaoyan.bean.Work;
import com.cskaoyan.vo.PageVo;
import com.cskaoyan.vo.ResponseVo;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface WorkService {
    PageVo workPage(int page, int rows);

    List<Work> workGetData();

    Work workGet(String id);

    ResponseVo updateWork(Work work);

    ResponseVo insertWork(Work work);

    @Delete("delete from ")
    ResponseVo batchDeleteWorkByIds(List<String> asList);
}
