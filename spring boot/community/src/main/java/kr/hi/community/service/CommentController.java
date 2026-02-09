package kr.hi.community.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.hi.community.model.util.Criteria;
import kr.hi.community.model.util.PageMaker;
import kr.hi.community.model.vo.CommentVO;

@RestController
@RequestMapping("/api/v2/posts")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{po_num}/comments")
    public ResponseEntity<Map<String, Object>> getCommentList(
            @PathVariable("po_num") int po_num, 
            Criteria cri) {


        List<CommentVO> list = commentService.getCommentList(cri);
        int totalCount = commentService.getTotalCount(po_num, cri);

        PageMaker pm = new PageMaker();
        pm.setCri(cri);
        pm.setTotalCount(totalCount);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("pm", pm);

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}