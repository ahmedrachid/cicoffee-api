package com.softkall.cicoffe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;


/**
 * @author Nidhal Dogga
 * @created 11/13/2020 9:43 PM
 * SoftKall™ All rights reserved.
 */


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {
  @Id
  @GeneratedValue
  private UUID id;

  @ManyToOne
  private Session session;

  @ManyToOne
  private Member member;

  @OneToMany
  private Collection<OrderItem> items;
}
