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
        }
    }

