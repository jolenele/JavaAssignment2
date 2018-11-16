package assignment2;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Assignment2 extends Application implements EventHandler<ActionEvent> {
    private  Scene home,addScene,depositScene,withdrawScene,listScene,transferScene;
    Stage window;  // represents main Stage globally
    Button btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu,btnAdd,btnHome,btnListHome;
    TextField custName,custAccNum,custBalance,accountList;
    
    Bank bankMan;
    Account acc;
    
    Button btnWithdraw;
    TextField deposAmt,withdrawAmt,custToAccNum,custTransferAmt;
    
    //comment
    public void init(){
        
    }
    
    public void start(Stage primaryStage){
        window = primaryStage;
        
        // ==============setting up Home Scene===================
        Label lblHomeMenu = new Label("Welcome to Trusty Bank. Please select an option from below");
        
        btnAddMenu = new Button("Add");
        btnAddMenu.setOnAction(this);
        btnAddMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnDepositMenu = new Button("Deposit");
        btnDepositMenu.setOnAction(this);
        btnDepositMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnWithdrawMenu = new Button("Withdraw");
        btnWithdrawMenu.setOnAction(this);
        btnWithdrawMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnTransferMenu = new Button("Transfer");
        btnTransferMenu.setOnAction(this);
        btnTransferMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnListMenu = new Button("List");
        btnListMenu.setOnAction(this);
        btnListMenu.setMaxWidth(Double.MAX_VALUE);
        
        VBox homeLayout = new VBox();
        
        homeLayout.setAlignment(Pos.CENTER);    
        
        homeLayout.getChildren().addAll(lblHomeMenu,btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu);
        
        home = new Scene(homeLayout,500,500);
        
        //==========setting up Add Scene================
        Label lblAddMenu = new Label("Add Account");
        
        Label lblName =new Label("Name:");
        custName = new TextField();
        
        Label lblAccNum =new Label("Account#:");
        custAccNum=new TextField();
        
        Label lblBalance =new Label("Balance:");
        custBalance = new TextField();
        
        btnAdd = new Button("Add Account");
        btnAdd.setOnAction(this);
        
        btnHome = new Button("Back");
        btnHome.setOnAction(this);
        
        VBox addLayout =new VBox();
        
        addLayout.getChildren().addAll(lblAddMenu,lblName,custName,lblAccNum,custAccNum,lblBalance,custBalance,btnAdd,btnHome);
        
        addScene = new Scene(addLayout,500,500);
        
        // ===========setting up Deposit Scene==============
        Label lblAcNum = new Label("Account#:");
        custAccNum = new TextField();
        
        Label lblAmount = new Label("Desposit Amount:");
        deposAmt = new TextField();
        
        btnAdd = new Button("Deposit");
        btnAdd.setOnAction(this);
        
        btnHome = new Button("Back");   
        btnHome.setOnAction(this);
                       
        VBox depositLayout = new VBox();
        
        depositLayout.getChildren().addAll(lblAcNum,custAccNum,lblAmount,deposAmt,btnAdd,btnHome);
        
        depositScene = new Scene(depositLayout,500,500);
        
        window.setScene(home);
        window.show();
        
        //===============setting up Withdraw Scene==============
        Label lblAcccNum = new Label("Account#:");
        custAccNum = new TextField();
        
        Label lblWithdrawAmt = new Label("Withdraw Amount:");
        withdrawAmt = new TextField();
        
        btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(this);
        
        btnListHome = new Button("Back");
        btnListHome.setOnAction(this);
        
        btnListHome.setMaxWidth(Double.MAX_VALUE);
        
        VBox withdrawLayout =new VBox();
        
        withdrawLayout.getChildren().addAll(lblAcccNum,custAccNum,lblWithdrawAmt,withdrawAmt,btnListHome);
        
        withdrawScene = new Scene (withdrawLayout,500,500);
         
        window.setScene(home);
        window.show();
        
        //===============setting up Transfer Scene============
        Label lblFromAccNum = new Label("From Account#:");
        custAccNum = new TextField();
        
        Label lblToAccNum = new Label("To Account#:");
        custToAccNum = new TextField();
        
        Label lblTransferAmt = new Label("Transfer Amount:");
        custTransferAmt = new TextField();
                
        btnListHome = new Button("Back");
        btnListHome.setOnAction(this);
        
        btnListHome.setMaxWidth(Double.MAX_VALUE);
        
        VBox transferLayout =new VBox();
        
        transferLayout.getChildren().addAll(lblFromAccNum,custAccNum,lblToAccNum,custToAccNum,lblTransferAmt,custTransferAmt,btnListHome);
        
        transferScene = new Scene (transferLayout,500,500);
         
        window.setScene(home);
        window.show();
                
        // ===============setting up List Scene===============
        Label lblShow = new Label("List of accounts...");
        accountList = new TextField();
        
        btnListHome = new Button("Back");
        btnListHome.setOnAction(this);
        
        btnListHome.setMaxWidth(Double.MAX_VALUE);
        
        VBox listLayout =new VBox();
        
        listLayout.getChildren().addAll(lblShow,accountList,btnListHome);
        
        listScene = new Scene (listLayout,500,500);
         
        window.setScene(home);
        window.show();
    }
    
    public void stop(){
        
    }
    
    
    public void handle(ActionEvent e){
        
        if (e.getSource()==btnAddMenu){
            System.out.println("add Menu btn pressed (on menu scene)");
            window.setScene(addScene);                              
            if(e.getSource() == btnAdd){                
                //String cusName = String.valueOf(custName.getText());
                long accNum = Integer.valueOf(custAccNum.getText());
                double amt  = Integer.valueOf(custBalance.getText());
                acc = new Account(accNum,amt,custName.getText());                
            }
           
        }
        if(e.getSource() == btnWithdrawMenu){
            System.out.println("withdraw menu btn pressed");
            if(e.getSource() == btnWithdraw){
                long accNum = Long.valueOf(custAccNum.getText());
                double amt = Double.valueOf(withdrawAmt.getText());
                bankMan.withdrawAccount(accNum, amt);
            }
        }
        if(e.getSource() == btnTransferMenu){
            System.out.println("transfer menu btn pressed (on menu scene)");
            window.setScene(withdrawScene);
        }
        if(e.getSource()==btnDepositMenu){
            System.out.println("deposit menu pressed");
            window.setScene(depositScene);
        }
        if (e.getSource()==btnListMenu){
            System.out.println("list accounts btn pressed (on menu scene)");
            window.setScene(listScene);
        }
        if (e.getSource()==btnHome||e.getSource()==btnListHome){
            System.out.println("add account btn pressed (on add scene or list scene)");
            window.setScene(home);
        }  
        
    }
    
    public static void main(String[] args) {
      launch(args);
    }
    
}
