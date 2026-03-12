package com.klef.fsad.exam;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant
{
 @Id
 private int id;
 private String name;
 private String date;
 private String status;
 private String location;
 private double rating;

 public int getId() { return id; }
 public void setId(int id) { this.id = id; }

 public String getName() { return name; }
 public void setName(String name) { this.name = name; }

 public String getDate() { return date; }
 public void setDate(String date) { this.date = date; }

 public String getStatus() { return status; }
 public void setStatus(String status) { this.status = status; }

 public String getLocation() { return location; }
 public void setLocation(String location) { this.location = location; }

 public double getRating() { return rating; }
 public void setRating(double rating) { this.rating = rating; }
}
