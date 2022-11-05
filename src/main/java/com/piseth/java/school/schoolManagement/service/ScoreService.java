package com.piseth.java.school.schoolManagement.service;

import java.util.List;

import com.piseth.java.school.schoolManagement.dto.MonthlyScoreDTO;
import com.piseth.java.school.schoolManagement.dto.StudentDTO;
import com.piseth.java.school.schoolManagement.dto.SubjectDTO;
import com.piseth.java.school.schoolManagement.model.MonthlyScore;
import com.piseth.java.school.schoolManagement.model.Student;
import com.piseth.java.school.schoolManagement.model.Subject;



public interface ScoreService {
	//MonthlyScoreDTO createScore(MonthlyScoreDTO dto,Integer Id,Integer Id1);
//	 Post updatePost(PostDTO postDTO,Integer postId);
//	   void deletePost(Integer postId);
//	   List<PostDTO>getList();
//	   Post getpostById(Integer postId);
//	   List<Post>getPostById(Integer postId);
//	   List<Post>getPostByUser(Integer userId);
//	   List<Post>searchPost(String keyword);
//	PostDTO cretePost(PostDTO postDTO, Integer userId, Integer categoryId);
//}

	//MonthlyScore createScore(MonthlyScore score, Integer Id, Integer Id1);

	//MonthlyScore createScore(MonthlyScore score, Long Id, Long Id1);

	MonthlyScoreDTO createScore(MonthlyScoreDTO score, Long Id, Long Id1);
	List<MonthlyScoreDTO>getStudentById(Long id);
	List<MonthlyScoreDTO> getSubjectById(Long id1);
	void deleteScore(Long id);
	List<MonthlyScoreDTO>getScoreList();
    MonthlyScore getById(Long id);
    MonthlyScoreDTO update(Long id, MonthlyScoreDTO monthlyScoreDTO);
}
