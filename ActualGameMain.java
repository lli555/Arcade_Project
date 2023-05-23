public class ActualGameMain {
    public static void main(String[] args){
    
        JFrame arcade = new JFrame();
        arcade.setTitle("Dessert Desperation");
        arcade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new UserPanel(600, 450);
        
        Container pane = arcade.getContentPane();
        pane.setLayout(new GridLayout(1, 1));
        pane.add(panel);s

        arcade.pack();
        arcade.setVisible(true);
        panel.requestFocus();
    }
}