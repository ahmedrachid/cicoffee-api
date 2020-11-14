package com.softkall.cicoffe.service;

import com.softkall.cicoffe.web.dto.input.CreateTeamDto;
import com.softkall.cicoffe.web.dto.output.TeamDto;

import java.util.Collection;
import java.util.UUID;

/**
 * @author Nidhal Dogga
 * @since 11/13/2020 10:16 PM
 * SoftKall™ All rights reserved.
 */


public interface TeamService {
  TeamDto createTeam(CreateTeamDto team, UUID authorId);
  void addMember(UUID authorId, UUID memberId, UUID teamId);
  Collection<TeamDto> myTeams();
}