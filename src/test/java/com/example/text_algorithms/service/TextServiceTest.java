package com.example.text_algorithms.service;

import com.example.text_algorithms.domain.DataText;
import com.example.text_algorithms.domain.InformationText;
import com.example.text_algorithms.service.impl.TextServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Тест работы сервиса для поиска слов в тексте.
 *
 * @author Anton Mamakin
 **/
@RunWith(SpringRunner.class)
public class TextServiceTest {

    @Autowired
    private TextService service;

    private static final String type = "primitive";

    private final static List<String> words = List.of("1", "13");

    private static final String text = "11 1313 11 113 11 1 1 1 13 45 1 5 61 68 14 492 42 nvzfgzf a fa f3`1 fa fa";

    @Test
    public void get_count_words_test() {
        List<InformationText> countWords = service.getCountWords(type, createDataText());

        assertNotNull(countWords);
        assertThat(countWords.size(), is(2));
        assertThat(4, is(countWords.get(0).getCount()));
        assertThat(words.get(0), is(countWords.get(0).getWord()));
        assertThat(1, is(countWords.get(1).getCount()));
        assertThat(words.get(1), is(countWords.get(1).getWord()));
    }

    private DataText createDataText() {
        DataText result = new DataText();
        result.setText(text);
        result.setWords(words);

        return result;
    }

    @TestConfiguration
    @ComponentScan(basePackageClasses = {TextAlgorithmHandler.class, TextServiceImpl.class})
    static class TextServiceConfiguration {

        @Autowired
        List<TextAlgorithmHandler> handlers;

        @Bean
        public TextService service() {
            return new TextServiceImpl(handlers);
        }
    }
}
