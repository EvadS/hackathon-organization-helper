package com.se.hackathon.helper.model;

import lombok.Data;

@Data
public class Organiser extends User{
    private  String affiliation;
    private int openContestNumber;
    private  int totalContestNumber;
    private String website;

}
