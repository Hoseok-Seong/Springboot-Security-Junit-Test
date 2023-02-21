package shop.mtcoding.loginexample.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.loginexample.dto.UserReqDto.JoinReqDto;
import shop.mtcoding.loginexample.dto.UserReqDto.LoginReqDto;
import shop.mtcoding.loginexample.model.User;
import shop.mtcoding.loginexample.model.UserRepository;
import shop.mtcoding.loginexample.util.HashEncoding;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 가입하기(JoinReqDto joinReqDto) {
        try {
            String sha256Hash = HashEncoding.sha256(joinReqDto.getPassword());
            userRepository.insert(joinReqDto.getUsername(), sha256Hash,
                    joinReqDto.getEmail());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("알고리즘을 찾을 수 없습니다: " + e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public User 로그인하기(LoginReqDto loginReqDto) {
        try {
            String sha256Hash = HashEncoding.sha256(loginReqDto.getPassword());
            User principal = userRepository.findByUsernameAndPassword(loginReqDto.getUsername(),
                    sha256Hash);
            return principal;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("알고리즘을 찾을 수 없습니다: " + e.getMessage());
        }
        return null;
    }

}
