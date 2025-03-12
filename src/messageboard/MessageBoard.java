package messageboard;
import java.util.*;
import java.time.LocalDate;
import java.io.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;


public class MessageBoard implements MessageBoardInterface, Serializable {
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
    public int addPost(String author, String subject, String message, int epochDate) {
        LocalDate date = LocalDate.ofEpochDay(epochDate);
        Post nextPost = new Post(author, subject, message, date);
        posts.add(nextPost);
        return nextPost.getPostID();
    }
    public String getFormattedPost(int postID) throws IDInvalidException{
        // this should make use of getPostIndex to access the post
        // and print it using the .toFormattedString() method
        int index = getPostIndex(postID);
        return posts.get(index).toFormattedString();
    }
    public int[] searchPostsByDate(int startDate, int endDate) {
        List<Post> matchingPosts = new ArrayList<>();
        for(Post post : posts) {
            int postDate = post.getDate();
            if (postDate >= startDate && postDate <= endDate) {
                matchingPosts.add(post);
            }
        }
        int[] matched = new int[matchingPosts.size()];
        for (int i = 0; i < matchingPosts.size(); i++) {
            matched[i] = matchingPosts.get(i).getPostID();
        }
        return matched;
    }
    public int[] searchPostsBySubject(String searchWord) {
        String lowerSearchWord = searchWord.toLowerCase();
        List<Post> matchingPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getSubject().toLowerCase().contains(lowerSearchWord)) {
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
    public void saveMessageBoard(String filename) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        // store boardName attribute
        out.writeObject(boardName);
        // convert posts to array Post[] to simplifies the deserialization
        Post[] postArray = posts.toArray(new Post[posts.size()]);
        //  store Post array
        out.writeObject(postArray);
    } 
    public void loadMessageBoard(String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        boardName = (String) in.readObject();
        Post[] postArray = (Post[]) in.readObject();
        posts.clear();
        for (Post post : postArray) {
            posts.add(post);
        }
    }
    public void savePostAsTextFile(int postID, String filename) {
        Post post = posts.get(getPostIndex(postID));
        post.saveAsTextFile(filename);
    }
}   
