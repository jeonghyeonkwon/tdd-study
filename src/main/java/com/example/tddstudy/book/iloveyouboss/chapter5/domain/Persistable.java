package com.example.tddstudy.book.iloveyouboss.chapter5.domain;

import java.time.Instant;

public interface Persistable {
    Integer getId();
    void setId(Integer id);
    Instant getCreateTimestamp();
    void setCreateTimestamp(Instant instant);
}
