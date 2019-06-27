package com.cskaoyan.tool;

import java.util.HashMap;
import java.util.List;

public class PageTool {


    /**
     *   分页工具，将查询到的所有数据分割使其适应页码，每次需要查询全部的数据。
     * @param list  查询到的所有数据的集合
     * @param page 页码
     * @param rows 每页的行数
     * @return
     */
    public static List getPagedData(List list, int page, int rows){
        int start = (page-1)*rows;
        int end = (page-1)*rows + rows;
        if(end > list.size()){
            end = list.size();
        }
        List pagedList = list.subList(start, end);
        return pagedList;
    }


    /**
     * 构造出分页信息Map
     * @param list 全部数据
     * @param page 页码
     * @param rows 每页行数
     * @return 分页的HashMap
     */
    public static HashMap<String,Object> getPageMap(List list,int page, int rows){
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",list.size());
        map.put("rows",getPagedData(list,page,rows));
        return map;
    }
}
