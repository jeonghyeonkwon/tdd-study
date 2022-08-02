package com.example.tddstudy.book.iloveyouboss;

import com.example.tddstudy.book.iloveyouboss.chapter7.BooleanQuestion;
import com.example.tddstudy.book.iloveyouboss.chapter7.Profile;
import com.example.tddstudy.book.iloveyouboss.chapter7.ProfilePool;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;

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
}
