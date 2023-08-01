package com.soni.rolebaselogin.repository;

import com.soni.rolebaselogin.model.ScheduleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleInfoRepo extends JpaRepository<ScheduleInfo, Integer> {
    List<ScheduleInfo> findByUserId(Integer userId);
}
