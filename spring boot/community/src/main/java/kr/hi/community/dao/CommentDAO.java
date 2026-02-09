package kr.hi.community.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import kr.hi.community.model.util.Criteria;
import kr.hi.community.model.vo.CommentVO;

public interface CommentDAO {

    // 특정 게시글의 전체 댓글 개수 조회 (삭제되지 않은 것)
    int selectTotalCount(@Param("po_num") int po_num);

    // 특정 게시글의 댓글 목록 조회 (페이징, 정렬 조건 포함)
    List<CommentVO> selectCommentList(@Param("po_num") int po_num, @Param("cri") Criteria cri);

}