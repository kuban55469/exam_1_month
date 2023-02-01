package peacsoft.service.impl;

import peacsoft.entity.Post;
import peacsoft.repositories.PostRepositories;
import peacsoft.repositories.impl.PostImpl;
import peacsoft.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    PostRepositories postRepositories = new PostImpl();
    @Override
    public void savePost(Post post) {
        postRepositories.savePost(post);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepositories.getPostById(postId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepositories.getAllPosts();
    }

    @Override
    public String updatePost(Long postID, Post post) {
        return postRepositories.updatePost(postID,post);
    }

    @Override
    public String deletePostById(Long postId) {
        return postRepositories.deletePostById(postId);
    }

    @Override
    public String editDescription(Long postId, String newDescription) {
        return postRepositories.editDescription(postId, newDescription);
    }
}
