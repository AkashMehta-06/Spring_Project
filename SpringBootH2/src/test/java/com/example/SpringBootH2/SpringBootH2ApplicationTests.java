package com.example.SpringBootH2;



import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.SpringBootH2.controller.AccountController;
import com.example.SpringBootH2.controller.UserController;


@Nested
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SpringBootH2ApplicationTests {
	
	@InjectMocks
	UserController user;
	
	@InjectMocks
	AccountController account;
	
	@Autowired
	public MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	

	@Test
	@Order(1)
    public void createUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/createUser").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + 
                        "    \"username\": \"Akash\",\n" + 
                        "    \"status\": \"active\",\n" + 
                        "    \"firstName\": \"akash\",\n" + 
                        "    \"lastName\":\"kumar\",\n" + 
                        "    \"email\" : \"akash@gmail.com\",\n" +
                        "    \"createdBy\": \"2\",\n" + 
                        "    \"createdDate\": \"12-05-2019\",\n" + 
                        "    \"lastModifiedBy\":\"2\",\n" + 
                        "    \"lastModifiedDate\":\"15-07-2020\",\n" + 
                        "}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        
    }
	
	@Test
    @Order(2)
    public void getUserByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/getUserById/67"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
    @Order(3)
	public void getUserByEmailTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/getUserByEmail/akash@gmail.com"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
    @Order(4)
	public void updateUserByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/user/updateUserById/67"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
    @Order(5)
	public void deleteUserByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/deleteUserById/68"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}	
	
	@Test
    @Order(6)
	public void createAccountTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/account/createAccount").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + 
                        "    \"accountName\": \"Instagram\",\n" + 
                        "    \"owner\": \"67\",\n" + 
                        "    \"createdBy\": \"67\",\n" + 
                        "    \"createdDate\":\"12-01-2020\",\n" + 
                        "    \"lastModifiedBy\" : \"67\"\n" +
                        "    \"lastModifiedDate\": \"12-03-2020\",\n" + 
                        "}")
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
	
	@Test
    @Order(7)
	public void getAccountByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/account/getAccountById/132"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
    @Order(8)
	public void updateAccountByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/account/updateAccountById/132"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	

	
	@Test
    @Order(9)
	public void deleteAccountByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/account/deleteAccountById/132"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
