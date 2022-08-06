package com.example.tddstudy.book.iloveyouboss;

import com.example.tddstudy.book.iloveyouboss.chapter7.*;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
public class ProfilePoolTest {
    private ProfilePool pool;
    private Profile langrsoft;
    private Profile smeltInc;
    private BooleanQuestion doTheyReimburseTuition;

    @BeforeEach
    public void create() {
        pool = new ProfilePool();
        langrsoft = new Profile("Langrsoft");
        smeltInc = new Profile("Smelt Inc.");
        doTheyReimburseTuition = new BooleanQuestion(1, "Reimburses tuition?");
    }

    @Test
    public void answersResultsInScoredOrder(){
        smeltInc.add(new Answer(doTheyReimburseTuition, Bool.FALSE));
        pool.add(smeltInc);
        langrsoft.add(new Answer(doTheyReimburseTuition, Bool.TRUE));
        pool.add(langrsoft);

        pool.score(soleNeed(doTheyReimburseTuition,Bool.TRUE,Weight.Important));

        List<Profile> ranked = pool.ranked();

        assertThat(ranked.toArray()).isEqualTo(new Profile[]{langrsoft,smeltInc});
    }

    private Criteria soleNeed(BooleanQuestion question, int value, Weight weight) {
        Criteria criteria = new Criteria();
        criteria.add(new Criterion(new Answer(question,value),weight));
        return criteria;
    }


}
