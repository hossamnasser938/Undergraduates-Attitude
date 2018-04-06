package com.example.android.undergraduatesattitude;


import java.util.ArrayList;

/**
 *
 * @author abdelkhalik
 */
public enum Category {

    HEALTH(KnowledgeBase.Healthy),
    LIFE(KnowledgeBase.Life),
    EDUCATIONAL(KnowledgeBase.Educational),
    RESPONSIBILITY(KnowledgeBase.Responsibility),
    ENTERTAINMENT(KnowledgeBase.Entertainment),
    SKILLS(KnowledgeBase.Skills);

    private ArrayList<String> activities;

    Category() {
    }

    Category(ArrayList<String> activity) {
        this.activities = activity;
    }

}
