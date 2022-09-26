package com.company.adapters.subject.jpa;

import com.company.adapters.subject.jpa.entity.SubjectEntity;
import com.company.adapters.subject.jpa.repository.SubjectJpaRepository;
import com.company.subject.model.Subject;
import com.company.subject.port.SubjectPort;
import com.company.subject.usecase.DeleteSubject;
import com.company.subject.usecase.RetrieveSubject;
import com.company.subject.usecase.SaveSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectAdapter implements SubjectPort {

    private final SubjectJpaRepository subjectJpaRepository;
    @Override
    public Subject retrieve(RetrieveSubject retrieveSubject) throws Exception {
        return subjectJpaRepository.findById(retrieveSubject.getId())
                .map(SubjectEntity::toModel)
                .orElseThrow(()->new Exception("Subject not found"));
    }

    @Override
    public Subject delete(DeleteSubject deleteSubject) throws Exception {
        Subject subject = subjectJpaRepository.findById(deleteSubject.getId())
                .map(SubjectEntity::toModel)
                .orElseThrow(()->new Exception("Subject not found"));
        subjectJpaRepository.deleteById(deleteSubject.getId());
        return subject;

    }

    @Override
    public Subject save(SaveSubject saveSubject) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(saveSubject.getId());
        subjectEntity.setName(saveSubject.getName());
        return subjectJpaRepository.save(subjectEntity).toModel();
    }
}
