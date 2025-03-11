import java.util.*;
import java.time.LocalDate;
import java.io.*;
import java.time.format.DateTimeFormatter;


public class MessageBoard implements Serializable {
    private List<Post> posts;
    private String boardName;

    public MessageBoard(String boardName) {
        this.boardName = boardName;
        this.posts = new ArrayList<>();
    }
    public String getBoardName() {
        return boardName;
    }

    public int[] getPostIDs() {
        int[] postIDs = new int[posts.size()];
        int i = 0;
        for (Post post : posts) {
            postIDs[i++] = post.getPostID();
        }
        return postIDs;
    }

    public int getPostIndex(int postID) throws IDInvalidException {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getPostID() == postID) {
                return i;
            }
        }
        throw new IDInvalidException("Invalid post ID.");
    }
    public int addPost(String author, String subject, String message){
        // this should create a new post and add it to the posts ArrayList
        Post nextPost = new Post(author, subject, message);
        posts.add(nextPost);
        return nextPost.getPostID();
    }
    public String getFormattedPost(int postID) throws IDInvalidException{
        // this should make use of getPostIndex to access the post
        // and print it using the .toFormattedString() method
        int index = getPostIndex(postID);
        return posts.get(index).toFormattedString();
    }
    public int[] searchPostsBySubject(String searchWord) {
        List<Post> matchingPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getSubject().contains(searchWord)) {
                matchingPosts.add(post);
            }
        }
        int[] matched = new int[matchingPosts.size()];
        for (int i = 0; i < matchingPosts.size(); i++) {
            matched[i] = matchingPosts.get(i).getPostID();
        }
        return matched;
    }
    public void deletePost(int postID) {
        int index = getPostIndex(postID);
        posts.remove(index);
    }
}