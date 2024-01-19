package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.CardMembership;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardMembershipRepository extends JpaRepository<CardMembership, Integer> {



}