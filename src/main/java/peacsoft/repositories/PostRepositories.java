package peacsoft.repositories;

import peacsoft.entity.InstagramAccount;
import peacsoft.entity.Post;

import java.util.List;

public interface PostRepositories {

    void savePost(Post post);
    Post getPostById(Long postId);
    List<Post> getAllPosts();

    String updatePost(Long postID, Post post);

    String deletePostById(Long postId);

    String editDescription(Long postId, String newDescription);
}
