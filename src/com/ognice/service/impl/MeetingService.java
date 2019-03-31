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
import com.ognice.dao.MeetingMapper;
import com.ognice.domain.Meeting;
import com.ognice.service.IMeetingService;
/**
*
* 会议管理 service接口实现类
*
**/
@Service("meetingService")
public class MeetingService implements IMeetingService {
    @Resource
    private MeetingMapper meetingMapper;

    public Meeting getMeetingById(Integer id) {
        return meetingMapper.selectMeetingById(id);
    }

    public String save(Meeting record) {
            if (1 == meetingMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Meeting> meetings = meetingMapper.page(param);
        pageResult.setData(meetings);
        param.setPage(null);
        pageResult.setTotal(meetingMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Meeting record) {
        return meetingMapper.update(record);
    }

    public int delete(Integer id) {
        return meetingMapper.delete(id);
    }

    public List<Meeting> all() {
		// TODO Auto-generated method stub
		return meetingMapper.page(new PageSearchParam());
	}

}
