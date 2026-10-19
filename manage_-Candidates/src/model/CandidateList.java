package model;

import java.util.ArrayList;
import java.util.List;

public class CandidateList {
    private final List<Candidate> candidateList;

    public CandidateList() {
        this.candidateList = new ArrayList<>();
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public boolean addCandidate (Candidate candidate){
        if (candidate != null){
            return candidateList.add(candidate);
        }
        return false;
    }

    public boolean isIdExist (String id){
        for (Candidate c : candidateList){
            if (c.getCandidateId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }

    public List<Candidate> getByType(int type){
        List <Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList){
            if (c.getCandidateType() == type){
                result.add(c);
            }
        }
        return result;
    }

    public List<Candidate> search (String key, int type){
        List <Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList){
            if (c.getCandidateType() == type && (c.getFirstName().equalsIgnoreCase(key) ||
                    c.getLastName().equalsIgnoreCase(key))){
                result.add(c);
            }
        }
        return result;
    }


}
