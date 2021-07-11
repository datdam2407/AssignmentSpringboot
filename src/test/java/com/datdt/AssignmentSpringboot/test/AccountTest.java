// package com.datdt.AssignmentSpringboot.test;

// import static org.mockito.Mockito.when;

// import java.util.Arrays;
// import java.util.Date;
// import java.util.List;

// import com.datdt.AssignmentSpringboot.controller.AccountController;
// import com.datdt.AssignmentSpringboot.entity.Account;
// import com.datdt.AssignmentSpringboot.service.AccountService;

// import org.junit.Before;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.test.web.servlet.MockMvc;

// public class AccountTest {
//     private MockMvc mockMvc;

//     @Mock
//     private AccountService accService;

//     @InjectMocks
//     private AccountController accController;

  
    
//     @Test
// public void test_get_all_success() throws Exception {
//     List<Account> users = Arrays.asList(
//             new Account("datddtt", "datdan", "123456", "dat1dam@gmail.com", "acpected", "q1", "0123456789", new Date()),
//             new Account("datddtt11", "datdan", "123456", "dat1dam111@gmail.com", "acpected", "q1", "0123456789", new Date()),
            
//     when(accService.getAccountByUsername("datddtt")).thenReturn(users);
//     mockMvc.perform(get("/users"))
//             .andExpect(status().isOk())
//             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//             .andExpect(jsonPath("$", hasSize(2)))
//             .andExpect(jsonPath("$[0].id", is(1)))
//             .andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
//             .andExpect(jsonPath("$[1].id", is(2)))
//             .andExpect(jsonPath("$[1].username", is("John Snow")));
//     verify(accService, times(1)).getAll();
//     verifyNoMoreInteractions(accService);
// }
// }
