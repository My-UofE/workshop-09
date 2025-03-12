import java.io.IOException;

public class TestMBApp {
    public static void main(String[] args)  throws IOException {
        MessageBoard board = new MessageBoard("Coding Support");
        board.addPost("Alex Adams", "Help with Java", "Hi, could anyone help me I need to learn how to code in java!");
        board.addPost("Belinda Bennett", "Help with Java", "Hi Alex. Yes I can send some tutorials I found useful.");
        board.addPost("Cindy Carter", "Coding on a Chromebook", "Does anyone know how to set up Python on a chromebook?");
        board.addPost("Dennis Dobson", "Windows problems", "My windows laptop is stuck on a reboot loop. Does anyone know what to do!");
        int[] postIDs = board.getPostIDs();
        for (int id : postIDs) {
            System.out.println(board.getFormattedPost(id));
        }
        int[] searchedJava = board.searchPostsBySubject("Java");
        for (int javaID : searchedJava) {
            board.deletePost(javaID);
        }
        System.out.println("posts after deleting those containing 'Java' subject:");
        int[] remainingPosts = board.getPostIDs();
        for (int remainingID : remainingPosts) {
            System.out.println(board.getFormattedPost(remainingID));
        }
        board.addPost("Ellie", "Java IDE", "Can someone recommend a Java IDE?", 20148);
        board.addPost("Fred Fanshaw", "Java IDE", "I just use VS Code", 20149);
        int[] searchedBetweenDates = board.searchPostsByDate(20147 , 20149 );
        System.out.println("posts between dates selected:");
        for (int validID : searchedBetweenDates) {
            System.out.println(board.getFormattedPost(validID));
        }
        board.saveMessageBoard("codingsupport.ser");
    }
}