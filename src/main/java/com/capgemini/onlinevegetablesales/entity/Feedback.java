package com.capgemini.onlinevegetablesales.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback_tbl")
public class Feedback {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int feedId;
    private int ratings;
    
    
    public Feedback() {
			
	}



	public Feedback(int feedId, int userid, int ratings) {
		super();
		this.feedId = feedId;
		this.ratings = ratings;
	}



	public int getFeedId() {
		return feedId;
	}



	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}


	public int getRatings() {
		return ratings;
	}



	public void setRatings(int ratings) {
		this.ratings = ratings;
	}



	@Override
	public String toString() {
		return "Feedback [feedId=" + feedId + ", ratings=" + ratings + "]";
	}
    
}



