module org.example.shifumi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.shifumi to javafx.fxml;
    exports org.example.shifumi;
}