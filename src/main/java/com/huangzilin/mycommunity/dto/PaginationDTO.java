package com.huangzilin.mycommunity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*储存问题列表及其他页面信息*/
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;/*向前按钮*/
    private Boolean showFirst;/*第一页按钮*/
    private Boolean showNext;/*向后按钮*/
    private Boolean showLast;/*最后一页按钮*/
    private Integer curPage;/*当前页*/
    private Integer tolPage;/*总页数*/
    private List<Integer> pages;/*显示的页码*/

    /**
     *
     * @param num  问题总数
     * @param page 当前页数
     * @param size 每页问题数
     */
    public void setPagination(Integer num, Integer page, Integer size) {
        pages = new ArrayList<>();/*显示的页码*/
        int total_page = num % size == 0 ? num / size : num / size + 1; /*页面总数*/
        /*设置当前页数*/
        this.setCurPage(page);
        this.setTolPage(total_page);

        /*显示的页码范围*/
        int start = Math.max(page - 2, 1);
        int end = Math.min(page + 2, total_page);
        for (int i = start; i <= end; i++)
            pages.add(i);
        /*页数为1时没有向前按钮*/
        showPrevious = page != 1;
        /*页数为最后一页时没有向后按钮*/
        showNext = page != total_page;
        /*是否展示第一页*/
        showFirst = !pages.contains(1);
        /*是否展示最后一页*/
        showLast = !pages.contains(total_page);
    }

}
