package org.example.board.service;

import lombok.RequiredArgsConstructor;
import org.example.board.dto.MemberResponseDto;
import org.example.board.dto.SignUpRequestDto;
import org.example.board.dto.SignUpResponseDto;
import org.example.board.entity.Member;
import org.example.board.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 생성
    public SignUpResponseDto signUp (String username, String password, Integer age) {

        Member member = new Member(username, password, age);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(
                savedMember.getId(),
                savedMember.getUsername(),
                savedMember.getAge()
        );
    }

    //특정 회원 조회
    public MemberResponseDto findById(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);

        if(optionalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dose not exist id : " + id);
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(
                findMember.getUsername(),
                findMember.getAge()
        );
    }

    //비밀번호 수정 기능
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if(!findMember.getPassword().equals(oldPassword)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatePassword(newPassword);
    }
}
