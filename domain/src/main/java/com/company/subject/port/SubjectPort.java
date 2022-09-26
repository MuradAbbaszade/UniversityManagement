package com.company.subject.port;

import com.company.subject.model.Subject;
import com.company.subject.usecase.DeleteSubject;
import com.company.subject.usecase.RetrieveSubject;
import com.company.subject.usecase.SaveSubject;

public interface SubjectPort {
    Subject retrieve(RetrieveSubject retrieveSubject);
    Subject delete(DeleteSubject deleteSubject);
    Subject save(SaveSubject saveSubject);
}
