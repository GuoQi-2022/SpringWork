package com.example.springdemo.Utils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wb.guoqi
 * @create 2022/4/11 9:51
 */
public class Listutils {

    /**
     * @param applyIds
     * @param size
     * @return List<List<String>>
     */
    private List<List<String>> sToList(List<String> applyIds, Integer size) {
        List<List<String>> applyIdLists = new LinkedList<>();
        /* 将applyIds分为size个一组的applyIdLists */
        Integer pageSize = size;
        for (int i = 0; i < applyIds.size(); i += size) {
            /* 最后没有size条数据则剩余几条applyIds中就装几条 */
            if (i + size > applyIds.size()) {
                pageSize = applyIds.size() - i;
            }
            List<String> applyIdss = applyIds.subList(i, i + pageSize);
            applyIdLists.add(applyIdss);
        }
        return applyIdLists;
    }

}
