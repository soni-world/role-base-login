package com.soni.rolebaselogin.service;

import com.soni.rolebaselogin.dto.ScheduleDto;
import com.soni.rolebaselogin.exception.ScheduleNotFoundException;
import com.soni.rolebaselogin.exception.UserIdNotFoundException;
import com.soni.rolebaselogin.model.ScheduleInfo;
import com.soni.rolebaselogin.model.UserInfo;
import com.soni.rolebaselogin.repository.ScheduleInfoRepo;
import com.soni.rolebaselogin.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private ScheduleInfoRepo scheduleInfoRepo;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public List<ScheduleDto> getAllSchedule() {
        List<ScheduleInfo> allSchedule =  scheduleInfoRepo.findAll();
        return allSchedule.stream().map(ScheduleDto :: new).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDto> getAllScheduleByUserId(Integer userId) {
        List<ScheduleInfo> allSchedule =  scheduleInfoRepo.findByUserId(userId);
        return allSchedule.stream().map(ScheduleDto :: new).collect(Collectors.toList());
    }

    @Override
    public Integer createSchedule(ScheduleDto scheduleDto) {
        Optional<UserInfo> userInfo = userInfoRepository.findById(scheduleDto.getUserId());
        if(!userInfo.isPresent()){
            throw new UserIdNotFoundException("given user id not found " +  scheduleDto.getUserId());
        }
        ScheduleInfo scheduleInfo = ScheduleInfo.builder().userId(scheduleDto.getUserId())
                .shiftLengthHours(scheduleDto.getShiftLengthHours())
                        .workDate(scheduleDto.getWorkDate()).build();
        ScheduleInfo info = scheduleInfoRepo.save(scheduleInfo);
        return info.getId();
    }


    @Override
    public String deleteSchedule(Integer scheduleId) {
        Optional<ScheduleInfo> scheduleInfo = scheduleInfoRepo.findById(scheduleId);
        if(!scheduleInfo.isPresent()){
            throw new ScheduleNotFoundException("given schedule id not found " +  scheduleId);
        }
        scheduleInfoRepo.deleteById(scheduleInfo.get().getId());
        return "Deleted successfully";
    }
}
