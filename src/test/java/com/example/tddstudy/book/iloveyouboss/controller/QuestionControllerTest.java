package com.example.tddstudy.book.iloveyouboss.controller;

import com.example.tddstudy.book.iloveyouboss.chapter5.controller.QuestionController;
import com.example.tddstudy.book.iloveyouboss.chapter5.domain.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;
public class QuestionControllerTest {

    private QuestionController controller;

    @BeforeEach
    public void create(){
        controller = new QuestionController();
        controller.deleteAll();
    }
    @Test
    public void questionAnswersDateAdded(){
        Instant now = new Date().toInstant();
        controller.setClock(Clock.fixed(now, ZoneId.of("America/Denver")));
        int id = controller.addBooleanQuestion("text");
        Question question = controller.find(id);

        assertThat(question.getCreateTimestamp()).isEqualTo(now);
    }


}
