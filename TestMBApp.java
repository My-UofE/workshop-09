public class TestMBApp {
    public static void main(String[] args) {
        MessageBoard board = new MessageBoard("Coding Support");
        board.addPost("Alex Adams", "Help with Java", "Hi, could anyone help me I need to learn how to code in java!");
        board.addPost("Belinda Bennett", "Help with Java", "Hi Alex. Yes I can send some tutorials I found useful.");
        board.addPost("Cindy Carter", "Coding on a Chromebook", "Does anyone know how to set up Python on a chromebook?");
        board.addPost("Dennis Dobson", "Windows problems", "My windows laptop is stuck on a reboot loop. Does anyone know what to do!");
        int[] postIDs = board.getPostIDs();
        for (int id : postIDs) {
            System.out.println(board.getFormattedPost(id));
        }
    }
}