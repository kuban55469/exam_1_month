package peacsoft.service;

import peacsoft.entity.Post;

import java.util.List;

public interface PostService {
    void savePost(Post post);
    Post getPostById(Long postId);
    List<Post> getAllPosts();

    String updatePost(Long postID, Post post);

    String deletePostById(Long postId);

    String editDescription(Long postId, String newDescription);
}
