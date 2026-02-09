package kr.hi.community.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hi.community.dao.CommentDAO;
import kr.hi.community.model.util.Criteria;
import kr.hi.community.model.vo.CommentVO;

@Service
public class MemberService {
	@Autowired
	CommentDAO commentDAO;

	public Map<String, Object> getCommentList(int po_num, Criteria cri) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (po_num <= 0) {
			map.put("list", null);
			map.put("totalCount", 0);
			return map;}
		
		if (cri == null) {
			cri = new Criteria();}

		try {
			int totalCount = commentDAO.selectTotalCount(po_num);
			
			List<CommentVO> list = commentDAO.selectCommentList(po_num, cri);


			map.put("list", list);
			map.put("totalCount", totalCount);

		} catch (Exception e) {
			e.printStackTrace();
			map.put("list", null);
			map.put("totalCount", 0);
		}

		return map;
	}
}