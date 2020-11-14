package com.softkall.cicoffe.service.impl;

import com.softkall.cicoffe.model.entity.Member;
import com.softkall.cicoffe.model.entity.Team;
import com.softkall.cicoffe.model.repository.MemberRepository;
import com.softkall.cicoffe.model.repository.TeamRepository;
import com.softkall.cicoffe.service.TeamService;
import com.softkall.cicoffe.web.dto.input.CreateTeamDto;
import com.softkall.cicoffe.web.dto.output.MemberDto;
import com.softkall.cicoffe.web.dto.output.TeamDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Nidhal Dogga
 * @since 11/13/2020 10:18 PM
 * SoftKall™ All rights reserved.
 */


@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

  private final TeamRepository teamRepository;
  private final MemberRepository memberRepository;

  @Override
  public TeamDto createTeam(CreateTeamDto request, UUID authorId) {
    Member author = memberRepository
            .findById(authorId)
            .orElseThrow(IllegalStateException::new);
    Team team = teamRepository.save(Team.builder()
            .name(request.getName())
            .creator(author)
            .members(Collections.singletonList(author))
            .build()
    );
    return TeamDto.builder()
            .id(team.getId())
            .name(team.getName())
            .members(team.getMembers().stream()
                    .map(member -> MemberDto.builder()
                            .id(member.getId())
                            .email(member.getEmail())
                            .firstName(member.getFirstName())
                            .lastName(member.getLastName())
                            .build()
                    )
                    .collect(Collectors.toList())
            )
            .build();
  }

  @Override
  public void addMember(UUID authorId, UUID memberId, UUID teamId) {
    Team team = teamRepository
            .findById(teamId)
            .orElseThrow(IllegalAccessError::new);
    boolean userInTeam = team.getMembers().stream()
            .anyMatch(member -> member.getId() == authorId);
    if (!userInTeam) {
      throw new IllegalArgumentException();
    }
    Member member = memberRepository
            .findById(memberId)
            .orElseThrow(IllegalAccessError::new);
    team.getMembers().add(member);
  }

  @Override
  public Collection<TeamDto> myTeams() {
    return null;
  }

}
