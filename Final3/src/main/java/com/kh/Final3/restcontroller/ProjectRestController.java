package com.kh.Final3.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.Final3.dao.ProjectDao;
import com.kh.Final3.dto.DocumentDto;
import com.kh.Final3.dto.ProjectDto;
import com.kh.Final3.service.JwtService;
import com.kh.Final3.vo.ProjectDataVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectRestController {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
    private JwtService jwtService;
	
	// 문서용 설정 추가
	@Operation(description = "문서 목록 조회", responses = {
			@ApiResponse(responseCode = "200", description = "조회 성공", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProjectDto.class))) }),
			@ApiResponse(responseCode = "500", description = "서버 오류", content = {
					@Content(mediaType = "text/plain", schema = @Schema(implementation = String.class), examples = @ExampleObject("server error")) }) })

	// 목록조회 (무한스크롤)
	@GetMapping("/")
	public List<ProjectDto> list() {
		return projectDao.selectList();
	}

	@GetMapping("/page/{page}/size/{size}")
	public ProjectDataVO list(@PathVariable int page, @PathVariable int size) {
		List<ProjectDto> list = projectDao.selectListByPaging(page, size);
		int count = projectDao.count();
		int endRow = page * size;
		boolean last = endRow >= count;
		return ProjectDataVO.builder().list(list)// 화면에 표시할 목록
				.count(count)// 총 데이터 개수
				.last(last)// 마지막 여부
				.build();
	}

	// 프로젝트 상세 조회
	@Operation(description = "프로젝트 상세 조회", responses = {
			@ApiResponse(responseCode = "200", description = "조회 성공", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class)) }),
			@ApiResponse(responseCode = "404", description = "해당 프로젝트 데이터가 없음", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class), examples = @ExampleObject("not found"))),
			@ApiResponse(responseCode = "500", description = "서버 오류", content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class), examples = @ExampleObject("server error"))) })

	@GetMapping("/{documentNo}")
	public ResponseEntity<ProjectDto> find(@PathVariable int projectNo) {
		ProjectDto projectDto = projectDao.selectOne(projectNo);
		if (projectDto == null) {
			// return ResponseEntity.notFound().build();
			return ResponseEntity.status(404).build();
		}
		// return ResponseEntity.ok(empDto);
		return ResponseEntity.status(200).body(projectDto);
	}

	// 등록
	@PostMapping("/")
	public ProjectDto save(@RequestBody ProjectDto projectDto, @RequestHeader("Authorization") String token) {
		  // 토큰 파싱하여 작성자 이름 가져오기
        String projectWriter = jwtService.parse(token).getAdminId();
		int sequence = projectDao.sequence();// 번호생성

		
		projectDto.setProjectNo(sequence);// 번호설정
		projectDao.insert(projectDto);// 등록
		return projectDao.selectOne(sequence);// 등록된 결과를 조회하여 반환
	}

	// 전체 수정
	@PutMapping("/")
	public ResponseEntity<?> editAll(@RequestBody ProjectDto projectDto) {
		boolean result = projectDao.editAll(projectDto);
		if (result == false) {
			// return ResponseEntity.notFound().build();
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok().build();
	}

	// 삭제
	@DeleteMapping("/{projectNo}")
	public ResponseEntity<?> delete(@PathVariable int projectNo) {
		boolean result = projectDao.delete(projectNo);
		if (result == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}

