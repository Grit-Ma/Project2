package com.cskaoyan.tool;

import java.util.List;

public class PageTool {


    /**
     *   分页工具，将查询到的所有数据分割使其适应页码，每次需要查询全部的数据。
     * @param list  查询到的所有数据的集合
     * @param page 页码
     * @param rows 每页的行数
     * @param <T> 查询的数据类型
     * @return
     */
    public static <T> List<T> getPagedData(List<T> list, int page, int rows){
        int start = (page-1)*rows;
        int end = (page-1)*rows + rows;
        if(end > list.size()){
            end = list.size();
        }
        List<T> pagedList = list.subList(start, end);
        return pagedList;
    }
}
