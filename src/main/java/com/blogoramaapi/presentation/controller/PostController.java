package com.blogoramaapi.presentation.controller;

import com.blogoramaapi.application.dtos.req.PostReqDto;
import com.blogoramaapi.application.dtos.res.PostResDto;
import com.blogoramaapi.application.usecases.posts.CreatePostUseCase;
import com.blogoramaapi.application.usecases.posts.DeletePostsUseCase;
import com.blogoramaapi.application.usecases.posts.FindPostsUseCase;
import com.blogoramaapi.application.usecases.posts.UpdatePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(("/posts"))
@RequiredArgsConstructor
public class PostController {

    private final CreatePostUseCase createPostUseCase;
    private final FindPostsUseCase findPostsUseCase;
    private final UpdatePostUseCase updatePostUseCase;
    private final DeletePostsUseCase deletePostsUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostReqDto postReqDto, WebRequest request) {
        postReqDto.setUsername(getUserName(request));
        createPostUseCase.execute(postReqDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostResDto> findPosts() {
        return findPostsUseCase.findPosts();
    }

    @GetMapping("/my-posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostResDto> findMyPosts(WebRequest request) {
        String username = getUserName(request);
        return findPostsUseCase.findPostsByUsername(username);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable long id, @RequestBody PostReqDto postReqDto, WebRequest request) {
        String userName = getUserName(request);
        postReqDto.setUsername(userName);
        updatePostUseCase.execute(id, postReqDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@AuthenticationPrincipal UserDetails userDetails, @PathVariable long id) {
        deletePostsUseCase.deleteById(id, userDetails.getUsername());
    }

    private static String getUserName(WebRequest request) {
        return Objects.requireNonNull(request.getUserPrincipal()).getName();
    }
}
