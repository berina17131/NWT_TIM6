package com.example.interaction_management.Service;

import com.example.interaction_management.Model.Status;
import com.example.interaction_management.Repository.StatusRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAll() throws ServiceException {
        try {
            return statusRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Cannot fetch all statuses.");
        }
    }

    public Status getById(String id) throws ServiceException {
        try {
            Optional statusHelp = statusRepository.findById(Integer.parseInt(id));
            Status status = (Status) statusHelp.get();

            return status;
        } catch (Exception e) {
            throw new ServiceException("Cannot find status with id={" + id + "}");
        }
    }

    public String deleteAll() throws ServiceException {
        try {
            statusRepository.deleteAll();
            return "All statuses deleted";

        } catch (Exception e) {
            throw new ServiceException("Cannon delete all statuses");
        }
    }

    public String deleteById(String id) throws ServiceException {
        try {
            statusRepository.deleteById(Integer.parseInt(id));
            return "Status with id=" + id + " deleted";

        } catch (Exception e) {
            throw new ServiceException("Cannot delete status with id={" + id + "}");
        }
    }

    public String postByStatus(String st) throws ServiceException {
        try {
            Status status;
            status = new Status(st);
            statusRepository.save(status);

            return "Status=" + st + " saved successfully";
        } catch (Exception e) {
            throw new ServiceException("Cannot save status={" + st + "}");
        }
    }

    public String putById(String id, String newStatus) throws ServiceException {
        try {
            Optional statusHelp = statusRepository.findById(Integer.parseInt(id));
            Status status = (Status) statusHelp.get();
            status.setSt(newStatus);
            statusRepository.save(status);
            return "Status with id=" + id + " changed to " + newStatus;
        } catch (Exception e) {
            throw new ServiceException("Cannot change status.");
        }
    }

    public String createStatus(Status status) throws ServiceException {
        try {
            statusRepository.save(status);

            return "Status = " + status.getSt() + " saved successfully";
        } catch (Exception e) {
            throw new ServiceException("Cannot create status = " + status.getSt() + ".");
        }
    }

    public String putStatus(Status statusFromRequest) throws ServiceException {
        try {
            Optional statusHelp = statusRepository.findById(statusFromRequest.getId());
            Status status = (Status) statusHelp.get();
            status.setSt(statusFromRequest.getSt());
            statusRepository.save(status);

            return "Status with id= " + status.getId() + " saved successfully as " + status.getSt();
        } catch (Exception e) {
            throw new ServiceException("Cannot update status with id = " + statusFromRequest.getId() + ".");
        }
    }
}
