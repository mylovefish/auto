/**
 *
 */
package com.ognice.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.NoticeMapper;
import com.ognice.domain.Notice;
import com.ognice.service.INoticeService;
/**
*
* 公告管理 service接口实现类
*
**/
@Service("noticeService")
public class NoticeService implements INoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    public Notice getNoticeById(Integer id) {
        return noticeMapper.selectNoticeById(id);
    }

    public String save(Notice record) {
            if (1 == noticeMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Notice> notices = noticeMapper.page(param);
        pageResult.setData(notices);
        param.setPage(null);
        pageResult.setTotal(noticeMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Notice record) {
        return noticeMapper.update(record);
    }

    public int delete(Integer id) {
        return noticeMapper.delete(id);
    }

    public List<Notice> all() {
		// TODO Auto-generated method stub
		return noticeMapper.page(new PageSearchParam());
	}

}
