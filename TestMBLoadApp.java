import java.io.IOException;
    public class TestMBLoadApp {
        public static void main(String[] args)  throws IOException, ClassNotFoundException {
            MessageBoard board = new MessageBoard("blank");
            board.loadMessageBoard("codingsupport.ser");
            System.out.println();
            System.out.println("Displaying Loaded Board:");
            System.out.println(board.getBoardName()+":");
            int[] postIDs = board.getPostIDs();
            for (int ID : postIDs) {
                System.out.println(board.getFormattedPost(ID));
            }
            int[] windowsPosts = board.searchPostsBySubject("windows");   
            if (windowsPosts.length > 0) {
                int windowsPostID = windowsPosts[0];      
                board.savePostAsTextFile(windowsPostID, "windowspost.txt");
                System.out.println("windows post saved");
            } else {
                System.out.println("no windows post found");
            }
            
        }
    }

