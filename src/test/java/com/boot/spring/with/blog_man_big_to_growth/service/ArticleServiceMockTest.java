package com.boot.spring.with.blog_man_big_to_growth.service;


import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleRequestDto;
import com.boot.spring.with.blog_man_big_to_growth.dto.ArticleResponseDto;
import com.boot.spring.with.blog_man_big_to_growth.model.Article;
import com.boot.spring.with.blog_man_big_to_growth.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
public class ArticleServiceMockTest {
    // stream 으로 데이터 많이 만드도록 해서 하나말고 여러 가지의 테스트를 진행할 수 있도록

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleService articleService;

    @Test
    void isSuccessArticleUpdate() {
        //given
        Long id = 1L;
        ArticleRequestDto articleRequestDto = new ArticleRequestDto("new", "new", "new");
        ArticleResponseDto expectedArticleResponseDto = ArticleResponseDto.builder()
                                                .title("new")
                                                .backgroundUrl("new")
                                                .contests("new")
                                                .build();

        Optional<Article> optionalArticle = Optional.of(Article.builder().build());
        given(articleRepository.findById(any(Long.class))).willReturn(optionalArticle);

        //when
        ArticleResponseDto updateArticle = articleService.updateArticle(id, articleRequestDto);

        //then
        assertEquals(expectedArticleResponseDto, updateArticle);

        // 테스트를 짜면서 이상하지 않냐? mock을 함으로서 너가 만든 가짜 데이터가 나오도록 모든 로직이 돌아간다.
        // 이상하게도 테스트르 돌리는데 이상이 없도록 거의 돌아간다.
        // 나중에 추후 업데이트를 한다고 했을 경우 보증을 해주겠지만 나중에 굳이 이 메소드나 로직을 건드리는 것이 아니라
        // 새로운 로직을 만들어서 붙이거나 하는 것이 훨씬 안전할 것이다. 왜냐하면 여기 로직을 바꿔서 테스트를 통과하더라도
        // 테스트가 제대로 진행되지 않는 다른 곳에서는 에러가 나기 쉬울 것이다.
    }
}
