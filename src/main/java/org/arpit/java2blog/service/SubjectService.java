package org.arpit.java2blog.service;

import org.arpit.java2blog.model.Subject;
import org.arpit.java2blog.repository.SubjectRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SubjectService
{

	@Autowired
	SubjectRepository subjectRepository;

	@Transactional
	public List<Subject> getAllSubjects() {
		List<Subject> subjects=new ArrayList<Subject>();
		Iterable<Subject> subjectsIterable=subjectRepository.findAll();
		Iterator<Subject> subjectsIterator=subjectsIterable.iterator();
		while(subjectsIterator.hasNext())
		{
			subjects.add(subjectsIterator.next());
		}
		return subjects;
	}

	@Transactional
	public Subject getSubject(int id) {
		return subjectRepository.findById(new Long(id)).get();

	}

	@Transactional
	public void addSubject(Subject subject) {
		subjectRepository.save(subject);
	}

	@Transactional
	public void updateSubject(Subject subject) {
		subjectRepository.save(subject);

	}

	@Transactional
	public void deleteSubject(int id) {

		subjectRepository.deleteById(new Long(id));
	}
}
