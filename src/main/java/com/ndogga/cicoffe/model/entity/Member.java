package com.ndogga.cicoffe.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;


/**
 * @author Nidhal Dogga
 * @since 11/13/2020 6:57 PM
 * Prize & Fun™ All rights reserved.
 */


@Data
@Builder
@Entity(name = "members")
public class Member {
  @Id
  @GeneratedValue
  private UUID id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(unique = true)
  private String email;

  @Column(name = "password_hash")
  private String passwordHash;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "team_members",
          joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id")
  )
  private Collection<Team> teams;
}