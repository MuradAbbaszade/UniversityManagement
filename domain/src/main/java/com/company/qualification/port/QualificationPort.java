package com.company.qualification.port;

import com.company.qualification.model.Qualification;
import com.company.qualification.usecase.DeleteQualification;
import com.company.qualification.usecase.RetrieveQualification;
import com.company.qualification.usecase.SaveQualification;

public interface QualificationPort {
    Qualification save(SaveQualification saveQualification);
    Qualification retrieve(RetrieveQualification retrieveQualification) throws Exception;
    Qualification delete(DeleteQualification deleteQualification) throws Exception;
}
