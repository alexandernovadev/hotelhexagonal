package com.hotels.mart.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rating_id")
  private Long ratingId;

  @OneToOne
  @JoinColumn(name = "reservation_id")
  private Reservation reservation;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  private User user;

  @NotNull(message = "Rating is required")
  @Column(name = "rating")
  private Integer rating;

  @NotNull(message = "Comment rating is required")
  @Column(name = "comment")
  private String comment;
}
