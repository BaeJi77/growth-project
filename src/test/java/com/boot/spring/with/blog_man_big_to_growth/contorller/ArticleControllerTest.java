package com.boot.spring.with.blog_man_big_to_growth.contorller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final String URL_PATH = "/articles";
    private final MediaType JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON;

    @Test
    public void isFailCreateArticleWithEmptyJson() throws Exception {
        mockMvc.perform(post(URL_PATH).contentType(JSON_CONTENT_TYPE).content("{}"))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    public void isFailCreateArticleWithoutTitle() throws Exception {
        String jsonWithoutTitle = "{\"contents\": \"hi\", \"backgrroundUrl\": \"hi\"}";
        mockMvc.perform(post(URL_PATH).contentType(JSON_CONTENT_TYPE).content(jsonWithoutTitle))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    public void isFailCreateArticleWithoutContents() throws Exception {
        String jsonWithoutContents = "{\"title\": \"hi\", \"backgrroundUrl\": \"hi\"}";
        mockMvc.perform(post(URL_PATH).contentType(JSON_CONTENT_TYPE).content(jsonWithoutContents))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    public void isSuccessCreateArticleWithoutBackgroundUrl() throws Exception {
        String jsonWithoutBackgroundUrl = "{\"title\": \"hi\", \"contents\": \"hi\"}";
        mockMvc.perform(post(URL_PATH).contentType(JSON_CONTENT_TYPE).content(jsonWithoutBackgroundUrl))
                .andExpect(status().is(302))
                .andDo(print());
    }

    @Test
    public void isSuccessCreateArticleWithCorrectJson() throws Exception {
        String jsonWithAllData = "{\"title\": \"hi\", \"contents\": \"hi\", \"backgrroundUrl\": \"hi\"}";
        mockMvc.perform(post(URL_PATH).contentType(JSON_CONTENT_TYPE).content(jsonWithAllData))
                .andExpect(status().is(302))
                .andDo(print());
    }
}