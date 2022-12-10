package com.example.its.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
//        return List.of(
//                new IssueEntity(1,"課題1" , "説明1"),
//                new IssueEntity(2,"課題2" , "説明2"),
//                new IssueEntity(3,"課題3" , "説明3")
//        );
    }

    @Transactional
    public void create(String summary, String description) {
        issueRepository.insert(summary, description);
    }

    public IssueEntity findById(long issueId){
        return issueRepository.findById(issueId);
    }
}
