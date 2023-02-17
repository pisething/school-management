package com.piseth.java.school.schoolmanagementpiseth.Service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.piseth.java.school.schoolManagement.exception.ResourceNotFoundException;
import com.piseth.java.school.schoolManagement.model.Subject;
import com.piseth.java.school.schoolManagement.repository.SubjectRepository;
import com.piseth.java.school.schoolManagement.service.SubjectService;
import com.piseth.java.school.schoolManagement.service.impl.SubjectServiceImpl;

import lombok.RequiredArgsConstructor;

/*@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)*/

@RequiredArgsConstructor
public class SubjectServiceTest {
//	@Mock
	private SubjectRepository repository;
	private  SubjectService service;
	private Subject subject;
	
	private Map<String,String> params;
	
	@BeforeEach
	public void setUp() {
		repository = mock(SubjectRepository.class);
		service = new SubjectServiceImpl(repository);
		subject = new Subject();
		subject.setId(1L);
		subject.setName("Math");
		
		
		
	}
	
	
	@Test
	public void saveTest() {
		//GIVEN
		
		//WHEN
		service.save(subject);
		
		when(repository.save(subject)).thenReturn(subject);

		//THEN
		verify(repository,times(1)).save(subject);
				
	}
	
	@Test
	public void getByID() {
		
		/*
		 * Get Success
		*/
        //GIVEN
		Long subjectId=1L;
		
		//WHEN
		when(repository.findById(subjectId)).thenReturn(Optional.of(subject));
		Subject sub = service.getById(subjectId);
		
		//THEN
		assertNotNull(sub);
		assertEquals(subjectId, sub.getId());
		assertEquals("Math", sub.getName());
		
		/*
		 * Fail Save
		*/
        //GIVEN
		Long subjectIdFail=6L;
		 
		
		//WHEN
		when(repository.findById(subjectIdFail))
								.thenReturn(Optional.empty());
		//THEN
		assertThatThrownBy(() -> service.getById(subjectIdFail)).isInstanceOf(ResourceNotFoundException.class).hasMessageStartingWith("subject not found for id=");
	
	}
	@Test
	public void deleteTest() {
				//GIVEN
				Long subjectIdForDelete=1L;
		
				//WHEN
//				when(repository.delete(subject)).thenReturn(Optional.of(subject));
		        when(repository.findById(subjectIdForDelete)).thenReturn(Optional.of(subject));
				service.delete(subjectIdForDelete);
				
				//THEN
				verify(repository,times(1)).delete(subject);
	}

	
	
}
