package miridih;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import miridih.controller.CanvasController;
import miridih.model.CanvasModel;
import miridih.view.Canvas;
import miridih.view.ToolPanel;

public class App {
    public static void main(String[] args) {
        CanvasModel canvasModel = new CanvasModel();
        CanvasController canvasController = new CanvasController(canvasModel);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paint");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // 캔버스
            Canvas canvas = new Canvas(canvasController);
            frame.add(canvas, BorderLayout.CENTER);

            // 패널
            ToolPanel toolPanel = new ToolPanel(canvasController);

            frame.add(toolPanel, BorderLayout.WEST);
            frame.setVisible(true);
        });
    }
}