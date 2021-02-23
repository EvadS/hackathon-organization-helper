package com.se.hackathon.helper.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Organiser extends UserModel {
    private  String affiliation;
    private int openContestNumber;
    private  int totalContestNumber;
    private String website;

}
