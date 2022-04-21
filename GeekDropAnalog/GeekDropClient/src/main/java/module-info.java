module ru.dediev.geekdrop.geekdropclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens ru.dediev.geekdrop.geekdropclient to javafx.fxml;
    exports ru.dediev.geekdrop.geekdropclient;
}