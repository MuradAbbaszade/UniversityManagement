package com.company.group.port;

import com.company.group.model.Group;
import com.company.group.usecase.DeleteGroup;
import com.company.group.usecase.RetrieveGroup;
import com.company.group.usecase.SaveGroup;

public interface GroupPort {
    Group retrieve(RetrieveGroup retrieveGroup) throws Exception;
    Group delete(DeleteGroup deleteGroup) throws Exception;
    Group save(SaveGroup saveGroup);
}
