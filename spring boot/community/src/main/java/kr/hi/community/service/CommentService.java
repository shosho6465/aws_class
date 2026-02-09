package kr.hi.community.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.hi.community.mapper.CommentMapper;
import kr.hi.community.model.util.Criteria;
import kr.hi.community.model.vo.CommentVO;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public Map<String, Object> getCommentList(int po_num, Criteria cri) {
        
        int totalCount = commentMapper.getTotalCount(po_num);
        
        List<CommentVO> list = commentMapper.getCommentList(po_num, cri);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("totalCount", totalCount);
        
        return map;
    }
}