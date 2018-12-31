package org.arpit.java2blog.test;

import org.arpit.java2blog.SpringBootHibernateApplication;
import org.arpit.java2blog.model.Book;
import org.arpit.java2blog.model.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootHibernateApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LibraryManagementControllerTest
{

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;


	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void testGetAllBooks() throws Exception
	{

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getAllBooks").accept(MediaType.APPLICATION_JSON))
				.andExpect(model().attribute("book", any(Book.class)))
				.andReturn();
		Object listOfBooks = mvcResult.getModelAndView().getModel().get("listOfBooks");
		List<Book> bookList = (List<Book>) listOfBooks;
		System.out.println(bookList.size());
		assertThat(bookList.size(), is(2));
	}

	@Test
	public void addNewBook() throws Exception
	{
		Book book = new Book();
		book.setTitle("JAVA");
		book.setPrice(1000);
		book.setVolume(5);
		book.setPublishedDate(new Date());

		mockMvc.perform(MockMvcRequestBuilders.post("/addBook")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.flashAttr("book", book)
		).andReturn();

		MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.get("/getAllBooks").accept(MediaType.APPLICATION_JSON))
				.andExpect(model().attribute("book", any(Book.class)))
				.andReturn();
		Object listOfBooks = mvcResult1.getModelAndView().getModel().get("listOfBooks");
		List<Book> bookList = (List<Book>) listOfBooks;
		assertThat(bookList.size(), is(2));
	}

	@Test
	public void testGetBookById() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getBook/{bookId}",1004)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		Object bookObject = mvcResult.getModelAndView().getModel().get("book");
		Book book = (Book) bookObject;
		assertThat(book.getBookId(),is(1004L));
	}


	@Test
	public void testGetAllSubjects() throws Exception
	{

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getAllSubjects").accept(MediaType.APPLICATION_JSON))
				.andExpect(model().attribute("subject", any(Subject.class)))
				.andReturn();
		Object listOfSubjects = mvcResult.getModelAndView().getModel().get("listOfSubjects");
		List<Subject> subjectList = (List<Subject>) listOfSubjects;
		assertThat(subjectList.size(), is(3));
	}

	@Test
	public void addNewSubject() throws Exception
	{
		Subject subject = new Subject();
		subject.setSubjectId(101);
		subject.setSubTitle("ASP Tutorial");
		subject.setDurationInHours(10);
		mockMvc.perform(MockMvcRequestBuilders.post("/addSubject")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.flashAttr("subject", subject)
		).andReturn();

		MvcResult mvcResult1 = mockMvc.perform(MockMvcRequestBuilders.get("/getAllSubjects").accept(MediaType.APPLICATION_JSON))
				.andExpect(model().attribute("subject", any(Subject.class)))
				.andReturn();
		Object listOfSubjects = mvcResult1.getModelAndView().getModel().get("listOfSubjects");
		List<Subject> subjectList = (List<Subject>) listOfSubjects;
		assertThat(subjectList.size(), is(3));
	}

	@Test
	public void testGetSubjectById() throws Exception
	{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getSubject/{subjectId}",101)
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		Object subjectObj = mvcResult.getModelAndView().getModel().get("subject");
		Subject subject = (Subject) subjectObj;
		assertThat(subject.getSubjectId(),is(101l));
	}

}
