package kr.hi.community.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class FileVO {
	int fi_num;//파일 번호, 기본키, 대리키
	
	@NonNull
	int fi_po_num;//첨부파일과 연결된 게시글 번호
	@NonNull
	String fi_ori_name;//업로드 하기 전 파일명
	
	@NonNull
	String fi_name;//업로드 후 경로로 서버에 업로드한 폴더와 uuid가 있는 파일명
	

}
