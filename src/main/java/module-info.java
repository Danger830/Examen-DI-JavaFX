module org.example.examendijavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.examendijavafx to javafx.fxml;
    exports org.example.examendijavafx;

}